package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMMapOrientation {
	
	MAP(0),
	UI(1),
	;
	
	private final int rawValue;
	
	private XPLMMapOrientation(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMMapOrientation byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
