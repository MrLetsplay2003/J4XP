package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMMapStyle {
	
	VFR_SECTIONAL(0),
	IFR_LOW_ENROUTE(1),
	IFR_HIGH_ENROUTE(2),
	;
	
	private final int rawValue;
	
	private XPLMMapStyle(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMMapStyle byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
