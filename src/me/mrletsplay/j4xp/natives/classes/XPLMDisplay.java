package me.mrletsplay.j4xp.natives.classes;

import java.awt.Point;
import java.awt.geom.Point2D;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.DrawCallback;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPGeometry;
import me.mrletsplay.j4xp.natives.XPLMCreateWindow;
import me.mrletsplay.j4xp.natives.XPLMDrawCallback;
import me.mrletsplay.j4xp.natives.XPLMDrawWindow;
import me.mrletsplay.j4xp.natives.XPLMDrawingPhase;
import me.mrletsplay.j4xp.natives.XPLMHandleKey;
import me.mrletsplay.j4xp.natives.XPLMHandleMouseClick;
import me.mrletsplay.j4xp.natives.XPLMWindowID;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

public class XPLMDisplay {
	
	public static XPLMDrawCallback registerDrawCallback(DrawCallback callback, XPLMDrawingPhase phase, boolean wantsBefore, Object refcon) {
		XPLMDrawCallback c = J4XP.createDrawCallback(callback, phase, wantsBefore, refcon);
		boolean b = (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_REGISTER_DRAW_CALLBACK, phase.getRawValue(), wantsBefore, c.getRawID());
		if(!b) {
			J4XP.deleteDrawCallback(c.getRawID());
			return null;
		}
		return c;
	}
	
	public static boolean unregisterDrawCallback(XPLMDrawCallback callback) {
		return unregisterDrawCallback(callback.getPhase(), callback.isWantsBefore(), callback.getRawID());
	}
	
	public static boolean unregisterDrawCallback(XPLMDrawingPhase phase, boolean wantsBefore, long rawID) {
		J4XP.deleteDrawCallback(rawID);
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_UNREGISTER_DRAW_CALLBACK, phase.getRawValue(), wantsBefore, rawID);
	}
	
	public static XPLMWindowID createWindowEx(XPLMCreateWindow params) {
		// TODO: Implement
		return null;
	}
	
	public static XPLMWindowID createWindow(int left, int top, int right, int bottom, boolean isVisible, XPLMDrawWindow drawCallback, XPLMHandleKey keyCallback, XPLMHandleMouseClick mouseCallback, Object refcon) {
		// TODO: Implement
		return null;
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
	
	//TODO GetAllMonitorBoundsGlobal
	
	//TODO GetAllMonitorBoundsOS
	
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
	
	//TODO SetWindowPositioningMode
	
	public static void setWindowTitle(XPLMWindowID windowID, String windowTitle) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_TITLE, windowID.getRawID(), windowTitle);
	}
	
	public static void getWindowRefCon(XPLMWindowID windowID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_WINDOW_REFCON, windowID.getRawID());
	}
	
	public static void setWindowRefCon(XPLMWindowID windowID, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_SET_WINDOW_REFCON, windowID.getRawID(), refcon);
	}
	
	public static boolean hasKeyboardFocus(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_HAS_KEYBOARD_FOCUS, windowID.getRawID());
	}
	
	public static void bringWindowToFront(XPLMWindowID windowID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_BRING_WINDOW_TO_FRONT, windowID.getRawID());
	}
	
	public static boolean isWindowInFront(XPLMWindowID windowID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_IS_WINDOW_IN_FRONT, windowID.getRawID());
	}
	
	//TODO RegisterKeySniffer
	
	//TODO UnregisterKeySniffer
	
	//TODO RegisterHotKey
	
	//TODO UnregisterHotKey
	
	//TODO CountHotKeys
	
	//TODO GetNthHotKey
	
	//TODO GetHotKeyInfo
	
	//TODO SetHotKeyCombination

}