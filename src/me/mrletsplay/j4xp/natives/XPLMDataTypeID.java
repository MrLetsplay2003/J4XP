package me.mrletsplay.j4xp.natives;

import java.util.Arrays;

import me.mrletsplay.mrcore.misc.EnumFlagCompound;
import me.mrletsplay.mrcore.misc.FlagCompound.Flag;

public enum XPLMDataTypeID implements Flag {

	UNKNOWN(0),
	INT(1),
	FLOAT(2),
	DOUBLE(4),
	FLOAT_ARRAY(8),
	INT_ARRAY(16),
	DATA(32)
	;
	
	private final int rawValue;
	
	private XPLMDataTypeID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}

	public static XPLMDataTypeID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}

	public static EnumFlagCompound<XPLMDataTypeID> byValues(long rawValue) {
		return EnumFlagCompound.of(XPLMDataTypeID.class, rawValue);
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