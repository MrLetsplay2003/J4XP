package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMMapLayerType {
	
	FILL(0),
	MARKINGS(1),
	;
	
	private final int rawValue;
	
	private XPLMMapLayerType(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMMapLayerType byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
