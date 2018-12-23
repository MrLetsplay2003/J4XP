package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.J4XPIdentifiable;

public class XPLMDataRef implements J4XPIdentifiable {

	private long rawID;
	private XPLMDataAccessor dataAccessor;
	
	public XPLMDataRef(long rawID) {
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

}
