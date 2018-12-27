package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPDestructible;
import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMScenery;

public class XPLMObjectRef implements J4XPIdentifiable, J4XPDestructible {
	
	private long rawID;
	
	public XPLMObjectRef(long rawID) {
		this.rawID = rawID;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}

	@Override
	public void destroy() {
		XPLMScenery.unloadObject(this);
	}
	
}
