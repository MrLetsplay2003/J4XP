package me.mrletsplay.j4xp.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPPluginLoader {

	private static XPPluginLoader instance;
	
	static {
		instance = new XPPluginLoader();
	}
	
	private List<XPPlugin> plugins;
	
	public XPPluginLoader() {
		this.plugins = new ArrayList<>();
	}
	
	public List<XPPlugin> getEnabledPlugins() {
		return plugins.stream().filter(XPPlugin::isEnabled).collect(Collectors.toList());
	}
	
	public List<XPPlugin> getPlugins() {
		return plugins;
	}
	
	public XPPlugin loadPlugin(File pluginFile) {
		J4XP.log("Load pl " + pluginFile);
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
					e.printStackTrace(J4XP.getLogWriter());
					return null;
				}
			})
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
		plugins.addAll(pls);
		return pls;
	}
	
	public void unloadAllPlugins() {
		for(XPPlugin pl : getPlugins()) {
			if(pl.isEnabled()) pl.setEnabled(false);
		}
	}
	
	public static XPPluginLoader getInstance() {
		return instance;
	}
	
}
