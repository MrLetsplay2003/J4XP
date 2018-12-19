package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPStandardPropertyValues;

public enum TextFieldType {

	ENTRY_FIELD(XPStandardPropertyValues.TEXT_FIELD_TYPE_ENTRY_FIELD),
	TRANSPARENT(XPStandardPropertyValues.TEXT_FIELD_TYPE_TRANSPARENT),
	TRANSLUCENT(XPStandardPropertyValues.TEXT_FIELD_TYPE_TRANSLUCENT),
	;
	
	private final int value;
	
	private TextFieldType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
