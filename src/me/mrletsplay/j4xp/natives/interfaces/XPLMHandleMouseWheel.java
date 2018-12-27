package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;

public interface XPLMHandleMouseWheel {

	public boolean onMouseWheel(XPLMWindowID windowID, int x, int y, int wheel, int clicks, Object refcon);
	
}
