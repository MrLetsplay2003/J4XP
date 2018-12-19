package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetButton;

@FunctionalInterface
public interface OnPushButtonPressed {

	public boolean onPushButtonPressed(WidgetButton button);
	
}
