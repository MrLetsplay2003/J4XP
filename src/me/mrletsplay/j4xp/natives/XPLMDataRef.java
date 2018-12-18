package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.natives.classes.XPLMDataAccess;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMDataRef implements PluginOwnable {

	private XPPlugin owner;
	private long rawID;
	private XPLMDataAccessor dataAccessor;
	
	public XPLMDataRef(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
		if(owner != null) owner.addOwnedObject(this);
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public void setDataAccessor(XPLMDataAccessor dataAccessor) {
		this.dataAccessor = dataAccessor;
	}
	
	public XPLMDataAccessor getDataAccessor() {
		return dataAccessor;
	}

	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMDataAccess.unregisterDataAccessor(this);
	}
	
}
