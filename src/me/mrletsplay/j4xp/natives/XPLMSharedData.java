package me.mrletsplay.j4xp.natives;

import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMSharedData {

	private long rawID;
	private String dataName;
	private EnumFlagCompound<XPLMDataTypeID> dataType;
	private XPLMDataChanged dataChanged;
	private Object refcon;
	
	public XPLMSharedData(long rawID, String dataName, EnumFlagCompound<XPLMDataTypeID> dataType, XPLMDataChanged dataChanged, Object refcon) {
		this.rawID = rawID;
		this.dataName = dataName;
		this.dataType = dataType;
		this.dataChanged = dataChanged;
		this.refcon = refcon;
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public String getDataName() {
		return dataName;
	}
	
	public EnumFlagCompound<XPLMDataTypeID> getDataType() {
		return dataType;
	}
	
	public XPLMDataChanged getDataChanged() {
		return dataChanged;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
}
