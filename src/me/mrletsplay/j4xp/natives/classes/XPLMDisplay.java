package me.mrletsplay.j4xp.natives.classes;

import java.awt.Point;
import java.awt.geom.Point2D;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.DrawCallback;
import me.mrletsplay.j4xp.natives.KeySniffer;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.ReceiveMonitorBoundsGlobal;
import me.mrletsplay.j4xp.natives.ReceiveMonitorBoundsOS;
import me.mrletsplay.j4xp.natives.XPGeometry;
import me.mrletsplay.j4xp.natives.XPLMCreateWindow;
import me.mrletsplay.j4xp.natives.XPLMDrawCallback;
import me.mrletsplay.j4xp.natives.XPLMDrawWindow;
import me.mrletsplay.j4xp.natives.XPLMDrawingPhase;
import me.mrletsplay.j4xp.natives.XPLMHandleKey;
import me.mrletsplay.j4xp.natives.XPLMHandleMouseClick;
import me.mrletsplay.j4xp.natives.XPLMHotKey;
import me.mrletsplay.j4xp.natives.XPLMHotKeyID;
import me.mrletsplay.j4xp.natives.XPLMHotKeyInfo;
import me.mrletsplay.j4xp.natives.XPLMKeyFlag;
import me.mrletsplay.j4xp.natives.XPLMKeySniffer;
import me.mrletsplay.j4xp.natives.XPLMPluginID;
import me.mrletsplay.j4xp.natives.XPLMReceiveMonitorBoundsGlobal;
import me.mrletsplay.j4xp.natives.XPLMReceiveMonitorBoundsOS;
import me.mrletsplay.j4xp.natives.XPLMWindowID;
import me.mrletsplay.j4xp.natives.XPLMWindowPositioningMode;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.plugin.J4XPUtils;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMDisplay {
	
	public static XPLMDrawCallback registerDrawCallback(DrawCallback callback, XPLMDrawingPhase phase, boolean wantsBefore, Object refcon) {
		XPLMDrawCallback c = J4XP.getDrawCallbacks().create(id -> new XPLMDrawCallback(J4XPUtils.getMethodCaller(), id, callback, phase, wantsBefore, refcon));
		boolean b = (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_REGISTER_DRAW_CALLBACK, phase.getRawValue(), wantsBefore, c.getRawID());
		if(!b) {
			J4XP.getDrawCallbacks().remove(c.getRawID());
			return null;
		}
		return c;
	}
	
	public static boolean unregisterDrawCallback(XPLMDrawCallback callback) {
		return unregisterDrawCallback(callback.getPhase(), callback.isWantsBefore(), callback.getRawID());
	}
	
	public static boolean unregisterDrawCallback(XPLMDrawingPhase phase, boolean wantsBefore, long rawID) {
		J4XP.getDrawCallbacks().remove(rawID);
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_UNREGISTER_DRAW_CALLBACK, phase.getRawValue(), wantsBefore, rawID);
	}
	
	public static XPLMWindowID createWindowEx(XPLMCreateWindow params) {
		return J4XP.getWindowIDs().getOrCreate((long) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_CREATE_WINDOW_EX,
				params.getLeft(), params.getTop(), params.getRight(), params.getBottom(), params.isVisible(), params.getRefcon(), params.getDecorateAsFloatingWindow().getRawValue(), params.getLayer().getRawValue()),
				id -> new XPLMWindowID(J4XPUtils.getMethodCaller(), id, params));
	}
	
	public static XPLMWindowID createWindow(int left, int top, int right, int bottom, boolean isVisible, XPLMDrawWindow drawCallback, XPLMHandleKey keyCallback, XPLMHandleMouseClick mouseCallback, Object refcon) {
		return J4XP.getWindowIDs().getOrCreate((long) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_CREATE_WINDOW,
				left, top, right, bottom, isVisible, refcon),
				id -> new XPLMWindowID(J4XPUtils.getMethodCaller(), id, new XPLMCreateWindow(left, top, right, bottom, isVisible, drawCallback, mouseCallback, keyCallback, null, null, refcon, null, null, null)));
	}
	
	public static void destroyWindow(XPLMWindowID windowID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_DESTROY_WINDOW, windowID.getRawID());
	}
	
	public static Point2D getScreenSize() {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_SCREEN_SIZE);
		return new Point(p[0], p[1]);
	}
	
	public static XPGeometry getScreenBoundsGlobal() {
		int[] rGeom = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_SCREEN_BOUNDS_GLOBAL);
		return new XPGeometry(rGeom[0], rGeom[1], rGeom[2], rGeom[3]);
	}
	
	public static XPLMReceiveMonitorBoundsGlobal getAllMonitorBoundsGlobal(ReceiveMonitorBoundsGlobal monitorBoundsCallback, Object refcon) {
		XPLMReceiveMonitorBoundsGlobal r = J4XP.getReceiveMonitorGlobals().create(id -> new XPLMReceiveMonitorBoundsGlobal(J4XPUtils.getMethodCaller(), id, monitorBoundsCallback, refcon));
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_ALL_MONITOR_BOUNDS_GLOBAL, r.getRawID());
		return r;
	}
	
	public static XPLMReceiveMonitorBoundsOS XPLMGetAllMonitorBoundsOS(ReceiveMonitorBoundsOS monitorBoundsCallback, Object refcon) {
		XPLMReceiveMonitorBoundsOS r = J4XP.getReceiveMonitorOSs().create(id -> new XPLMReceiveMonitorBoundsOS(J4XPUtils.getMethodCaller(), id, monitorBoundsCallback, refcon));
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_ALL_MONITOR_BOUNDS_OS, r.getRawID());
		return r;
	}
	
	public static Point2D getMouseLocation() {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_MOUSE_LOCATION);
		return new Point(p[0], p[1]);
	}
	
	public static Point2D getMouseLocationGlobal() {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_MOUSE_LOCATION_GLOBAL);
		return new Point(p[0], p[1]);
	}
	
	public static XPGeometry getWindowGeometry(XPLMWindowID windowID) {
		int[] rGeom = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_GEOMETRY, windowID.getRawID());
		return new XPGeometry(rGeom[0], rGeom[1], rGeom[2], rGeom[3]);
	}
	
	public static void setWindowGeometry(XPLMWindowID windowID, int left, int top, int right, int bottom) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_GEOMETRY, windowID.getRawID(), new int[] {left, top, right, bottom});
	}
	
	public static XPGeometry getWindowGeometryOS(XPLMWindowID windowID) {
		int[] rGeom = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_GEOMETRY_OS, windowID.getRawID());
		return new XPGeometry(rGeom[0], rGeom[1], rGeom[2], rGeom[3]);
	}
	
	public static void setWindowGeometryOS(XPLMWindowID windowID, int left, int top, int right, int bottom) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_GEOMETRY_OS, windowID.getRawID(), new int[] {left, top, right, bottom});
	}
	
	public static Point2D getWindowGeometryVR(XPLMWindowID windowID) {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_GEOMETRY_VR, windowID.getRawID());
		return new Point(p[0], p[1]);
	}
	
	public static void setWindowGeometryVR(XPLMWindowID windowID, int widthBoxels, int heightBoxels) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_GEOMETRY_VR, windowID.getRawID(), new int[] {widthBoxels, heightBoxels});
	}
	
	public static boolean getWindowIsVisible(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_IS_VISIBLE, windowID.getRawID());
	}
	
	public static void setWindowIsVisible(XPLMWindowID windowID, boolean isVisible) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_IS_VISIBLE, isVisible);
	}
	
	public static boolean windowIsPoppedOut(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_WINDOW_IS_POPPED_OUT, windowID.getRawID());
	}
	
	public static boolean windowIsInVR(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_WINDOW_IS_IN_VR, windowID.getRawID());
	}
	
	public static void setWindowGravity(XPLMWindowID windowID, float leftGravity, float topGravity, float rightGravity, float bottomGravity) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_GRAVITY, windowID.getRawID(), new float[] {leftGravity, topGravity, rightGravity, bottomGravity});
	}
	
	public static void setWindowResizingLimits(XPLMWindowID windowID, int minWidthBoxels, int minHeightBoxels, int maxWidthBoxels, int maxHeightBoxels) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_RESIZING_LIMITS, windowID.getRawID(), new int[] {minWidthBoxels, minHeightBoxels, maxWidthBoxels, maxHeightBoxels});
	}
	
	public static void setWindowPositioningMode(XPLMWindowID windowID, XPLMWindowPositioningMode positioningMode, int monitorIndex) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_POSITIONING_MODE, windowID.getRawID(), positioningMode.getRawValue(), monitorIndex);
	}
	
	public static void setWindowTitle(XPLMWindowID windowID, String windowTitle) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_TITLE, windowID.getRawID(), windowTitle);
	}
	
//	public static Object getWindowRefCon(XPLMWindowID windowID) { TODO: C++ void *
//		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_REFCON, windowID.getRawID());
//	}
//	
//	public static void setWindowRefCon(XPLMWindowID windowID, Object refcon) {
//		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_REFCON, windowID.getRawID(), refcon);
//	}
	
	public static boolean hasKeyboardFocus(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_HAS_KEYBOARD_FOCUS, windowID.getRawID());
	}
	
	public static void bringWindowToFront(XPLMWindowID windowID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_BRING_WINDOW_TO_FRONT, windowID.getRawID());
	}
	
	public static boolean isWindowInFront(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_IS_WINDOW_IN_FRONT, windowID.getRawID());
	}
	
	public static XPLMKeySniffer registerKeySniffer(KeySniffer callback, boolean beforeWindows, Object refcon) {
		XPLMKeySniffer sn = J4XP.getKeySniffers().create(id -> new XPLMKeySniffer(J4XPUtils.getMethodCaller(), id, callback, beforeWindows, refcon));
		boolean b = (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_REGISTER_KEY_SNIFFER, sn.getRawID(), beforeWindows);
		if(!b) {
			J4XP.getKeySniffers().remove(sn.getRawID());
			return null;
		}
		return sn;
	}
	
	public static boolean unregisterKeySniffer(XPLMKeySniffer sniffer) {
		return unregisterKeySniffer(sniffer.getRawID(), sniffer.isBeforeWindows());
	}
	
	public static boolean unregisterKeySniffer(long rawID, boolean beforeWindows) {
		J4XP.getKeySniffers().remove(rawID);
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_UNREGISTER_KEY_SNIFFER, rawID, beforeWindows);
	}
	
	public static XPLMHotKeyID registerHotKey(char virtualKey, EnumFlagCompound<XPLMKeyFlag> flags, String description, XPLMHotKey callback, Object refcon) {
		return J4XP.getHotKeyIDs().getOrCreate((long) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_REGISTER_HOT_KEY, virtualKey, flags.getCompound(), description, callback, refcon),
				id -> new XPLMHotKeyID(J4XPUtils.getMethodCaller(), id, callback, refcon));
	}
	
	public static void unregisterHotKey(XPLMHotKeyID hotKey) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_UNREGISTER_HOT_KEY, hotKey.getRawID());
	}
	
	public static int countHotKeys() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_COUNT_HOTKEYS);
	}
	
	public static XPLMHotKeyID getNthHotKey(int index) {
		return J4XP.getHotKeyIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_NTH_HOTKEY, index));
	}
	
	public static XPLMHotKeyInfo getHotKeyInfo(XPLMHotKeyID hotKey) {
		Object[] arr = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_HOTKEY_INFO, hotKey.getRawID());
		return new XPLMHotKeyInfo((char) arr[0], EnumFlagCompound.of(XPLMKeyFlag.class, (long) arr[1]), (String) arr[2], new XPLMPluginID((long) arr[3]));
	}
	
	public static void setHotKeyCombination(XPLMHotKeyID hotKey, char virtualKey, EnumFlagCompound<XPLMKeyFlag> flags) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_HOTKEY_COMBINATION, hotKey.getRawID(), virtualKey, flags.getCompound());
	}

}