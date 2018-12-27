package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMProbeType {
	
	PROBE_Y(0),
	;
	
	private final int rawValue;
	
	private XPLMProbeType(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMProbeType byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
