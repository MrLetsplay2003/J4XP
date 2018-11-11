package me.mrletsplay.j4xp.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.XPLMMenuID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPLMMenus;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.j4xp.plugin.entity.widget.WidgetMainWindow;
import me.mrletsplay.j4xp.plugin.entity.widget.WidgetSubWindow;
import me.mrletsplay.j4xp.plugin.entity.widget.builder.WidgetBuilder;
import me.mrletsplay.j4xp.plugin.entity.widget.builder.WidgetCloseAction;

public class J4XP {
	
	private static PrintWriter logW;
	private static List<XPWidgetID> widgets;
	private static List<XPLMMenuID> menus;

	public static void main(String[] args) {
		System.out.println("To be loaded by the X-Plane 11 C++ plugin");
	}
	
	public static void init() {
		try {
			logW = new PrintWriter(new FileOutputStream(getLogFile(), true), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		log("Starting J4XP...");
		widgets = new ArrayList<>();
		menus = new ArrayList<>();
		
		WidgetMainWindow mW = WidgetBuilder.newMainWindowBuilder()
				.withBounds(100, 200, 300, 100)
				.withCloseBoxes(true)
				.withAutoHandleClose(WidgetCloseAction.HIDE)
				.withDescriptor("main-window")
				.create();
		
		WidgetSubWindow sW = WidgetBuilder.newSubWindowBuilder()
				.withBounds(100, 200, 300, 100)
				.withRootStatus(false)
				.withContainer(mW)
				.withDescriptor("sub-window")
				.create();
		
		WidgetBuilder.newCaptionBuilder()
				.withBounds(100, 200, 300, 100)
				.withRootStatus(false)
				.withContainer(sW)
				.withDescriptor("This is a descriptor\n\n\nHey!")
				.create();
		
		int idx = XPLMMenus.appendMenuItem(XPLMMenus.findPluginsMenu(), "J4XP", null);
		XPLMMenuID menu = XPLMMenus.createMenu("J4XP", XPLMMenus.findPluginsMenu(), idx);
		XPLMMenus.appendMenuItem(menu, "Reload All", "reload-all");
		XPLMMenus.appendMenuItem(menu, "Debug Console", "debug-console");
		
		menu.registerHandler(m -> {
			if(m.getItemRef().equals("reload-all")) {
				XPPluginLoader.getInstance().reloadPlugins();
			}else if(m.getItemRef().equals("debug-console")) {
				mW.toggleVisibility();
			}
		});
		
		XPPluginLoader.getInstance().loadPlugins();
	}
	
	public static void stop() {
		for(XPPlugin pl : XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.setEnabled(false);
		}
		logW.flush();
		logW.close();
	}
	
	public static void log(String message) {
		logW.println(message);
		logW.flush();
	}
	
	public static XPWidgetID getWidgetID(long rawID) {
		XPWidgetID id = widgets.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPWidgetID(rawID);
			widgets.add(id);
		}
		return id;
	}
	
	public static XPLMMenuID getMenuID(long rawID) {
		XPLMMenuID id = menus.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPLMMenuID(rawID);
			menus.add(id);
		}
		return id;
	}
	
	public static PrintWriter getLogWriter() {
		return logW;
	}
	
	public static File getJarFolder() {
		try {
			return new File(J4XP.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static File getPluginFolder() {
		File plF = new File(getJarFolder(), "plugins");
		if(!plF.exists()) plF.mkdirs();
		return plF;
	}
	
	public static File getLogFile() {
		File lF = new File(getJarFolder(), "log.txt");
		return lF;
	}
	
}
