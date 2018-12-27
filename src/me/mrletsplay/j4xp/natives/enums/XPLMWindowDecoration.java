package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMWindowDecoration {

	NONE(0),
	ROUND_RECTANGLE(1),
	SELF_DECORATED(2),
	SELF_DECORATED_RESIZABLE(3),
	;
	
	private final int rawValue;
	
	private XPLMWindowDecoration(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMWindowDecoration byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
