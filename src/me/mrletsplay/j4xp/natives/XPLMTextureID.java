package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

public enum XPLMTextureID {
	
	GENERAL_INTERFACE(0),
	AIRCRAFT_PAINT(1),
	AIRCRAFT_LITE_MAP(2),
	;
	
	private final int rawValue;
	
	private XPLMTextureID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMTextureID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
}
