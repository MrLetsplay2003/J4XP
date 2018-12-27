package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.interfaces.ReceiveMonitorBoundsOS;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMReceiveMonitorBoundsOS implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private ReceiveMonitorBoundsOS handlerFunction;
	private Object refcon;
	
	public XPLMReceiveMonitorBoundsOS(XPPlugin owner, long rawID, ReceiveMonitorBoundsOS handlerFunction, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.handlerFunction = handlerFunction;
		this.refcon = refcon;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
	public ReceiveMonitorBoundsOS getHandlerFunction() {
		return handlerFunction;
	}
	
	public Object getRefcon() {
		return refcon;
	}

	@Override
	public void destroy() {
		J4XP.getReceiveMonitorOSs().remove(rawID);
	}

}
