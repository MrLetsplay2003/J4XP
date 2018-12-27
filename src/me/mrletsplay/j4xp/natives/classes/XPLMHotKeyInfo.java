package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMKeyFlag;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMHotKeyInfo {

	private char virtualKey;
	private EnumFlagCompound<XPLMKeyFlag> flags;
	private String description;
	private XPLMPluginID plugin;
	
	public XPLMHotKeyInfo(char virtualKey, EnumFlagCompound<XPLMKeyFlag> flags, String description, XPLMPluginID plugin) {
		this.virtualKey = virtualKey;
		this.flags = flags;
		this.description = description;
		this.plugin = plugin;
	}
	
	public char getVirtualKey() {
		return virtualKey;
	}
	
	public EnumFlagCompound<XPLMKeyFlag> getFlags() {
		return flags;
	}
	
	public String getDescription() {
		return description;
	}
	
	public XPLMPluginID getPlugin() {
		return plugin;
	}
	
}
