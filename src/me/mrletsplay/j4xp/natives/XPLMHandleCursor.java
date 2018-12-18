package me.mrletsplay.j4xp.natives;

public interface XPLMHandleCursor {

	public XPLMCursorStatus onCursor(XPLMWindowID windowID, int x, int y, Object refcon);
	
}
