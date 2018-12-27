package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMHostApplicationID {
	
	UNKNOWN(0),
	XPLANE(1),
	PLANE_MAKER(2),
	WORLD_MAKER(3),
	BRIEFER(4),
	PART_MAKER(5),
	YOUNGS_MOD(6),
	XAUTO(7),
	;
	
	private final int rawValue;
	
	private XPLMHostApplicationID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMHostApplicationID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

}
