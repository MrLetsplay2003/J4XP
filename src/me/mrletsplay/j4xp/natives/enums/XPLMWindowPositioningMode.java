package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMWindowPositioningMode {

	POSITION_FREE(0),
	CENTER_ON_MONITOR(1),
	FULL_SCREEN_ON_MONITOR(2),
	FULL_SCREEN_ON_ALL_MONITORS(3),
	POP_OUT(4),
	VR(5),
	;
	
	private final int rawValue;
	
	private XPLMWindowPositioningMode(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMWindowPositioningMode byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
}
