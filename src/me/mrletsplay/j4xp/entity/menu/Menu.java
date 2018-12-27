package me.mrletsplay.j4xp.entity.menu;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.classes.XPLMMenuID;
import me.mrletsplay.j4xp.natives.enums.XPLMMenuCheck;
import me.mrletsplay.j4xp.natives.interfaces.MenuHandler;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMMenus;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class Menu {
	
	private XPLMMenuID id;
	private List<MenuItem> items;
	
	public Menu(XPLMMenuID id) {
		this.id = id;
		this.items = new ArrayList<>();
	}
	
	public XPLMMenuID getID() {
		return id;
	}
	
	public List<MenuItem> getMenuItems() {
		return items;
	}
	
	public MenuItem getMenuItem(int index) {
		return items.stream().filter(i -> i.getIndex() == index).findFirst().orElse(null);
	}
	
	public MenuItem appendMenuItem(String itemName, Object itemRef) {
		MenuItem it = new MenuItem(J4XPUtils.getMethodCaller(), this, XPLMMenus.appendMenuItem(getID(), itemName, itemRef));
		items.add(it);
		return it;
	}

	public void checkMenuItem(int index, XPLMMenuCheck check) {
		XPLMMenus.checkMenuItem(getID(), index, check);
	}

	public XPLMMenuCheck checkMenuItemState(int index) {
		return XPLMMenus.checkMenuItemState(getID(), index);
	}

	public void enableMenuItem(int index, boolean enabled) {
		XPLMMenus.enableMenuItem(getID(), index, enabled);
	}

	public void removeMenuItem(int index) {
		XPLMMenus.removeMenuItem(getID(), index);
		for(MenuItem it : getMenuItems()) {
			if(it.getIndex() > index) it.setIndex(it.getIndex() - 1);
		}
	}

	public void setMenuItemName(int index, String itemName, boolean forceEnglish) {
		XPLMMenus.setMenuItemName(getID(), index, itemName, forceEnglish);
	}

	public void appendMenuSeparator() {
		XPLMMenus.appendMenuSeparator(getID());
	}
	
	public void clearAllMenuItems() {
		XPLMMenus.clearAllMenuItems(getID());
	}
	
	public void destroy() {
		XPLMMenus.destroyMenu(getID());
	}
	
	public void registerHandler(MenuHandler handler) {
		getID().registerHandler(handler);
	}
	
	public static Menu getPluginsMenu() {
		return new Menu(XPLMMenus.findPluginsMenu());
	}
	
	public static Menu getAircraftMenu() {
		return new Menu(XPLMMenus.findAircraftMenu());
	}
	
	public static Menu createMenu(String name, Menu parentMenu, MenuItem parentItem) {
		return new Menu(XPLMMenus.createMenu(name, parentMenu.getID(), parentItem.getIndex()));
	}

}
