package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.natives.classes.XPStandardPropertyValues;

public enum ScrollBarType {

	SCROLL_BAR(XPStandardPropertyValues.SCROLL_BAR_TYPE_SCROLL_BAR),
	SLIDER(XPStandardPropertyValues.SCROLL_BAR_TYPE_SLIDER),
	;
	
	private final int value;
	
	private ScrollBarType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
