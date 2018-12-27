package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMNavRef implements J4XPPluginOwnable {
	
	private XPPlugin owner;
	private long rawID;
	
	public XPLMNavRef(XPPlugin owner, long rawID) {
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
