package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.natives.classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMWindowID implements PluginOwnable {

	private XPPlugin owner;
	private long rawID;
	
	public XPLMWindowID(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
	}
	
	public long getRawID() {
		return rawID;
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMDisplay.destroyWindow(this);
	}
	
}
