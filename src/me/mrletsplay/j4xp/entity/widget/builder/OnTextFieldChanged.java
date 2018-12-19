package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetTextField;

@FunctionalInterface
public interface OnTextFieldChanged {

	public void onTextFieldChanged(WidgetTextField field);
	
}
