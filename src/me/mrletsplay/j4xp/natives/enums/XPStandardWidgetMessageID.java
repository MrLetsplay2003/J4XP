package me.mrletsplay.j4xp.natives.enums;

import me.mrletsplay.j4xp.natives.interfaces.XPWidgetMessageID;

public enum XPStandardWidgetMessageID implements XPWidgetMessageID {
	
	NONE(0),
	CREATE(1),
	DESTROY(2),
	PAINT(3),
	DRAW(4),
	KEY_PRESS(5),
	KEY_TAKE_FOCUS(6),
	KEY_LOSE_FOCUS(7),
	MOUSE_DOWN(8),
	MOUSE_DRAG(9),
	MOUSE_UP(10),
	RESHAPE(11),
	EXPOSED_CHANGED(12),
	ACCEPT_CHILD(13),
	LOSE_CHILD(14),
	ACCEPT_PARENT(15),
	SHOWN(16),
	HIDDEN(17),
	DESCRIPTOR_CHANGED(18),
	PROPERTY_CHANGED(19),
	MOUSE_WHEEL(20),
	CURSOR_ADJUST(21),
	
	MAIN_WINDOW_CLOSE_BUTTON_PUSHED(1200),
	
	BUTTON_PUSH_BUTTON_PRESSED(1300),
	BUTTON_STATE_CHANGED(1301),
	
	TEXT_FIELD_CHANGED(1400),
	
	SCROLL_BAR_SLIDER_POSITION_CHANGED(1500),
	
	USER_START(10000),
	;
	
	private int rawID;
	
	private XPStandardWidgetMessageID(int rawID) {
		this.rawID = rawID;
	}
	
	@Override
	public int getMessageID() {
		return rawID;
	}

}
