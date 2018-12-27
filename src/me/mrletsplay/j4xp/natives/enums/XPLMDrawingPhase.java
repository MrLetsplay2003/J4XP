package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMDrawingPhase {

	FIRST_SCENE(0),
	TERRAIN(5),
	AIRPORTS(10),
	VECTORS(15),
	OBJECTS(20),
	AIRPLANES(25),
	LAST_SCENE(30),
	FIRST_COCKPIT(35),
	PANEL(40),
	GAUGES(45),
	WINDOW(50),
	LAST_COCKPIT(55),
	;
	
	private final int rawValue;
	
	private XPLMDrawingPhase(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMDrawingPhase byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
