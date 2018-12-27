package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMCommandPhase {
	
	BEGIN(0),
	CONTINUE(1),
	END(2),
	;
	
	private final int rawValue;
	
	private XPLMCommandPhase(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMCommandPhase byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
