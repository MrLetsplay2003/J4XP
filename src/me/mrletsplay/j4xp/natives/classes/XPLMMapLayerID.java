package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMMap;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMMapLayerID implements J4XPPluginOwnable, J4XPIdentifiable {
	
	private XPPlugin owner;
	private long rawID;
	
	public XPLMMapLayerID(XPPlugin owner, long rawID) {
		this.rawID = rawID;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMMap.destroyMapLayer(this);
	}
	
}
