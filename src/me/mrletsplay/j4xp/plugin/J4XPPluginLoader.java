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
import me.mrletsplay.j4xp.entity.widget.builder.MainWindowWidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.TextFieldType;
import me.mrletsplay.j4xp.entity.widget.builder.TextFieldWidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetCloseAction;
import me.mrletsplay.j4xp.natives.enums.XPLMFontID;

public class J4XPPluginLoader {

	private WidgetMainWindow pluginManagerWidget;
	private List<WidgetCaption> pluginNameWidgets;
	private List<WidgetButton> pluginStateWidgets, pluginInfoButtonWidgets;
	private int offset;
	private boolean needsUpdate;
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
				.withScrollBarMax(10)
				.withRootStatus(false)
				.withContainer(pluginManagerWidget)
				.withDescriptor("")
				.withVisibility(true)
				.onSliderPositionChanged(w -> {
					offset = w.getSliderPosition();
					needsUpdate = true;
					updateLog();
					return true;
				})
				.create();
		
		int nL = 19;
		for(int i = 0; i < nL; i++) {
			final int fI = i;
			WidgetCaption nameCaption = WidgetBuilder.newCaptionBuilder()
				.withBounds(100, 480 - i * 20, 700, 460 - i * 20)
				.withRootStatus(false)
				.withContainer(pluginManagerWidget)
				.withDescriptor("")
				.create();
			pluginNameWidgets.add(nameCaption);
			
			WidgetButton stateButton = WidgetBuilder.newButtonBuilder()
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
						return true;
					})
					.create();
			pluginStateWidgets.add(stateButton);
			
			WidgetButton infoButton = WidgetBuilder.newButtonBuilder()
					.withBounds(700, 480 - i * 20, 760, 460 - i * 20)
					.withRootStatus(false)
					.withBehavior(ButtonBehavior.PUSH_BUTTON)
					.withType(ButtonType.PUSH_BUTTON)
					.withContainer(pluginManagerWidget)
					.withDescriptor("")
					.onPushButtonPressed(button -> {
						WidgetMainWindow popup = new MainWindowWidgetBuilder()
								.withBounds(100, 300, 300, 100)
								.withCloseBoxes(true)
								.withAutoHandleClose(WidgetCloseAction.DESTROY)
								.withWindowType(MainWindowType.TRANSLUCENT)
								.withDescriptor("Plugin Info")
								.withVisibility(true)
								.create();
						
//						new CaptionWidgetBuilder()
//								.withRootStatus(false)
//								.withContainer(popup)
//								.withBounds(100, 300, 300, 100)
//								.withVisibility(true)
//								.withLitStatus(true)
//								.withDescriptor("Hello world!")
//								.create();
						
						new TextFieldWidgetBuilder()
								.withRootStatus(false)
								.withContainer(popup)
								.withBounds(100, 300, 300, 100)
								.withVisibility(true)
								.withType(TextFieldType.TRANSPARENT)
								.withFont(XPLMFontID.LED)
								.withDescriptor("Hello world!2")
								.create();
						return true;
					})
					.create();
			pluginInfoButtonWidgets.add(infoButton);
		}
	}
	
	public void updateLog() {
		if(!needsUpdate) return;
//		if(!pluginManagerWidget.isVisible()) return;
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
		needsUpdate = false;
	}
	
	public void updateWidget() {
		needsUpdate = true;
	}
	
	public List<XPPlugin> getEnabledPlugins() {
		return plugins.stream().filter(XPPlugin::isEnabled).collect(Collectors.toList());
	}
	
	public List<XPPlugin> getPlugins() {
		return plugins;
	}
	
	public XPPlugin loadPlugin(File pluginFile) {
		J4XP.log("Loading plugin at " + pluginFile);
		JARLoader l = new JARLoader(pluginFile);
		try {
			Class<?> mainClass = l.getJ4XPMainClass();
			if(!XPPlugin.class.isAssignableFrom(mainClass)) throw new PluginLoadingException("Plugin doesn't extend XPPlugin");
			XPPlugin pl = (XPPlugin) mainClass.newInstance();
			plugins.add(pl);
			try {
				pl.setEnabled(true);
				J4XP.log("Plugin loaded!");
			}catch(Exception e) {
				plugins.remove(pl);
				J4XP.getLogger().warn("Plugin \"" + pl.getName() +"\" threw an exception while initializing! (Is it up to date?)");
				e.printStackTrace();
			}
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
		loadPlugins(Arrays.asList(J4XP.getPluginFolder().listFiles()));
	}
	
	public void reloadPlugins() {
		disableAllPlugins();
		plugins.clear();
		loadPlugins();
	}
	
	public WidgetMainWindow getPluginManagerWidget() {
		return pluginManagerWidget;
	}
	
}
