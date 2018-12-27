package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.natives.classes.XPStandardPropertyValues;

public enum ButtonType {

	PUSH_BUTTON(XPStandardPropertyValues.BUTTON_TYPE_PUSH_BUTTON),
	RADIO_BUTTON(XPStandardPropertyValues.BUTTON_TYPE_RADIO_BUTTON),
	WINDOW_CLOSE_BOX(XPStandardPropertyValues.BUTTON_TYPE_WINDOW_CLOSE_BOX),
	LITTLE_DOWN_ARROW(XPStandardPropertyValues.BUTTON_TYPE_LITTLE_DOWN_ARROW),
	LITTLE_UP_ARROW(XPStandardPropertyValues.BUTTON_TYPE_LITTLE_UP_ARROW),
	;
	
	private final int value;
	
	private ButtonType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
