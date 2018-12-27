package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPMenuMessage;

@FunctionalInterface
public interface MenuHandler {

	public void onMenuMessage(XPMenuMessage message);
	
}
