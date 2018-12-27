package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMFlightLoopPhaseType {
	
	BEFORE_FLIGHT_MODEL(0),
	AFTER_FLIGHT_MODEL(1),
	;
	
	private final int rawValue;
	
	private XPLMFlightLoopPhaseType(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMFlightLoopPhaseType byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}