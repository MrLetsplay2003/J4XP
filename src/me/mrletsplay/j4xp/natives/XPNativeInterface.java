package me.mrletsplay.j4xp.natives;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.Callable;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.J4XPLogLevel;
import me.mrletsplay.j4xp.plugin.J4XPPluginLoader;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPNativeInterface {
	
	public static void initialize() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, URISyntaxException {
		File f = new File(J4XP.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		System.load(new File(f, "win.xpl").getAbsolutePath()); // TODO: System-independent implementation
		J4XP.init();
	}
	
	public static void notifyShutdown() {
		J4XP.stop();
	}
	
	protected static void check(String name, boolean expr) {
		if(!expr) J4XP.log(new RuntimeException("Failed invoke check: " + name));
	}
	
	protected static void safeExecute(Runnable run) {
		try {
			run.run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static <T> T safeExecute(Callable<T> call) {
		try {
			return call.call();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean notifyWidgetMessage(int widgetMessage, long widget, long param1, long param2) {
		XPWidgetID wID = J4XP.getWidgetIDs().get(widget);
		check("Widget != null", wID != null);
		XPWidgetMessage m = new XPWidgetMessage(new XPWidgetMessageIDImpl(widgetMessage), wID, param1, param2);
		for(int i = wID.getHandlers().size() - 1; i >= 0; i--) { // Notify the handlers, starting from the end (https://developer.x-plane.com/sdk/XPAddWidgetCallback/)
			WidgetMessageHandler h = wID.getHandlers().get(i);
			if(safeExecute(() -> h.onWidgetMessage(m))) return true;
		}
		return false;
	}
	
	public static void notifyPluginMessage(int fromPlugin, int pluginMessage, Object param) {
		for(XPPlugin pl : J4XPPluginLoader.getInstance().getEnabledPlugins()) {
			safeExecute(() -> pl.onPluginMessage(new XPPluginMessage(new XPLMPluginID(fromPlugin), new XPPluginMessageIDImpl(pluginMessage), param)));
		}
	}
	
	public static void notifyMenuMessage(long menuID, Object itemRef) {
		XPLMMenuID menID = J4XP.getMenuIDs().get(menuID);
		check("Menu != null", menID != null);
		XPMenuMessage msg = new XPMenuMessage(menID, itemRef);
		safeExecute(() -> menID.getHandlers().forEach(m -> m.onMenuMessage(msg)));
	}
	
	public static int getDataIH(long ref) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadInt().read(r.getDataAccessor().getReadRefcon()));
	}
	
	public static void setDataIH(long ref, int value) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteInt().write(r.getDataAccessor().getWriteRefcon(), value));
	}
	
	public static float getDataFH(long ref) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadFloat().read(r.getDataAccessor().getReadRefcon()));
	}
	
	public static void setDataFH(long ref, float value) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteFloat().write(r.getDataAccessor().getWriteRefcon(), value));
	}
	
	public static double getDataDH(long ref) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadDouble().read(r.getDataAccessor().getReadRefcon()));
	}
	
	public static void setDataDH(long ref, double value) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteDouble().write(r.getDataAccessor().getWriteRefcon(), value));
	}
	
	public static double getDataVIH(long ref, int[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadIntArray().read(r.getDataAccessor().getReadRefcon(), out, offset, max));
	}
	
	public static void setDataVIH(long ref, int[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteIntArray().write(r.getDataAccessor().getWriteRefcon(), in, offset, max));
	}
	
	public static double getDataVFH(long ref, float[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadFloatArray().read(r.getDataAccessor().getReadRefcon(), out, offset, max));
	}
	
	public static void setDataVFH(long ref, float[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteFloatArray().write(r.getDataAccessor().getWriteRefcon(), in, offset, max));
	}
	
	public static double getDataVBH(long ref, byte[] out, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		return safeExecute(() -> r.getDataAccessor().getReadData().read(r.getDataAccessor().getReadRefcon(), out, offset, max));
	}
	
	public static void setDataVBH(long ref, byte[] in, int offset, int max) {
		XPLMDataRef r = J4XP.getDataRefs().get(ref);
		check("DataRef != null", r != null);
		safeExecute(() -> r.getDataAccessor().getWriteData().write(r.getDataAccessor().getWriteRefcon(), in, offset, max));
	}
	
	public static void onDataChanged(long ref) {
		XPLMSharedData dt = J4XP.getSharedDatas().get(ref);
		check("Data != null", dt != null);
		safeExecute(() -> dt.getDataChanged().onDataChanged(dt.getRefcon()));
	}
	
	public static boolean onDrawCallback(long id, int phase, boolean isBefore) {
		XPLMDrawCallback cl = J4XP.getDrawCallbacks().get(id);
		check("callback != null", cl != null);
		return safeExecute(() -> cl.getCallback().onDraw(XPLMDrawingPhase.byValue(phase), isBefore, cl.getRefcon()));
	}
	
	public static void onDrawWindow(long windowID, Object refcon) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("drawWindow != null", w.getWindowParameters().getDrawFunction() != null);
		safeExecute(() -> w.getWindowParameters().getDrawFunction().onDraw(w, refcon));
	}
	
	public static boolean onHandleMouseClick(long windowID, int x, int y, int mouseStatus, Object refcon) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("handleMouseClick != null", w.getWindowParameters().getHandleMouseClickFunction() != null);
		return safeExecute(() -> w.getWindowParameters().getHandleMouseClickFunction().onMouseClick(w, x, y, XPLMMouseStatus.byValue(mouseStatus), refcon));
	}
	
	public static void onHandleKey(long windowID, char key, long flags, char virtualKey, Object refcon, boolean losingFocus) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("handleKey != null", w.getWindowParameters().getHandleMouseClickFunction() != null);
		safeExecute(() -> w.getWindowParameters().getHandleKeyFunction().onKey(w, key, EnumFlagCompound.of(XPLMKeyFlag.class, flags), virtualKey, refcon, losingFocus));
	}
	
	public static int onHandleCursor(long windowID, int x, int y, Object refcon) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("handleCursor != null", w.getWindowParameters().getHandleMouseClickFunction() != null);
		return safeExecute(() -> w.getWindowParameters().getHandleCursorFunction().onCursor(w, x, y, refcon).getRawValue());
	}
	
	public static boolean onHandleMouseWheel(long windowID, int x, int y, int wheel, int clicks, Object refcon) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("handleMouseWheel != null", w.getWindowParameters().getHandleMouseWheelFunction() != null);
		return safeExecute(() -> w.getWindowParameters().getHandleMouseWheelFunction().onMouseWheel(w, x, y, wheel, clicks, refcon));
	}
	
	public static boolean onHandleMouseRightClick(long windowID, int x, int y, int mouseStatus, Object refcon) {
		XPLMWindowID w = J4XP.getWindowIDs().get(windowID);
		check("windowID != null", w != null);
		check("handleRightClick != null", w.getWindowParameters().getHandleRightClickFunction() != null);
		return safeExecute(() -> w.getWindowParameters().getHandleRightClickFunction().onMouseClick(w, x, y, XPLMMouseStatus.byValue(mouseStatus), refcon));
	}
	
	public static void onReceiveMonitorBoundsGlobal(long id, int monitorIndex, int leftBx, int topBx, int rightBx, int bottomBx) {
		XPLMReceiveMonitorBoundsGlobal r = J4XP.getReceiveMonitorGlobals().get(id);
		check("receiveMonitorBoundsGlobal != null", r != null);
		safeExecute(() -> r.getHandlerFunction().onReceiveMonitorBoundsGloba(monitorIndex, leftBx, topBx, rightBx, bottomBx, r.getRefcon()));
	}
	
	public static void onReceiveMonitorBoundsOS(long id, int monitorIndex, int leftBx, int topBx, int rightBx, int bottomBx) {
		XPLMReceiveMonitorBoundsGlobal r = J4XP.getReceiveMonitorGlobals().get(id);
		check("receiveMonitorBoundsGlobal != null", r != null);
		safeExecute(() -> r.getHandlerFunction().onReceiveMonitorBoundsGloba(monitorIndex, leftBx, topBx, rightBx, bottomBx, r.getRefcon()));
	}
	
	public static boolean onKeySniffer(long id, char ch, long flags, char virtualKey) {
		XPLMKeySniffer s = J4XP.getKeySniffers().get(id);
		check("keySniffer != null", s != null);
		check("callback != null", s.getCallback() != null);
		return safeExecute(() -> s.getCallback().onKeySniffer(ch, EnumFlagCompound.of(XPLMKeyFlag.class, flags), virtualKey, s.getRefcon()));
	}
	
	public static void onHotKey(long id) {
		XPLMHotKeyID h = J4XP.getHotKeyIDs().get(id);
		check("hotKey != null", h != null);
		check("callback != null", h.getCallback() != null);
		safeExecute(() -> h.getCallback().onHotKey(h.getRefcon()));
	}
	
	public static Object executeFunction(NativeFunction function, Object... args) {
		J4XP.log(J4XPLogLevel.FILE_ONLY_DEBUG, "Invoke " + function + Arrays.toString(args));
		Object o = executeFunction(function.getID(), function.name().toLowerCase(), args);
		J4XP.log(J4XPLogLevel.FILE_ONLY_DEBUG, "Got " + o);
		return o;
	}
	
	private static native Object executeFunction(int functionID, String functionName, Object... args);
	
}
