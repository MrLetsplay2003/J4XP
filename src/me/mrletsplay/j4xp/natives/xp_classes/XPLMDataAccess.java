package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMDataAccessor;
import me.mrletsplay.j4xp.natives.classes.XPLMDataRef;
import me.mrletsplay.j4xp.natives.classes.XPLMSharedData;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMDataTypeID;
import me.mrletsplay.j4xp.natives.interfaces.XPLMDataChanged;
import me.mrletsplay.j4xp.plugin.J4XPUtils;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;

public class XPLMDataAccess {

	public static XPLMDataRef findDataRef(String refName) {
		return J4XP.getDataRefs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_FIND_DATA_REF, refName));
	}
	
	public static boolean canWriteDataRef(XPLMDataRef ref) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_CAN_WRITE_DATA_REF, ref.getRawID());
	}
	
	public static boolean isDataRefGood(XPLMDataRef ref) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_IS_DATA_REF_GOOD, ref.getRawID());
	}
	
	public static EnumFlagCompound<XPLMDataTypeID> getDataRefTypes(XPLMDataRef ref) {
		return XPLMDataTypeID.byValues((long) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_REF_TYPES, ref.getRawID()));
	}
	
	public static int getDataI(XPLMDataRef ref) {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_I, ref.getRawID());
	}
	
	public static void setDataI(XPLMDataRef ref, int value) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_I, ref.getRawID(), value);
	}
	
	public static float getDataF(XPLMDataRef ref) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_F, ref.getRawID());
	}
	
	public static void setDataF(XPLMDataRef ref, float value) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_F, ref.getRawID(), value);
	}
	
	public static double getDataD(XPLMDataRef ref) {
		return (double) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_D, ref.getRawID());
	}
	
	public static void setDataD(XPLMDataRef ref, double value) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_D, ref.getRawID(), value);
	}
	
	public static int[] getDataVI(XPLMDataRef ref, int offset, int max) {
		return (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_VI, ref.getRawID(), offset, max);
	}
	
	public static void setDataVI(XPLMDataRef ref, int[] values, int offset, int max) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_SET_DATA_VI, ref.getRawID(), values, offset, max);
	}
	
	public static float[] getDataVF(XPLMDataRef ref, int offset, int max) {
		return (float[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_VF, ref.getRawID(), offset, max);
	}
	
	public static void setDataVF(XPLMDataRef ref, float[] values, int offset, int max) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_SET_DATA_VF, ref.getRawID(), values, offset, max);
	}
	
	public static byte[] getDataB(XPLMDataRef ref, int offset, int max) {
		return (byte[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_GET_DATA_B, ref.getRawID(), offset, max);
	}
	
	public static void setDataB(XPLMDataRef ref, byte[] values, int offset, int max) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_SET_DATA_B, ref.getRawID(), values, offset, max);
	}
	
	public static XPLMDataRef registerDataAccessor(String name, EnumFlagCompound<XPLMDataTypeID> types, boolean isWritable, XPLMDataAccessor accessor) {
		XPLMDataRef dataRef = J4XP.getDataRefs().getOrCreate(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_REGISTER_DATA_ACCESSOR, name, types.getCompound(), isWritable));
		dataRef.setDataAccessor(accessor);
		return dataRef;
	}
	
	public static void unregisterDataAccessor(XPLMDataRef dataRef) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_UNREGISTER_DATA_ACCESSOR, dataRef.getRawID());
	}
	
	public static XPLMSharedData shareData(String dataName, EnumFlagCompound<XPLMDataTypeID> dataType, XPLMDataChanged onChanged, Object refcon) { // TODO: Callback working?
		XPLMSharedData dt = J4XP.getSharedDatas().create(id -> new XPLMSharedData(J4XPUtils.getMethodCaller(), id, dataName, dataType, onChanged, refcon));
		boolean success = (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_SHARE_DATA, dataName, dataType.getCompound(), dt.getRawID());
		if(!success) {
			J4XP.getSharedDatas().remove(dt.getRawID());
			return null;
		}
		return dt;
	}
	
	public static boolean unshareData(XPLMSharedData data) {
		return unshareData(data.getDataName(), data.getDataType(), data.getRawID());
	}
	
	public static boolean unshareData(String dataName, EnumFlagCompound<XPLMDataTypeID> dataType, long dataID) {
		J4XP.getSharedDatas().remove(dataID);
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMDATAACCESS_UNSHARE_DATA, dataName, dataType.getCompound(), dataID);
	}
	
}
