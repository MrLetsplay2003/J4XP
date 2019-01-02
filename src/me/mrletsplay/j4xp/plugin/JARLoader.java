package me.mrletsplay.j4xp.plugin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.J4XPLogLevel;

public class JARLoader extends ClassLoader {

	public static long totalBytesLoaded = 0;

	private URL jarURL;
	private ClassLoader parent;
	private File file;
	private HashMap<String, byte[]> loadedClasses = new HashMap<>();
	private long bytesLoaded = 0;

	public JARLoader(File file) {
		try {
			this.jarURL = new URL("jar", "", file.toURI().toURL() + "!/");
			this.file = file;
			this.parent = JARLoader.class.getClassLoader();
			loadAllClasses();
		} catch (IOException e) {
			throw new PluginLoadingException("Failed to load plugin", e);
		}
	}
	
	public boolean ownsClass(String fullName) {
		return loadedClasses.containsKey(fullName);
	}

	private void loadAllClasses() {
		try {
			JarURLConnection jarConnection = (JarURLConnection) jarURL.openConnection();
			jarConnection.setDefaultUseCaches(false);
			JarFile jarFile = jarConnection.getJarFile();
			loadClasses(jarFile);
			jarFile.close();
		} catch (IOException e) {
			throw new PluginLoadingException("Failed to load classes", e);
		}
	}

	private void loadClasses(JarFile jarFile) throws IOException {
		Enumeration<JarEntry> ent = jarFile.entries();
		while (ent.hasMoreElements()) {
			JarEntry e = ent.nextElement();
			if (e.getName().endsWith(".class")) {
				ByteArrayOutputStream o = new ByteArrayOutputStream();
				InputStream in = jarFile.getInputStream(e);
				byte[] buf = new byte[4096];
				int len;
				while ((len = in.read(buf)) > 0) {
					o.write(buf, 0, len);
				}
				in.close();
				String className = e.getName().replace('/', '.').substring(0, e.getName().length() - ".class".length());
				definePackage(className);
				byte[] classData = o.toByteArray();
				loadedClasses.put(className, classData);
			}
		}
		bytesLoaded = loadedClasses.values().stream().mapToInt(i -> i.length).sum();
		totalBytesLoaded += bytesLoaded;
		J4XP.log(bytesLoaded / 1024 + " kb of classes loaded");
	}

	private void definePackage(String className) {
		String pName = className;
		if (pName.contains(".")) {
			pName = className.substring(0, className.lastIndexOf('.'));
		}
		if (getPackage(pName) != null)
			return;
		definePackage(pName, null, null, null, null, null, null, null);
	}

	@Override
	protected URL findResource(String name) {
		try {
			name = name.replace("/\\", "/");
			try {
				JarURLConnection tmpCon = (JarURLConnection) jarURL.openConnection();
				tmpCon.setDefaultUseCaches(false);
				JarFile f = tmpCon.getJarFile();
				List<String> pth = new ArrayList<>(Arrays.asList(name.split("/")));
				String fName = pth.remove(pth.size() - 1);
				while (true) {
					String path = pth.stream().collect(Collectors.joining("/"));
					path += (!path.isEmpty() ? "/" : "") + fName;
					JarEntry ent = f.getJarEntry(path);
					if (ent != null) {
						f.close();
						return new URL(jarURL, path);
					}
					if (!pth.isEmpty()) {
						pth.remove(pth.size() - 1);
					} else {
						break;
					}
				}
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new URL(jarURL + name);
		} catch (MalformedURLException e) {
			throw new PluginException(e);
		}
	}

	@Override
	public URL getResource(String name) {
		return super.getResource(name);
	}

	public Class<?> getJavaMainClass() throws IOException, ClassNotFoundException {
		JarURLConnection con = (JarURLConnection) jarURL.openConnection();
		con.setDefaultUseCaches(false);
		Attributes attr = con.getMainAttributes();
		if (attr == null) {
			con.getJarFile().close();
			return null;
		}
		String name = attr.getValue(Attributes.Name.MAIN_CLASS);
		if (name == null) {
			con.getJarFile().close();
			return null;
		}
		con.getJarFile().close();
		return loadClass(name);
	}

	public Class<?> getJ4XPMainClass() throws IOException, ClassNotFoundException {
		PluginDescription desc = loadDescription();
		J4XP.log("Loading main class: " + desc.getMain());
		return loadClassInternally(desc.getMain(), false);
	}
	
	public PluginDescription loadDescription() {
		return loadDescription(file);
	}

	public File getFile() {
		return file;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if (loadedClasses.containsKey(name)) {
			byte[] classBuf = loadedClasses.get(name);
			return defineClass(name, classBuf, 0, classBuf.length);
		} else {
			throw new ClassNotFoundException("Couldn't find class: " + name);
		}
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loadClassInternally(name, true);
	}

	public Class<?> loadClassInternally(String name, boolean usePluginClasses) throws ClassNotFoundException {
		try {
			return super.loadClass(name);
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			try {
				return parent.loadClass(name); // If class is not found in the jar, return it from this classloader
			} catch (ClassNotFoundException e1) {
				J4XP.log(J4XPLogLevel.ERROR, "Class " + name + " not found in parent class loader");
				if (!usePluginClasses)
					throw e1;
				return loadClassFromPlugins(name); // If class is not found in this classloader, try to load it from other plugins
			}
		}
	}

	public Class<?> loadClassFromPlugins(String name) {
		Class<?> clazz = null;
		for (XPPlugin ex : J4XP.getPluginLoader().getEnabledPlugins()) {
			try {
				clazz = ex.getLoader().loadClassInternally(name, false);
			} catch (ClassNotFoundException | NoClassDefFoundError ignored) {}
		}
		return clazz;
	}

	public static PluginDescription loadDescription(File jarFile) {
		PluginDescription desc;
		try {
			JarURLConnection con = (JarURLConnection) new URL("jar", "", jarFile.toURI().toURL() + "!/")
					.openConnection();
			JarFile jf = con.getJarFile();
			InputStream in = jf.getInputStream(jf.getEntry("plugin.yml"));
			desc = PluginDescription.load(in);
			in.close();
			jf.close();
			return desc;
		} catch (IOException e) {
			throw new PluginLoadingException("Couldn't load plugin description", e);
		}
	}

}
