package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMFontID {
	
	BASIC(0),
	MENUS(1),
	METAL(2),
	LED(3),
	LED_WIDE(4),
	PANEL_HUD(5),
	PANEL_EFIS(6),
	PANEL_GPS(7),
	RADIOS_GA(8),
	RADIOS_BC(9),
	RADIOS_HM(10),
	RADIOS_GA_NARROW(11),
	RADIOS_BC_NARROW(12),
	RADIOS_HM_NARROW(13),
	TIMER(14),
	FULL_ROUND(15),
	SMALL_ROUND(16),
	MENUS_LOCALIZED(17),
	PROPORTIONAL(18),
	;
	
	private final int rawValue;
	
	private XPLMFontID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMFontID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
