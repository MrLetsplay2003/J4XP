package me.mrletsplay.j4xp.natives;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.entity.menu.Menu;
import me.mrletsplay.j4xp.natives.classes.XPLMMenus;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMMenuID implements PluginOwnable {

	private XPPlugin owner;
	private long rawID;
	private List<MenuHandler> handlers;
	private Menu menu;
	
	public XPLMMenuID(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
		this.handlers = new ArrayList<>();
		if(owner != null) owner.addOwnedObject(this);
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

	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
}
