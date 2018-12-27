package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.enums.XPLMDrawingPhase;
import me.mrletsplay.j4xp.natives.interfaces.DrawCallback;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMDrawCallback implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private DrawCallback callback;
	private XPLMDrawingPhase phase;
	private boolean wantsBefore;
	private Object refcon;
	
	public XPLMDrawCallback(XPPlugin owner, long rawID, DrawCallback callback, XPLMDrawingPhase phase, boolean wantsBefore, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.callback = callback;
		this.phase = phase;
		this.wantsBefore = wantsBefore;
		this.refcon = refcon;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	public DrawCallback getCallback() {
		return callback;
	}
	
	public XPLMDrawingPhase getPhase() {
		return phase;
	}
	
	public boolean isWantsBefore() {
		return wantsBefore;
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
		XPLMDisplay.unregisterDrawCallback(this);
	}
	
}
