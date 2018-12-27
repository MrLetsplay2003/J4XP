package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.classes.XPLMCreateFlightLoop;
import me.mrletsplay.j4xp.natives.classes.XPLMFlightLoopID;
import me.mrletsplay.j4xp.natives.classes.XPNativeInterface;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.interfaces.XPLMFlightLoop;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMProcessing {
	
	public static float getElapsedTime() {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_GET_ELAPSED_TIME);
	}
	
	public static int getCycleNumber() {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_GET_CYCLE_NUMBER);
	}
	
	public static void registerFlightLoopCallback(XPLMFlightLoop flightLoop, float interval, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_REGISTER_FLIGHT_LOOP_CALLBACK, flightLoop, interval, refcon);
	}
	
	public static void unregisterFlightLoopCallback(XPLMFlightLoop flightLoop, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_UNREGISTER_FLIGHT_LOOP_CALLBACK, flightLoop, refcon);
	}
	
	public static void setFlightLoopCallbackInterval(XPLMFlightLoop flightLoop, float interval, boolean relativeToNow, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_SET_FLIGHT_LOOP_CALLBACK_INTERVAL, flightLoop, interval, relativeToNow, refcon);
	}
	
	public static XPLMFlightLoopID createFlightLoop(XPLMCreateFlightLoop params) {
		return J4XP.getFlightLoopIDs().create(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_CREATE_FLIGHT_LOOP, params.getPhase().getRawValue()));
	}
	
	public static void destroyFlightLoop(XPLMFlightLoopID flightLoopID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_DESTROY_FLIGHT_LOOP, flightLoopID.getRawID());
	}
	
	public static void scheduleFlightLoop(XPLMFlightLoopID flightLoopID, float interval, boolean relativeToNow) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPROCESSING_SCHEDULE_FLIGHT_LOOP, flightLoopID.getRawID(), interval, relativeToNow);
	}
	
}