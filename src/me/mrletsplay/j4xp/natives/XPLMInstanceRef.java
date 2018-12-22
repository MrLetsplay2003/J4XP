package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMInstanceRef implements PluginOwnable {
	
	private XPPlugin owner;
	private long rawID;
	
	public XPLMInstanceRef(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
		if(owner != null) owner.addOwnedObject(this);
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
		// TODO
	}

}
