package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMKeySniffer implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private KeySniffer callback;
	private boolean beforeWindows;
	private Object refcon;
	
	public XPLMKeySniffer(XPPlugin owner, long rawID, KeySniffer callback, boolean beforeWindows, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.callback = callback;
		this.beforeWindows = beforeWindows;
		this.refcon = refcon;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	public KeySniffer getCallback() {
		return callback;
	}
	
	public boolean isBeforeWindows() {
		return beforeWindows;
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
		XPLMDisplay.unregisterKeySniffer(this);
	}
	
}
