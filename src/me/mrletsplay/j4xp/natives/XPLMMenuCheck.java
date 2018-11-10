package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

public enum XPLMMenuCheck {

	NO_CHECK(0),
	UNCHECKED(1),
	CHECKED(2),
	;
	
	private final int rawValue;
	
	private XPLMMenuCheck(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMMenuCheck byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
