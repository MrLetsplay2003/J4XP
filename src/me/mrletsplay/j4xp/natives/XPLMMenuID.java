package me.mrletsplay.j4xp.natives;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.classes.XPLMMenus;

public class XPLMMenuID {

	private long rawID;
	private List<MenuHandler> handlers;
	
	public XPLMMenuID(long rawID) {
		this.rawID = rawID;
		this.handlers = new ArrayList<>();
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public void registerHandler(MenuHandler listener) {
		handlers.add(listener);
	}
	
	public List<MenuHandler> getHandlers() {
		return handlers;
	}
	
	public void destroy() {
		XPLMMenus.destroyMenu(this);
	}
	
}
