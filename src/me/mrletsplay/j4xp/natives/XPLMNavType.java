package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

public enum XPLMNavType {
	
	UNKNOWN(0),
	AIRPORT(1),
	NDB(2),
	VOR(4),
	ILS(8),
	LOCALIZER(16),
	GLIDE_SLOPE(32),
	OUTER_MARKER(64),
	MIDDLE_MARKER(128),
	INNER_MARKER(256),
	FIX(512),
	DME(1024),
	LAT_LON(2048),
	;
	
	private final int rawValue;
	
	private XPLMNavType(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMNavType byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	

}
