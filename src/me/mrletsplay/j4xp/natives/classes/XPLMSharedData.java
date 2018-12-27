package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.natives.enums.XPLMDataTypeID;
import me.mrletsplay.j4xp.natives.interfaces.XPLMDataChanged;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDataAccess;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMSharedData implements J4XPPluginOwnable, J4XPIdentifiable {

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
	
	@Override
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
