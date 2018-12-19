package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetButton;

@FunctionalInterface
public interface OnPushButtonStateChanged {

	public boolean onPushButtonStateChanged(WidgetButton button, boolean newState);
	
}
