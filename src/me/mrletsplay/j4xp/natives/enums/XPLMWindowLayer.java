package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMWindowLayer {

	FLIGHT_OVERLAY(0),
	FLOATING_WINDOWS(1),
	MODAL(2),
	GROWL_NOTIFICATIONS(3),
	;
	
	private final int rawValue;
	
	private XPLMWindowLayer(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMWindowLayer byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
