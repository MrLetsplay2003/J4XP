package me.mrletsplay.j4xp.entity.menu;

import me.mrletsplay.j4xp.natives.XPLMMenuCheck;

public class MenuItem {

	private Menu menu;
	private int index;
	
	protected MenuItem(Menu menu, int index) {
		this.menu = menu;
		this.index = index;
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
	
}
