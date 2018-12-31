package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMCountAircraft;
import me.mrletsplay.j4xp.natives.classes.XPLMGetNthAircraftModel;
import me.mrletsplay.j4xp.natives.classes.XPLMPlaneDrawState;
import me.mrletsplay.j4xp.natives.classes.XPLMPluginID;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.interfaces.XPLMPlanesAvailable;

public class XPLMPlanes {
	
	public static void setUsersAircraft(String aircraftPath) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_SET_USERS_AIRCRAFT, aircraftPath);
	}
	
	public static void placeUserAtAirport(String airportCode) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_PLACE_USER_AT_AIRPORT, airportCode);
	}
	
	public static void placeUserAtLocation(double latitudeDegrees,  double longitudeDegrees,  float elevationMetersMSL,  float headingDegreesTrue, float speedMetersPerSecond) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_PLACE_USER_AT_LOCATION, latitudeDegrees, longitudeDegrees, elevationMetersMSL, headingDegreesTrue, speedMetersPerSecond);
	}
	
	public static XPLMCountAircraft countAircraft() {
		Object[] p = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_COUNT_AIRCRAFT);
		return new XPLMCountAircraft((int) p[0], (int) p[1], (XPLMPluginID) p[2]);
	}
	
	public static XPLMGetNthAircraftModel getNthAircraftModel(int index) {
		Object[] p = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_GET_NTH_AIRCRAFT_MODEL, index);
		return new XPLMGetNthAircraftModel((String)p[0], (String)p[1]);
	}
	
	public static void acquirePlanes(String[] aircraft, XPLMPlanesAvailable callback, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_ACQUIRE_PLANES, aircraft, callback, refcon);
	}
	
	public static void releasePlanes() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_RELEASE_PLANES);
	}
	
	public static void setActiveAircraftCount(int count) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_SET_ACTIVE_AIRCRAFT_COUNT, count);
	}
	
	public static void setAircraftModel(int index, String aircraftPath) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_SET_AIRCRAFT_MODEL, index, aircraftPath);
	}
	
	public static void disableAIForPlane(int planeIndex) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_DISABLE_AI_FOR_PLANE, planeIndex);
	}
	
	public static void drawAircraft(int planeIndex, float x, float y, float z, float pitch, float roll, float yaw, int fullDraw, XPLMPlaneDrawState drawStateInfo) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_DRAW_AIRCRAFT, planeIndex, x, y, z, pitch, roll, yaw, fullDraw, drawStateInfo);
	}
	
	public static void reinitUsersPlane(){
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLANES_REINIT_USERS_PLANE);
	}

}
