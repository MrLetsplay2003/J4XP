package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;
import me.mrletsplay.j4xp.natives.enums.XPLMMouseStatus;

public interface XPLMHandleMouseClick {

	public boolean onMouseClick(XPLMWindowID windowID, int x, int y, XPLMMouseStatus mouse, Object refcon);
	
}
