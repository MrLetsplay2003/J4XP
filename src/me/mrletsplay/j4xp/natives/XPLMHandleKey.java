package me.mrletsplay.j4xp.natives;

import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public interface XPLMHandleKey {

	public void onKey(XPLMWindowID windowID, char key, EnumFlagCompound<XPLMKeyFlag> flags, char virtualKey, Object refcon, boolean losingFocus);
	
}
