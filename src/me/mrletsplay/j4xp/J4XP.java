package me.mrletsplay.j4xp;

import java.io.File;
import java.net.URISyntaxException;

import me.mrletsplay.j4xp.entity.menu.Menu;
import me.mrletsplay.j4xp.entity.menu.MenuItem;
import me.mrletsplay.j4xp.natives.classes.XPLMDataRef;
import me.mrletsplay.j4xp.natives.classes.XPLMDrawCallback;
import me.mrletsplay.j4xp.natives.classes.XPLMFlightLoopID;
import me.mrletsplay.j4xp.natives.classes.XPLMHotKeyID;
import me.mrletsplay.j4xp.natives.classes.XPLMInstanceRef;
import me.mrletsplay.j4xp.natives.classes.XPLMKeySniffer;
import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;
import me.mrletsplay.j4xp.natives.classes.XPLMMenuID;
import me.mrletsplay.j4xp.natives.classes.XPLMObjectRef;
import me.mrletsplay.j4xp.natives.classes.XPLMProbeRef;
import me.mrletsplay.j4xp.natives.classes.XPLMReceiveMonitorBoundsGlobal;
import me.mrletsplay.j4xp.natives.classes.XPLMReceiveMonitorBoundsOS;
import me.mrletsplay.j4xp.natives.classes.XPLMSharedData;
import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.plugin.J4XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class J4XP {
	
	private static J4XPIDCache<XPWidgetID> widgetIDs;
	private static J4XPIDCache<XPLMMenuID> menuIDs;
	private static J4XPIDCache<XPLMDataRef> dataRefs;
	private static J4XPIDCache<XPLMSharedData> sharedDatas;
	private static J4XPIDCache<XPLMDrawCallback> drawCallbacks;
	private static J4XPIDCache<XPLMInstanceRef> instanceRefs;
	private static J4XPIDCache<XPLMMapLayerID> mapLayerIDs;
	private static J4XPIDCache<XPLMWindowID> windowIDs;
	private static J4XPIDCache<XPLMHotKeyID> hotKeyIDs;
	private static J4XPIDCache<XPLMKeySniffer> keySniffers;
	private static J4XPIDCache<XPLMFlightLoopID> flightLoopIDs;
	private static J4XPIDCache<XPLMProbeRef> probeRefs;
	private static J4XPIDCache<XPLMReceiveMonitorBoundsGlobal> receiveMonitorGlobals;
	private static J4XPIDCache<XPLMReceiveMonitorBoundsOS> receiveMonitorOSs;
	private static J4XPIDCache<XPLMObjectRef> objectRefs;
	
	private static J4XPLogger logger;
	private static J4XPConsole console;
	
	public static void main(String[] args) {
		System.out.println("To be loaded by the X-Plane 11 C++ plugin");
	}
	
	public static void init() {
		widgetIDs = new J4XPIDCache<>(XPWidgetID::new);
		menuIDs = new J4XPIDCache<>(XPLMMenuID::new);
		dataRefs = new J4XPIDCache<>();
		sharedDatas = new J4XPIDCache<>();
		drawCallbacks = new J4XPIDCache<>();
		instanceRefs = new J4XPIDCache<>(XPLMInstanceRef::new);
		mapLayerIDs = new J4XPIDCache<>(XPLMMapLayerID::new);
		windowIDs = new J4XPIDCache<>();
		hotKeyIDs = new J4XPIDCache<>();
		keySniffers = new J4XPIDCache<>();
		flightLoopIDs = new J4XPIDCache<>(XPLMFlightLoopID::new);
		probeRefs = new J4XPIDCache<>(XPLMProbeRef::new);
		receiveMonitorGlobals = new J4XPIDCache<>();
		receiveMonitorOSs = new J4XPIDCache<>();
		objectRefs = new J4XPIDCache<>(XPLMObjectRef::new);
		
		logger = new J4XPLogger();
		console = new J4XPConsole();
		
		log("Starting J4XP...");
		
		MenuItem item = Menu.getPluginsMenu().appendMenuItem("J4XP", null);
		Menu menu = Menu.createMenu("J4XP", Menu.getPluginsMenu(), item);
		menu.appendMenuItem("Debug Console", "debug-console");
		menu.appendMenuItem("Plugin Manager", "plugin-manager");
		menu.appendMenuSeparator();
		menu.appendMenuItem("Reload all", "reload-all");
		
		menu.registerHandler(m -> {
			if(m.getItemRef().equals("reload-all")) {
				J4XPPluginLoader.getInstance().reloadPlugins();
			}else if(m.getItemRef().equals("debug-console")) {
				console.getConsoleWidget().toggleVisibility();
			}
		});
		
		new Thread(() -> {
			while(true) {
				console.updateLog();
				J4XPPluginLoader.getInstance().updateLog();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		J4XPPluginLoader.getInstance().loadPlugins();
	}
	
	public static void stop() {
		for(XPPlugin pl : J4XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.setEnabled(false);
		}
		for(J4XPIDCache<?> cache : J4XPIDCache.getCaches()) {
			for(J4XPIdentifiable i : cache.getElements()) {
				if(i instanceof J4XPDestructible) {
					((J4XPDestructible) i).destroy();
				}
			}
		}
		System.setOut(J4XPLogger.origSysOut);
		System.setErr(J4XPLogger.origSysErr);
		logger.close();
	}
	
	public static J4XPLogger getLogger() {
		return logger;
	}
	
	public static J4XPConsole getConsole() {
		return console;
	}
	
	public static J4XPPluginLoader getPluginLoader() {
		return J4XPPluginLoader.getInstance();
	}
	
	public static void log(String message) {
		log(J4XPLogLevel.INFO, message);
	}
	
	public static void log(Exception e) {
		logger.log(e);
	}
	
	public static void log(J4XPLogLevel logLevel, String message) {
		logger.log(logLevel, message);
	}
	
	public static J4XPIDCache<XPWidgetID> getWidgetIDs() {
		return widgetIDs;
	}
	
	public static J4XPIDCache<XPLMDataRef> getDataRefs() {
		return dataRefs;
	}
	
	public static J4XPIDCache<XPLMDrawCallback> getDrawCallbacks() {
		return drawCallbacks;
	}
	
	public static J4XPIDCache<XPLMHotKeyID> getHotKeyIDs() {
		return hotKeyIDs;
	}
	
	public static J4XPIDCache<XPLMInstanceRef> getInstanceRefs() {
		return instanceRefs;
	}
	
	public static J4XPIDCache<XPLMKeySniffer> getKeySniffers() {
		return keySniffers;
	}
	
	public static J4XPIDCache<XPLMMapLayerID> getMapLayerIDs() {
		return mapLayerIDs;
	}
	
	public static J4XPIDCache<XPLMMenuID> getMenuIDs() {
		return menuIDs;
	}
	
	public static J4XPIDCache<XPLMSharedData> getSharedDatas() {
		return sharedDatas;
	}
	
	public static J4XPIDCache<XPLMWindowID> getWindowIDs() {
		return windowIDs;
	}
	
	public static J4XPIDCache<XPLMFlightLoopID> getFlightLoopIDs() {
		return flightLoopIDs;
	}
	
	public static J4XPIDCache<XPLMProbeRef> getProbeRefs() {
		return probeRefs;
	}
	
	public static J4XPIDCache<XPLMReceiveMonitorBoundsGlobal> getReceiveMonitorGlobals() {
		return receiveMonitorGlobals;
	}
	
	public static J4XPIDCache<XPLMReceiveMonitorBoundsOS> getReceiveMonitorOSs() {
		return receiveMonitorOSs;
	}
	
	public static J4XPIDCache<XPLMObjectRef> getObjectRefs() {
		return objectRefs;
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
