package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMMouseStatus {
	
	MOUSE_DOWN(1),
	MOUSE_DRAG(2),
	MOUSE_UP(3);

	private final int rawValue;
	
	private XPLMMouseStatus(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMMouseStatus byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
