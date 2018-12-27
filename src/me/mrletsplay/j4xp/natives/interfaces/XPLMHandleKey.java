package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMWindowID;
import me.mrletsplay.j4xp.natives.enums.XPLMKeyFlag;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public interface XPLMHandleKey {

	public void onKey(XPLMWindowID windowID, char key, EnumFlagCompound<XPLMKeyFlag> flags, char virtualKey, Object refcon, boolean losingFocus);
	
}
