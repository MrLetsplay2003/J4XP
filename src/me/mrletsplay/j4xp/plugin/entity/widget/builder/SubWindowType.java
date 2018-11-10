package me.mrletsplay.j4xp.plugin.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPStandardPropertyValues;

public enum SubWindowType {

	DEFAULT(XPStandardPropertyValues.SUB_WINDOW_STYLE_SUB_WINDOW),
	SCREEN(XPStandardPropertyValues.SUB_WINDOW_STYLE_SCREEN),
	LIST_VIEW(XPStandardPropertyValues.SUB_WINDOW_STYLE_LIST_VIEW),
	;
	
	private final int value;
	
	private SubWindowType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
