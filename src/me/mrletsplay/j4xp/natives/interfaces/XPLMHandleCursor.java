package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;
import me.mrletsplay.j4xp.natives.enums.XPLMCursorStatus;

public interface XPLMHandleCursor {

	public XPLMCursorStatus onCursor(XPLMWindowID windowID, int x, int y, Object refcon);
	
}
