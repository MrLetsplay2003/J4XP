package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.natives.classes.XPLMMap;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMMapLayerID implements PluginOwnable {
	
	private XPPlugin owner;
	private long rawID;
	
	public XPLMMapLayerID(XPPlugin owner, long rawID) {
		this.rawID = rawID;
		if(owner != null) owner.addOwnedObject(this);
	}
	
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
