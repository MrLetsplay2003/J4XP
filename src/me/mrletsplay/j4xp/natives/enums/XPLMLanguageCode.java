package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMLanguageCode {
	
	UNKNOWN(0),
	ENGLISH(1),
	FRENCH(2),
	GERMAN(3),
	ITALIAN(4),
	SPANAISH(5),
	KOREAN(6),
	RUSSIAN(7),
	GREEK(8),
	JAPANESE(9),
	CHINESE(10),
	;
	
	private final int rawValue;
	
	private XPLMLanguageCode(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMLanguageCode byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
