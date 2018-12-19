package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPStandardPropertyValues;

public enum ButtonBehavior {

	PUSH_BUTTON(XPStandardPropertyValues.BUTTON_BEHAVIOR_PUSH_BUTTON),
	CHECK_BOX(XPStandardPropertyValues.BUTTON_BEHAVIOR_CHECK_BOX),
	RADIO_BUTTON(XPStandardPropertyValues.BUTTON_BEHAVIOR_RADIO_BUTTON),
	;
	
	private final int value;
	
	private ButtonBehavior(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
