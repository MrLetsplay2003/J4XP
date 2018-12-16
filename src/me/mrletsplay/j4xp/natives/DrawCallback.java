package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface DrawCallback {

	public int onDraw(XPLMDrawingPhase phase, int isBefore, Object refcon);
	
}
