package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.natives.classes.XPStandardPropertyValues;

public enum MainWindowType {

	DEFAULT(XPStandardPropertyValues.MAIN_WINDOW_STYLE_MAIN_WINDOW),
	TRANSLUCENT(XPStandardPropertyValues.MAIN_WINDOW_STYLE_TRANSLUCENT),
	;
	
	private final int value;
	
	private MainWindowType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
