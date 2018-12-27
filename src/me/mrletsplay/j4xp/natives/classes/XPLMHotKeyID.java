package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.interfaces.XPLMHotKey;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMHotKeyID implements J4XPPluginOwnable, J4XPIdentifiable {
	
	private XPPlugin owner;
	private long rawID;
	private XPLMHotKey callback;
	private Object refcon;
	
	public XPLMHotKeyID(XPPlugin owner, long rawID, XPLMHotKey callback, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.callback = callback;
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
	
	public XPLMHotKey getCallback() {
		return callback;
	}
	
	public Object getRefcon() {
		return refcon;
	}

	@Override
	public void destroy() {
		XPLMDisplay.unregisterHotKey(this);
	}

}
