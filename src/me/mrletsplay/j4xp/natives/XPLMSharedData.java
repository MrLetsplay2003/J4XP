package me.mrletsplay.j4xp.natives;

import me.mrletsplay.j4xp.natives.classes.XPLMDataAccess;
import me.mrletsplay.j4xp.plugin.PluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMSharedData implements PluginOwnable {

	private XPPlugin owner;
	private long rawID;
	private String dataName;
	private EnumFlagCompound<XPLMDataTypeID> dataType;
	private XPLMDataChanged dataChanged;
	private Object refcon;
	
	public XPLMSharedData(XPPlugin owner, long rawID, String dataName, EnumFlagCompound<XPLMDataTypeID> dataType, XPLMDataChanged dataChanged, Object refcon) {
		this.owner = owner;
		this.rawID = rawID;
		this.dataName = dataName;
		this.dataType = dataType;
		this.dataChanged = dataChanged;
		this.refcon = refcon;
		if(owner != null) owner.addOwnedObject(this);
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

	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		XPLMDataAccess.unshareData(this);
	}
	
}
