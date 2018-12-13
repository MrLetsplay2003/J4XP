package me.mrletsplay.j4xp.natives;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.entity.menu.Menu;
import me.mrletsplay.j4xp.natives.classes.XPLMMenus;

public class XPLMMenuID {

	private long rawID;
	private List<MenuHandler> handlers;
	private Menu menu;
	
	public XPLMMenuID(long rawID) {
		this.rawID = rawID;
		this.handlers = new ArrayList<>();
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public void registerHandler(MenuHandler handler) {
		handlers.add(handler);
	}
	
	public List<MenuHandler> getHandlers() {
		return handlers;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public void destroy() {
		XPLMMenus.destroyMenu(this);
	}
	
}
