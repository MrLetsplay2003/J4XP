package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMDataFileType {
	
	SITUATION(1),
	REPLAY_MOVIE(2),
	;
	
	private final int rawValue;
	
	private XPLMDataFileType(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMDataFileType byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
