package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMCommandRef;
import me.mrletsplay.j4xp.natives.enums.XPLMCommandPhase;

@FunctionalInterface
public interface XPLMCommandCallback {
	
	public boolean onCommandCallback(XPLMCommandRef command, XPLMCommandPhase phase, Object refcon);

}
