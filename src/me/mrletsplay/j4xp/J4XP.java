package me.mrletsplay.j4xp;

import java.io.File;
import java.net.URISyntaxException;

import me.mrletsplay.j4xp.entity.menu.Menu;
import me.mrletsplay.j4xp.entity.menu.MenuItem;
import me.mrletsplay.j4xp.natives.classes.XPLMCameraControl;
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
import me.mrletsplay.j4xp.natives.xp_classes.XPLMCamera;
import me.mrletsplay.j4xp.plugin.J4XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class J4XP {
	
	private static J4XPCache<XPWidgetID> widgetIDs;
	private static J4XPCache<XPLMMenuID> menuIDs;
	private static J4XPCache<XPLMDataRef> dataRefs;
	private static J4XPCache<XPLMSharedData> sharedDatas;
	private static J4XPCache<XPLMDrawCallback> drawCallbacks;
	private static J4XPCache<XPLMInstanceRef> instanceRefs;
	private static J4XPCache<XPLMMapLayerID> mapLayerIDs;
	private static J4XPCache<XPLMWindowID> windowIDs;
	private static J4XPCache<XPLMHotKeyID> hotKeyIDs;
	private static J4XPCache<XPLMKeySniffer> keySniffers;
	private static J4XPCache<XPLMFlightLoopID> flightLoopIDs;
	private static J4XPCache<XPLMProbeRef> probeRefs;
	private static J4XPCache<XPLMReceiveMonitorBoundsGlobal> receiveMonitorGlobals;
	private static J4XPCache<XPLMReceiveMonitorBoundsOS> receiveMonitorOSs;
	private static J4XPCache<XPLMObjectRef> objectRefs;
	private static XPLMCameraControl cameraControl;
	
	private static J4XPLogger logger;
	private static J4XPConsole console;
	
	public static void main(String[] args) {
		System.out.println("To be loaded by the X-Plane 11 C++ plugin");
	}
	
	public static void init() {
		widgetIDs = new J4XPCache<>(XPWidgetID::new);
		menuIDs = new J4XPCache<>(XPLMMenuID::new);
		dataRefs = new J4XPCache<>();
		sharedDatas = new J4XPCache<>();
		drawCallbacks = new J4XPCache<>();
		instanceRefs = new J4XPCache<>(XPLMInstanceRef::new);
		mapLayerIDs = new J4XPCache<>(XPLMMapLayerID::new);
		windowIDs = new J4XPCache<>();
		hotKeyIDs = new J4XPCache<>();
		keySniffers = new J4XPCache<>();
		flightLoopIDs = new J4XPCache<>(XPLMFlightLoopID::new);
		probeRefs = new J4XPCache<>(XPLMProbeRef::new);
		receiveMonitorGlobals = new J4XPCache<>();
		receiveMonitorOSs = new J4XPCache<>();
		objectRefs = new J4XPCache<>(XPLMObjectRef::new);
		
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
		for(J4XPCache<?> cache : J4XPCache.getCaches()) {
			for(J4XPIdentifiable i : cache.getElements()) {
				if(i instanceof J4XPDestructible) {
					((J4XPDestructible) i).destroy();
				}
			}
		}
		if(cameraControl != null) {
			XPLMCamera.dontControlCamera();
		}
		System.setOut(J4XPLogger.origSysOut);
		System.setErr(J4XPLogger.origSysErr);
		logger.close();
	}
	
	public static void setCameraControl(XPLMCameraControl cameraControl) {
		if(J4XP.cameraControl != null) {
			J4XP.cameraControl.getControlFunction().onCameraControl(true, J4XP.cameraControl.getRefcon());
		}
		J4XP.cameraControl = cameraControl;
	}
	
	public static XPLMCameraControl getCameraControl() {
		return cameraControl;
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
	
	public static J4XPCache<XPWidgetID> getWidgetIDs() {
		return widgetIDs;
	}
	
	public static J4XPCache<XPLMDataRef> getDataRefs() {
		return dataRefs;
	}
	
	public static J4XPCache<XPLMDrawCallback> getDrawCallbacks() {
		return drawCallbacks;
	}
	
	public static J4XPCache<XPLMHotKeyID> getHotKeyIDs() {
		return hotKeyIDs;
	}
	
	public static J4XPCache<XPLMInstanceRef> getInstanceRefs() {
		return instanceRefs;
	}
	
	public static J4XPCache<XPLMKeySniffer> getKeySniffers() {
		return keySniffers;
	}
	
	public static J4XPCache<XPLMMapLayerID> getMapLayerIDs() {
		return mapLayerIDs;
	}
	
	public static J4XPCache<XPLMMenuID> getMenuIDs() {
		return menuIDs;
	}
	
	public static J4XPCache<XPLMSharedData> getSharedDatas() {
		return sharedDatas;
	}
	
	public static J4XPCache<XPLMWindowID> getWindowIDs() {
		return windowIDs;
	}
	
	public static J4XPCache<XPLMFlightLoopID> getFlightLoopIDs() {
		return flightLoopIDs;
	}
	
	public static J4XPCache<XPLMProbeRef> getProbeRefs() {
		return probeRefs;
	}
	
	public static J4XPCache<XPLMReceiveMonitorBoundsGlobal> getReceiveMonitorGlobals() {
		return receiveMonitorGlobals;
	}
	
	public static J4XPCache<XPLMReceiveMonitorBoundsOS> getReceiveMonitorOSs() {
		return receiveMonitorOSs;
	}
	
	public static J4XPCache<XPLMObjectRef> getObjectRefs() {
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
