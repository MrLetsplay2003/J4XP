package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPLMCommandRef;
import me.mrletsplay.j4xp.natives.XPLMMenuCheck;
import me.mrletsplay.j4xp.natives.XPLMMenuID;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMMenus {

	public static XPLMMenuID findPluginsMenu() {
		return J4XP.getOrCreateMenuID(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_FIND_PLUGINS_MENU));
	}

	public static XPLMMenuID findAircraftMenu() {
		return J4XP.getOrCreateMenuID(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_FIND_AIRCRAFT_MENU));
	}
	
	public static XPLMMenuID createMenu(String name, XPLMMenuID parentMenu, int parentItem) {
		return J4XP.getOrCreateMenuID(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_CREATE_MENU, name, parentMenu.getRawID(), parentItem));
	}
	
	public static void destroyMenu(XPLMMenuID menu) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_DESTROY_MENU, menu.getRawID());
	}
	
	public static void clearAllMenuItems(XPLMMenuID menu) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_CLEAR_ALL_MENU_ITEMS, menu.getRawID());
	}
	
	public static int appendMenuItem(XPLMMenuID menu, String itemName, Object itemRef) {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_APPEND_MENU_ITEM, menu.getRawID(), itemName, itemRef);
	}
	
	public static int appendMenuItemWithCommand(XPLMMenuID menu, String itemName, XPLMCommandRef commandRef) {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_APPEND_MENU_ITEM_WITH_COMMAND, menu.getRawID(), itemName, commandRef);
	}
	
	public static void appendMenuSeparator(XPLMMenuID menu) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_APPEND_MENU_SEPARATOR, menu.getRawID());
	}
	
	public static void setMenuItemName(XPLMMenuID menu, int index, String itemName, boolean forceEnglish) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_SET_MENU_ITEM_NAME, menu.getRawID(), index, itemName, forceEnglish);
	}
	
	public static void checkMenuItem(XPLMMenuID menu, int index, XPLMMenuCheck check) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_CHECK_MENU_ITEM, menu.getRawID(), index, check.getRawValue());
	}
	
	public static XPLMMenuCheck checkMenuItemState(XPLMMenuID menu, int index) {
		return XPLMMenuCheck.byValue((int) XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_CHECK_MENU_ITEM_STATE, menu.getRawID(), index));
	}
	
	public static void enableMenuItem(XPLMMenuID menu, int index, boolean enabled) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_ENABLE_MENU_ITEM, menu.getRawID(), index, enabled);
	}
	
	public static void removeMenuItem(XPLMMenuID menu, int index) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMENUS_REMOVE_MENU_ITEM, menu.getRawID(), index);
	}
	
}
