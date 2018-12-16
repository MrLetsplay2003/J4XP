package me.mrletsplay.j4xp.natives;

import java.io.File;
import java.net.URISyntaxException;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.J4XPLogLevel;
import me.mrletsplay.j4xp.plugin.J4XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPNativeInterface {
	
	public static void initialize() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, URISyntaxException {
		File f = new File(J4XP.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		System.load(new File(f, "win.xpl").getAbsolutePath()); // TODO: System-independent implementation
		J4XP.init();
	}
	
	public static void notifyShutdown() {
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
		for(XPPlugin pl : J4XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.onPluginMessage(new XPPluginMessage(new CPPPluginID(fromPlugin), new XPPluginMessageIDImpl(pluginMessage), param));
		}
	}
	
	public static void notifyMenuMessage(long menuID, Object itemRef) {
		J4XP.log(J4XPLogLevel.DEBUG, "MenuMessage: " + menuID);
		XPLMMenuID menID = J4XP.getMenuID(menuID);
		XPMenuMessage msg = new XPMenuMessage(menID, itemRef);
		menID.getHandlers().forEach(m -> m.onMenuMessage(msg));
	}
	
	public static int getDataIH(long ref) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadInt().read(r.getDataAccessor().getReadRefcon());
	}
	
	public static void setDataIH(long ref, int value) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteInt().write(r.getDataAccessor().getWriteRefcon(), value);
	}
	
	public static float getDataFH(long ref) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadFloat().read(r.getDataAccessor().getReadRefcon());
	}
	
	public static void setDataFH(long ref, float value) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteFloat().write(r.getDataAccessor().getWriteRefcon(), value);
	}
	
	public static double getDataDH(long ref) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadDouble().read(r.getDataAccessor().getReadRefcon());
	}
	
	public static void setDataDH(long ref, double value) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteDouble().write(r.getDataAccessor().getWriteRefcon(), value);
	}
	
	public static double getDataVIH(long ref, int[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadIntArray().read(r.getDataAccessor().getReadRefcon(), out, offset, max);
	}
	
	public static void setDataVIH(long ref, int[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteIntArray().write(r.getDataAccessor().getWriteRefcon(), in, offset, max);
	}
	
	public static double getDataVFH(long ref, float[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadFloatArray().read(r.getDataAccessor().getReadRefcon(), out, offset, max);
	}
	
	public static void setDataVFH(long ref, float[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteFloatArray().write(r.getDataAccessor().getWriteRefcon(), in, offset, max);
	}
	
	public static double getDataVBH(long ref, byte[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		return r.getDataAccessor().getReadData().read(r.getDataAccessor().getReadRefcon(), out, offset, max);
	}
	
	public static void setDataVBH(long ref, byte[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRef(ref);
		r.getDataAccessor().getWriteData().write(r.getDataAccessor().getWriteRefcon(), in, offset, max);
	}
	
	public static void onDataChanged(long ref) {
		XPLMSharedData dt = J4XP.getSharedData(ref);
		dt.getDataChanged().onDataChanged(dt.getRefcon());
	}
	
	public static Object executeFunction(NativeFunction function, Object... args) {
		// J4XP.log(J4XPLogLevel.DEBUG, "Invoke " + function + Arrays.toString(args));
		Object o = executeFunction(function.getID(), function.name().toLowerCase(), args);
		// J4XP.log(J4XPLogLevel.DEBUG, "Got " + o);
		return o;
	}
	
	private static native Object executeFunction(int functionID, String functionName, Object... args);
	
}
