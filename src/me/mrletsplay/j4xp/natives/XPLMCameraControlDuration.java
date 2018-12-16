package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

public enum XPLMCameraControlDuration {

	CONTROL_UNTIL_VIEW_CHANGES(1),
	CONTROL_CAMERA_FOREVER(2),
	;
	
	private final int rawValue;
	
	private XPLMCameraControlDuration(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}

	public static XPLMCameraControlDuration byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}