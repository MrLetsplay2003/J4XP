package me.mrletsplay.j4xp.entity.menu;

import me.mrletsplay.j4xp.natives.enums.XPLMMenuCheck;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMMenus;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class MenuItem implements J4XPPluginOwnable {

	private XPPlugin owner;
	private Menu menu;
	private int index;
	
	protected MenuItem(XPPlugin owner, Menu menu, int index) {
		this.owner = owner;
		this.menu = menu;
		this.index = index;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	protected void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setName(String name, boolean forceEnglish) {
		menu.setMenuItemName(index, name, forceEnglish);
	}
	
	public void check(XPLMMenuCheck check) {
		menu.checkMenuItem(index, check);
	}
	
	public XPLMMenuCheck checkState() {
		return menu.checkMenuItemState(index);
	}
	
	public void enable(boolean enabled) {
		menu.enableMenuItem(index, enabled);
	}
	
	public void remove() {
		menu.removeMenuItem(index);
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMMenus.removeMenuItem(menu.getID(), index);
	}
	
}
