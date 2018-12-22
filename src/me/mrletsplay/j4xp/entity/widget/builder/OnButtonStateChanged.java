package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetButton;

@FunctionalInterface
public interface OnButtonStateChanged {

	public boolean onButtonStateChanged(WidgetButton button, boolean newState);
	
}
