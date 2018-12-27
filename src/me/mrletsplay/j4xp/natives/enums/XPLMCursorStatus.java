package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMCursorStatus {

	DEFAULT(0),
	HIDDEN(1),
	ARROW(2),
	CUSTOM(3),
	;
	
	private final int rawValue;
	
	private XPLMCursorStatus(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMCursorStatus byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
