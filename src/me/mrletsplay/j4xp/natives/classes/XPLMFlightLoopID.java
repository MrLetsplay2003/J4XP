package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMProcessing;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMFlightLoopID implements J4XPPluginOwnable, J4XPIdentifiable {
	
	private XPPlugin owner;
	private long rawID;
	private XPLMCreateFlightLoop creationParameters;
	
	public XPLMFlightLoopID(XPPlugin owner, long rawID, XPLMCreateFlightLoop creationParameters) {
		this.owner = owner;
		this.rawID = rawID;
		this.creationParameters = creationParameters;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
	public XPLMCreateFlightLoop getCreationParameters() {
		return creationParameters;
	}

	@Override
	public void destroy() {
		XPLMProcessing.destroyFlightLoop(this);
	}

}
