package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

public enum XPLMProbeResult {
	
	HIT_TERRAIN(0),
	ERROR(1),
	MISSED(2),
	;
	
	private final int rawValue;
	
	private XPLMProbeResult(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMProbeResult byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
