package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.interfaces.FlightLoop;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMProcessing;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMFlightLoopCallback implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private FlightLoop callback;
	private Object refcon;
	
	public XPLMFlightLoopCallback(XPPlugin owner, long rawID, FlightLoop callback, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.callback = callback;
		this.refcon = refcon;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	public FlightLoop getCallback() {
		return callback;
	}
	
	public Object getRefcon() {
		return refcon;
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
	@Override
	public void destroy() {
		XPLMProcessing.unregisterFlightLoopCallback(this);
	}
	
}
