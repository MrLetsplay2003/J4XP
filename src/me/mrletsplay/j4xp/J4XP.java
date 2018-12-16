package me.mrletsplay.j4xp;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.mrletsplay.j4xp.entity.menu.Menu;
import me.mrletsplay.j4xp.entity.menu.MenuItem;
import me.mrletsplay.j4xp.entity.widget.Widget;
import me.mrletsplay.j4xp.natives.DrawCallback;
import me.mrletsplay.j4xp.natives.XPLMDataChanged;
import me.mrletsplay.j4xp.natives.XPLMDataRef;
import me.mrletsplay.j4xp.natives.XPLMDataTypeID;
import me.mrletsplay.j4xp.natives.XPLMDrawCallback;
import me.mrletsplay.j4xp.natives.XPLMDrawingPhase;
import me.mrletsplay.j4xp.natives.XPLMMenuID;
import me.mrletsplay.j4xp.natives.XPLMSharedData;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.plugin.J4XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class J4XP {
	
	private static List<XPWidgetID> widgetIDs;
	private static List<XPLMMenuID> menus;
	private static List<XPLMDataRef> dataRefs;
	private static List<XPLMSharedData> sharedDatas;
	private static List<XPLMDrawCallback> drawCallbacks;
	
	private static J4XPLog log;
	private static J4XPConsole console;
	
	public static void main(String[] args) {
		System.out.println("To be loaded by the X-Plane 11 C++ plugin");
	}
	
	public static void init() {
		widgetIDs = new ArrayList<>();
		menus = new ArrayList<>();
		dataRefs = new ArrayList<>();
		sharedDatas = new ArrayList<>();
		drawCallbacks = new ArrayList<>();
		log = new J4XPLog();
		console = new J4XPConsole();
		
		log("Starting J4XP...");
		
		MenuItem item = Menu.getPluginsMenu().appendMenuItem("J4XP", null);
		Menu menu = Menu.createMenu("J4XP", Menu.getPluginsMenu(), item);
		menu.appendMenuItem("Reload all", "reload-all");
		menu.appendMenuItem("Debug Console", "debug-console");
		
		menu.registerHandler(m -> {
			if(m.getItemRef().equals("reload-all")) {
				J4XPPluginLoader.getInstance().reloadPlugins();
			}else if(m.getItemRef().equals("debug-console")) {
				console.getConsoleWidget().toggleVisibility();
			}
		});
		
		J4XPPluginLoader.getInstance().loadPlugins();
	}
	
	public static void stop() {
		for(XPPlugin pl : J4XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.setEnabled(false);
		}
		log.close();
	}
	
	public static J4XPLog getLog() {
		return log;
	}
	
	public static J4XPConsole getConsole() {
		return console;
	}
	
	public static void log(String message) {
		log(J4XPLogLevel.INFO, message);
	}
	
	public static void log(Exception e) {
		log.log(e);
	}
	
	public static void log(J4XPLogLevel logLevel, String message) {
		log.log(logLevel, message);
	}
	
	public static XPWidgetID getWidgetID(long rawID) {
		XPWidgetID id = widgetIDs.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPWidgetID(rawID);
			widgetIDs.add(id);
		}
		return id;
	}
	
	public static List<Widget> getWidgets() {
		return widgetIDs.stream().map(XPWidgetID::getWidget).filter(Objects::nonNull).collect(Collectors.toList());
	}
	
	public static XPLMMenuID getMenuID(long rawID) {
		XPLMMenuID id = menus.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPLMMenuID(rawID);
			menus.add(id);
		}
		return id;
	}
	
	public static XPLMDataRef getDataRef(long rawID) {
		XPLMDataRef id = dataRefs.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPLMDataRef(rawID);
			dataRefs.add(id);
		}
		return id;
	}
	
	public static XPLMSharedData createSharedData(String dataName, EnumFlagCompound<XPLMDataTypeID> dataType, XPLMDataChanged dataChanged, Object refcon) {
		XPLMSharedData dt = new XPLMSharedData(System.currentTimeMillis(), dataName, dataType, dataChanged, refcon); // TODO: id
		sharedDatas.add(dt);
		return dt;
	}
	
	public static void deleteSharedData(long rawID) {
		sharedDatas.removeIf(d -> d.getRawID() == rawID);
	}
	
	public static XPLMDrawCallback createDrawCallback(DrawCallback callback, XPLMDrawingPhase phase, boolean wantsBefore, Object refcon) {
		XPLMDrawCallback dt = new XPLMDrawCallback(System.currentTimeMillis(), callback, phase, wantsBefore, refcon); // TODO: id
		drawCallbacks.add(dt);
		return dt;
	}
	
	public static void deleteDrawCallback(long rawID) {
		drawCallbacks.removeIf(d -> d.getRawID() == rawID);
	}
	
	public static XPLMSharedData getSharedData(long rawID) {
		return sharedDatas.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
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
