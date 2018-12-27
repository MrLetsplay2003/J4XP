package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMProcessing;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMFlightLoopID implements J4XPPluginOwnable, J4XPIdentifiable {
	
	private XPPlugin owner;
	private long rawID;
	
	public XPLMFlightLoopID(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMProcessing.destroyFlightLoop(this);
	}

}
