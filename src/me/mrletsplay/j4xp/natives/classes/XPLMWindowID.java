package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDisplay;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMWindowID implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private XPLMCreateWindow windowParameters; // TODO: Change type
	
	public XPLMWindowID(XPPlugin owner, long rawID, XPLMCreateWindow windowParameters) {
		this.owner = owner;
		this.rawID = rawID;
		this.windowParameters = windowParameters;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}
	
	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
	public XPLMCreateWindow getWindowParameters() {
		return windowParameters;
	}

	@Override
	public void destroy() {
		XPLMDisplay.destroyWindow(this);
	}
	
}
