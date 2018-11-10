package me.mrletsplay.j4xp.natives;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;

import me.mrletsplay.j4xp.main.J4XP;
import me.mrletsplay.j4xp.main.XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPNativeInterface {
	
	public static void initialize() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, URISyntaxException {
		//System.setProperty("java.library.path", "D:\\Program Files (x86)\\Steam\\steamapps\\common\\X-Plane 11\\Resources\\plugins\\test");
		//set sys_paths to null
		/*final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
		sysPathsField.setAccessible(true);
		sysPathsField.set(null, null); TODO
		System.loadLibrary("j4xp-win");*/
		File f = new File(J4XP.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		System.load(new File(f, "win.xpl").getAbsolutePath());
		J4XP.init();
	}
	
	public static void notifyShutdown() {
		// System.exit(0);
		J4XP.stop();
	}
	
	public static boolean notifyWidgetMessage(int widgetMessage, long widget, long param1, long param2) {
		XPWidgetID wID = J4XP.getWidgetID(widget);
		XPWidgetMessage m = new XPWidgetMessage(new XPWidgetMessageIDImpl(widgetMessage), wID, param1, param2);
		for(int i = wID.getHandlers().size() - 1; i >= 0; i--) { // Notify the handlers, starting from the end (https://developer.x-plane.com/sdk/XPAddWidgetCallback/)
			WidgetMessageHandler h = wID.getHandlers().get(i);
			if(h.onWidgetMessage(m)) return true;
		}
		return false;
	}
	
	public static void notifyPluginMessage(int fromPlugin, int pluginMessage, Object param) {
		for(XPPlugin pl : XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.onPluginMessage(new XPPluginMessage(new CPPPluginID(fromPlugin), new XPPluginMessageIDImpl(pluginMessage), param));
		}
	}

	public static Object executeFunction(NativeFunction function, Object... args) {
		J4XP.log("Invoke " + function + Arrays.toString(args));
		Object o = executeFunction(function.getID(), function.name().toLowerCase(), args);
		J4XP.log("Got " + o);
		return o;
	}
	
	private static native Object executeFunction(int functionID, String functionName, Object... args);
	
}
