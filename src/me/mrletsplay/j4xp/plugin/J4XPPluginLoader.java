package me.mrletsplay.j4xp.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.mrletsplay.j4xp.J4XP;

public class J4XPPluginLoader {

	private static J4XPPluginLoader instance;
	
	static {
		instance = new J4XPPluginLoader();
	}
	
	private List<XPPlugin> plugins;
	
	public J4XPPluginLoader() {
		this.plugins = new ArrayList<>();
	}
	
	public List<XPPlugin> getEnabledPlugins() {
		return plugins.stream().filter(XPPlugin::isEnabled).collect(Collectors.toList());
	}
	
	public List<XPPlugin> getPlugins() {
		return plugins;
	}
	
	public XPPlugin loadPlugin(File pluginFile) {
		J4XP.log("Loading plugin " + pluginFile);
		JARLoader l = new JARLoader(pluginFile);
		try {
			Class<?> mainClass = l.getJ4XPMainClass();
			if(!XPPlugin.class.isAssignableFrom(mainClass)) throw new PluginLoadingException("Plugin doesn't extend XPPlugin");
			XPPlugin pl = (XPPlugin) mainClass.newInstance();
			pl.setEnabled(true);
			plugins.add(pl);
			J4XP.log("Plugin loaded!");
			return pl;
		} catch (Exception /*| ClassNotFoundException | IOException | InstantiationException | IllegalAccessException*/ e) {
			throw new PluginLoadingException("Failed to load plugin", e);
		}
	}
	
	public List<XPPlugin> loadPlugins(List<File> pluginFiles) {
		List<XPPlugin> pls = pluginFiles.stream().map(f -> {
				try {
					return loadPlugin(f);
				}catch(PluginLoadingException e) {
					J4XP.log("Failed to load pl @ " + f.getAbsolutePath() + ": " + e.getClass().getName() + ": " + e.getMessage());
					J4XP.log(e);
					return null;
				}
			})
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
		plugins.addAll(pls);
		return pls; 
	}
	
	public void disableAllPlugins() {
		for(XPPlugin pl : getPlugins()) {
			if(pl.isEnabled()) pl.setEnabled(false);
		}
	}
	
	public void loadPlugins() {
		J4XPPluginLoader.getInstance().loadPlugins(Arrays.asList(J4XP.getPluginFolder().listFiles()));
	}
	
	public void reloadPlugins() {
		disableAllPlugins();
		plugins.clear();
		loadPlugins();
	}
	
	public static J4XPPluginLoader getInstance() {
		return instance;
	}
	
}
