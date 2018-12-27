package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.enums.XPLMDrawingPhase;

@FunctionalInterface
public interface DrawCallback {

	public boolean onDraw(XPLMDrawingPhase phase, boolean isBefore, Object refcon);
	
}
