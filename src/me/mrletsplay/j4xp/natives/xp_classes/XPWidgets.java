package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPGeometry;
import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPDispatchMode;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.interfaces.XPWidgetClass;
import me.mrletsplay.j4xp.natives.interfaces.XPWidgetMessageID;
import me.mrletsplay.j4xp.natives.interfaces.XPWidgetPropertyID;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPWidgets {

	public static XPWidgetID createWidget(int left, int top, int right, int bottom, boolean visible, String descriptor, boolean isRoot, XPWidgetID container, XPStandardWidgetClass widgetClass) {
		return J4XP.getWidgetIDs().getOrCreate(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_CREATE_WIDGET, left, top, right, bottom, visible, descriptor, isRoot, container == null ? 0 : container.getRawID(), widgetClass.getID()));
	}
	
	public static XPWidgetID createCustomWidget(int left, int top, int right, int bottom, boolean visible, String descriptor, boolean isRoot, XPWidgetID container, XPWidgetClass widgetClass) {
		return J4XP.getWidgetIDs().getOrCreate(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_CREATE_CUSTOM_WIDGET, left, top, right, bottom, visible, descriptor, isRoot, container == null ? 0 : container.getRawID(), widgetClass.getClassID()));
	}
	
	public static void destroyWidget(XPWidgetID widgetID, boolean destroyChildren) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_DESTROY_WIDGET, widgetID.getRawID(), destroyChildren);
	}
	
	public static boolean sendMessageToWidget(XPWidgetID widgetID, XPWidgetMessageID message, XPDispatchMode dispatchMode, Object param1, Object param2) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SEND_MESSAGE_TO_WIDGET, widgetID.getRawID(), message.getMessageID(), dispatchMode.getID(), param1, param2);
	}
	
	public static void placeWidgetWithin(XPWidgetID widgetID, XPWidgetID containerID) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_PLACE_WIDGET_WITHIN, widgetID.getRawID(), containerID.getRawID());
	}
	
	public static int countChildWidgets(XPWidgetID widgetID) {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_COUNT_CHILD_WIDGETS, widgetID.getRawID());
	}
	
	public static XPWidgetID getNthChildWidget(XPWidgetID widgetID, int index) {
		return J4XP.getWidgetIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_NTH_CHILD_WIDGET, widgetID.getRawID(), index));
	}
	
	public static XPWidgetID getParentWidget(XPWidgetID widgetID) {
		return J4XP.getWidgetIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_PARENT_WIDGET, widgetID.getRawID()));
	}
	
	public static void showWidget(XPWidgetID widgetID) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SHOW_WIDGET, widgetID.getRawID());
	}
	
	public static void hideWidget(XPWidgetID widgetID) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_HIDE_WIDGET, widgetID.getRawID());
	}
	
	public static boolean isWidgetVisible(XPWidgetID widgetID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_IS_WIDGET_VISIBLE, widgetID.getRawID());
	}
	
	public static XPWidgetID findRootWidget(XPWidgetID widgetID) {
		return J4XP.getWidgetIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_FIND_ROOT_WIDGET, widgetID.getRawID()));
	}
	
	public static void bringRootWidgetToFront(XPWidgetID widgetID) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_BRING_ROOT_WIDGET_TO_FRONT, widgetID.getRawID());
	}
	
	public static boolean isWidgetInFront(XPWidgetID widgetID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_IS_WIDGET_IN_FRONT, widgetID.getRawID());
	}
	
	public static XPGeometry getWidgetGeometry(XPWidgetID widgetID) {
		int[] rGeom = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_GEOMETRY, widgetID.getRawID());
		return new XPGeometry(rGeom[0], rGeom[1], rGeom[2], rGeom[3]);
	}
	
	public static void setWidgetGeometry(XPWidgetID widgetID, int left, int top, int right, int bottom) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SET_WIDGET_GEOMETRY, widgetID.getRawID(), new int[] {left, top, right, bottom});
	}
	
	public static XPWidgetID getWidgetForLocation(XPWidgetID container, int xOffset, int yOffset, boolean recursive, boolean visibleOnly) {
		return J4XP.getWidgetIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_FOR_LOCATION, container.getRawID(), xOffset, yOffset, recursive, visibleOnly));
	}
	
	public static XPGeometry getWidgetExposedGeometry(XPWidgetID widgetID) {
		int[] rGeom = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_EXPOSED_GEOMETRY, widgetID.getRawID());
		return new XPGeometry(rGeom[0], rGeom[1], rGeom[2], rGeom[3]);
	}
	
	public static void setWidgetDescriptor(XPWidgetID widgetID, String descriptor) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SET_WIDGET_DESCRIPTOR, widgetID.getRawID(), descriptor);
	}
	
	public static String getWidgetDescriptor(XPWidgetID widgetID) {
		return (String) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_DESCRIPTOR, widgetID.getRawID());
	}
	
	public static XPLMWindowID getWidgetUnderlyingWindow(XPWidgetID widgetID) {
		return J4XP.getWindowIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_UNDERLYING_WINDOW, widgetID.getRawID()));
	}
	
	public static void setWidgetProperty(XPWidgetID widgetID, XPWidgetPropertyID property, long propertyValue) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SET_WIDGET_PROPERTY, widgetID.getRawID(), property.getPropertyID(), propertyValue);
	}
	
	public static long getWidgetProperty(XPWidgetID widgetID, XPWidgetPropertyID property) { // TODO: isset?
		return (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_PROPERTY, widgetID.getRawID(), property.getPropertyID());
	}
	
	public static XPWidgetID setKeyboardFocus(XPWidgetID widgetID) {
		long w = (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_SET_KEYBOARD_FOCUS, widgetID.getRawID());
		if(w == 0) return null; // X-Plane has focus
		return J4XP.getWidgetIDs().get(w);
	}
	
	public static void loseKeyboardFocus(XPWidgetID widgetID) {
		XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_LOSE_KEYBOARD_FOCUS, widgetID.getRawID());
	}
	
	public static XPWidgetID getWidgetWithFocus() {
		return J4XP.getWidgetIDs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPWIDGETS_GET_WIDGET_WITH_FOCUS));
	}
	
//	public static addWidgetCallback TODO: Widget callbacks
	
}
