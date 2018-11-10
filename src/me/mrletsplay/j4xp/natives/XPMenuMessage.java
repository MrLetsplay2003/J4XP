package me.mrletsplay.j4xp.natives;

public class XPMenuMessage {
	
	private XPLMMenuID menu;
	private Object itemRef;
	
	public XPMenuMessage(XPLMMenuID menu, Object itemRef) {
		this.menu = menu;
		this.itemRef = itemRef;
	}
	
	public XPLMMenuID getMenu() {
		return menu;
	}
	
	public Object getItemRef() {
		return itemRef;
	}

}
