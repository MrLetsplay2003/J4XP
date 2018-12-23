package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

import me.mrletsplay.mrcore.misc.FlagCompound.Flag;

public enum XPLMKeyFlag implements Flag {

	SHIFT(1),
	OPTION_ALT(2),
	CONTROL(4),
	DOWN(8),
	UP(16);
	
	private final int rawValue;
	
	private XPLMKeyFlag(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMKeyFlag byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public long getValue() {
		return rawValue;
	}
	
}
