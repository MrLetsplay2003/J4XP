package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDataAccess;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMDataRef implements J4XPIdentifiable, J4XPPluginOwnable {

	private XPPlugin owner;
	private long rawID;
	private XPLMDataAccessor dataAccessor;
	
	public XPLMDataRef(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
	}
	
	@Override
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
