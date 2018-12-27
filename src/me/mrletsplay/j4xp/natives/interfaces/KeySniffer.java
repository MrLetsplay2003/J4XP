package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.enums.XPLMKeyFlag;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

@FunctionalInterface
public interface KeySniffer {
	
	public boolean onKeySniffer(char character, EnumFlagCompound<XPLMKeyFlag> flags, char virtualKey, Object refcon);

}
