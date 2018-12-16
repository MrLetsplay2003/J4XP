package me.mrletsplay.j4xp.natives;

public class XPLMDataRef {

	private long rawID;
	private XPLMDataAccessor dataAccessor;
	
	public XPLMDataRef(long rawID) {
		this.rawID = rawID;
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
	
}
