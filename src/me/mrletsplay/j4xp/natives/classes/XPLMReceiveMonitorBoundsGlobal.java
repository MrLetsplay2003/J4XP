package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.interfaces.ReceiveMonitorBoundsGlobal;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMReceiveMonitorBoundsGlobal implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private ReceiveMonitorBoundsGlobal handlerFunction;
	private Object refcon;
	
	public XPLMReceiveMonitorBoundsGlobal(XPPlugin owner, long rawID, ReceiveMonitorBoundsGlobal handlerFunction, Object refcon) {
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
	
	public ReceiveMonitorBoundsGlobal getHandlerFunction() {
		return handlerFunction;
	}
	
	public Object getRefcon() {
		return refcon;
	}

	@Override
	public void destroy() {
		J4XP.getReceiveMonitorGlobals().remove(rawID);
	}

}
