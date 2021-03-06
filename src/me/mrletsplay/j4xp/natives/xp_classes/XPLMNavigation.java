package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMFMSEntryInfo;
import me.mrletsplay.j4xp.natives.classes.XPLMNavAidInfo;
import me.mrletsplay.j4xp.natives.classes.XPLMNavRef;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMNavType;

public class XPLMNavigation {
	
	public static XPLMNavRef getFirstNavAid() {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_FIRST_NAV_AID));
	}
	
	public static XPLMNavRef getNextNavAid(XPLMNavRef navAidRef) {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_NEXT_NAV_AID, navAidRef.getRawID()));
	}
	
	public static XPLMNavRef findFirstNavAidOfType(XPLMNavType type) {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_FIND_FIRST_NAV_AID_OF_TYPE, type.getRawValue()));
	}
	
	public static XPLMNavRef findLastNavAidOfType(XPLMNavType type) {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_FIND_LAST_NAV_AID_OF_TYPE, type.getRawValue()));
	}
	
	public static XPLMNavRef findNavAid(String nameFragment, String idFragment, float lat, float lon, int frequency, XPLMNavType type) {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_FIND_NAV_AID, nameFragment, idFragment, lat, lon, frequency, type.getRawValue()));
	}
	
	public static XPLMNavAidInfo getNavAidInfo(XPLMNavRef navRef) {
		Object[] p = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_NAV_AID_INFO, navRef.getRawID());
		return new XPLMNavAidInfo(navRef, XPLMNavType.byValue((int) p[0]), (float) p[1], (float) p[2], (float) p[3], (int) p[4], (float) p[5], (String) p[6], (String) p[7], (boolean) p[8]);
	}
	
	public static int countFMSEntries() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_COUNT_FMS_ENTRIES);
	}
	
	public static int getDisplayedFMSEntry() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_DISPLAYED_FMS_ENTRY);
	}
	
	public static int getDestinationFMSEntry() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_DESTINATION_FMS_ENTRY);
	}
	
	public static void setDisplayedFMSEntry(int index) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_SET_DISPLAYED_FMS_ENTRY, index);
	}
	
	public static void setDestinationFMSEntry(int index) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_SET_DESTINATION_FMS_ENTRY, index);
	}
	
	public static XPLMFMSEntryInfo getFMSEntryInfo(int index) {
		Object[] p = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_FMS_ENTRY_INFO);
		return new XPLMFMSEntryInfo(index, XPLMNavType.byValue((int) p[0]), (char) p[1], new XPLMNavRef((int) p[2]), (int) p[3], (float) p[4], (float) p[5]);
	}
	
	public static void setFMSEntryInfo(int index, XPLMNavRef ref, int altitude) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_SET_FMS_ENTRY_INFO, index, ref.getRawID(), altitude);
	}
	
	public static void setFMSEntryLatLon(int index, float lat, float lon, int altitude) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_SET_FMS_ENTRY_LAT_LON, index, lat, lon, altitude);
	}
	
	public static void clearFMSEntry(int index) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_CLEAR_FMS_ENTRY, index);
	}
	
	public static XPLMNavType getGPSDestinationType() {
		return XPLMNavType.byValue((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_GPS_DESTINATION_TYPE));
	}
	
	public static XPLMNavRef getGPSDestination() {
		return new XPLMNavRef((int) XPNativeInterface.executeFunction(NativeFunction.XPLMNAVIGATION_GET_GPS_DESTINATION));
	}
	
}