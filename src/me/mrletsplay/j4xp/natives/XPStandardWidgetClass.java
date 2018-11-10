package me.mrletsplay.j4xp.natives;

public enum XPStandardWidgetClass {

	MAIN_WINDOW(1),
	SUB_WINDOW(2),
	BUTTON(3),
	TEXT_FIELD(4),
	SCROLL_BAR(5),
	CAPTION(6),
	GENERAL_GRAPHICS(7),
	PROGRESS(8);
	
	private int id;
	
	private XPStandardWidgetClass(int standardID) {
		this.id = standardID;
	}
	
	public int getID() {
		return id;
	}
	
}
