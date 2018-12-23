package me.mrletsplay.j4xp.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.entity.widget.WidgetButton;
import me.mrletsplay.j4xp.entity.widget.WidgetCaption;
import me.mrletsplay.j4xp.entity.widget.WidgetMainWindow;
import me.mrletsplay.j4xp.entity.widget.builder.ButtonBehavior;
import me.mrletsplay.j4xp.entity.widget.builder.ButtonType;
import me.mrletsplay.j4xp.entity.widget.builder.MainWindowType;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetCloseAction;

public class J4XPPluginLoader {

	private static J4XPPluginLoader instance;
	
	private WidgetMainWindow pluginManagerWidget;
	private List<WidgetCaption> pluginNameWidgets;
	private List<WidgetButton> pluginStateWidgets;
	private int offset;
//	private boolean needsUpdate;
	
	static {
		instance = new J4XPPluginLoader();
	}
	
	private List<XPPlugin> plugins;
	
	public J4XPPluginLoader() {
		this.plugins = new ArrayList<>();
		this.pluginNameWidgets = new ArrayList<>();
		this.pluginStateWidgets = new ArrayList<>();
		this.pluginManagerWidget = WidgetBuilder.newMainWindowBuilder()
				.withBounds(100, 500, 800, 100)
				.withCloseBoxes(true)
				.withAutoHandleClose(WidgetCloseAction.HIDE)
				.withWindowType(MainWindowType.DEFAULT)
				.withDescriptor("J4XP Plugin Manager")
				.withVisibility(true)
				.create();

			WidgetBuilder.newScrollBarBuilder()
				.withBounds(780, 480, 800, 100)
				.withScrollBarMin(0)
				.withScrollBarMax(200)
				.withRootStatus(false)
				.withContainer(pluginManagerWidget)
				.withDescriptor("")
				.withVisibility(true)
				.onSliderPositionChanged(w -> {
					offset = w.getSliderPosition();
//					needsUpdate = true;
					updateLog();
					return true;
				})
				.create();
		
		int nL = 19;
		for(int i = 0; i < nL; i++) {
			final int fI = i;
			WidgetCaption c = WidgetBuilder.newCaptionBuilder()
				.withBounds(100, 480 - i * 20, 760, 460 - i * 20)
				.withRootStatus(false)
				.withContainer(pluginManagerWidget)
				.withDescriptor("Plugin Name")
				.create();
			pluginNameWidgets.add(0, c);
			WidgetButton b = WidgetBuilder.newButtonBuilder()
					.withBounds(760, 480 - i * 20, 780, 460 - i * 20)
					.withRootStatus(false)
					.withBehavior(ButtonBehavior.CHECK_BOX)
					.withType(ButtonType.RADIO_BUTTON)
					.withContainer(pluginManagerWidget)
					.withDescriptor("")
					.onButtonStateChanged((btn, state) -> {
						int idx = fI + offset;
						if(idx < 0 || idx >= J4XP.getPluginLoader().getPlugins().size()) {
							return true;
						}
						XPPlugin l = J4XP.getPluginLoader().getPlugins().get(idx);
						if(l != null) {
							l.setEnabled(state);
						}
//						needsUpdate = true;
						return true;
					})
					.create();
			pluginStateWidgets.add(0, b);
		}
	}
	
	public void updateLog() {
//		if(!needsUpdate) return; TODO
		for(int i = 0; i < pluginNameWidgets.size(); i++) {
			int idx = i + offset;
			if(idx < 0 || idx >= J4XP.getPluginLoader().getPlugins().size()) {
				pluginNameWidgets.get(i).setDescriptor("");
				pluginStateWidgets.get(i).hide();
				continue;
			}
			XPPlugin l = J4XP.getPluginLoader().getPlugins().get(idx);
			if(l != null) {
				pluginNameWidgets.get(i).setDescriptor(l.getName());
				pluginStateWidgets.get(i).show();
				pluginStateWidgets.get(i).setState(l.isEnabled());
			}
		}
//		needsUpdate = false;
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
			plugins.add(pl);
			try {
				pl.setEnabled(true);
			}catch(Exception e) {
				plugins.remove(pl);
			}
			J4XP.log("Plugin loaded!");
			return pl;
		} catch (Exception e) {
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
//		plugins.addAll(pls);
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
