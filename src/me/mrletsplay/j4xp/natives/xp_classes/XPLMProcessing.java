package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMCreateFlightLoop;
import me.mrletsplay.j4xp.natives.classes.XPLMFlightLoopCallback;
import me.mrletsplay.j4xp.natives.classes.XPLMFlightLoopID;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.interfaces.FlightLoop;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMProcessing {
	
	public static float getElapsedTime() {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_GET_ELAPSED_TIME);
	}
	
	public static int getCycleNumber() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_GET_CYCLE_NUMBER);
	}
	
	public static XPLMFlightLoopCallback registerFlightLoopCallback(FlightLoop flightLoop, float interval, Object refcon) {
		XPLMFlightLoopCallback cb = J4XP.getFlightLoopCallbacks().create(
				id -> new XPLMFlightLoopCallback(J4XPUtils.getMethodCaller(), id, flightLoop, refcon));
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_REGISTER_FLIGHT_LOOP_CALLBACK, cb.getRawID(), interval);
		return cb;
		
	}
	
	public static void unregisterFlightLoopCallback(XPLMFlightLoopCallback callback) {
		unregisterFlightLoopCallback(callback.getRawID());
	}
	
	public static void unregisterFlightLoopCallback(long rawID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_UNREGISTER_FLIGHT_LOOP_CALLBACK, rawID);
		J4XP.getFlightLoopCallbacks().remove(rawID);
	}
	
	public static void setFlightLoopCallbackInterval(XPLMFlightLoopCallback callback, float interval, boolean relativeToNow) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_SET_FLIGHT_LOOP_CALLBACK_INTERVAL, callback.getRawID(), interval, relativeToNow);
	}
	
	public static XPLMFlightLoopID createFlightLoop(XPLMCreateFlightLoop params) {
		return J4XP.getFlightLoopIDs().create(
				(long) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_CREATE_FLIGHT_LOOP, params.getPhase().getRawValue()),
				id -> new XPLMFlightLoopID(J4XPUtils.getMethodCaller(), id, params));
	}
	
	public static void destroyFlightLoop(XPLMFlightLoopID flightLoopID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_DESTROY_FLIGHT_LOOP, flightLoopID.getRawID());
	}
	
	public static void scheduleFlightLoop(XPLMFlightLoopID flightLoopID, float interval, boolean relativeToNow) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_SCHEDULE_FLIGHT_LOOP, flightLoopID.getRawID(), interval, relativeToNow);
	}
	
}