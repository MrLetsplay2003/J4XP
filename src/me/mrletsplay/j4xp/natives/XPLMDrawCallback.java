package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.natives.classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMDrawCallback implements PluginOwnable {

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
