package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface DrawCallback {

	public boolean onDraw(XPLMDrawingPhase phase, boolean isBefore, Object refcon);
	
}
