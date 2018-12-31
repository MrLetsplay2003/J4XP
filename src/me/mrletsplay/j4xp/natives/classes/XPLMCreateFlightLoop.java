package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMFlightLoopPhaseType;
import me.mrletsplay.j4xp.natives.interfaces.FlightLoop;

public class XPLMCreateFlightLoop {
	
    private XPLMFlightLoopPhaseType phase;
    private FlightLoop callbackFunc;
    private Object refcon;
    
    public XPLMCreateFlightLoop(XPLMFlightLoopPhaseType phase, FlightLoop callbackFunc, Object refcon) {
		this.phase = phase;
		this.callbackFunc = callbackFunc;
		this.refcon = refcon;
	}
    
    public XPLMFlightLoopPhaseType getPhase() {
		return phase;
	}
    
    public FlightLoop getCallbackFunc() {
		return callbackFunc;
	}
    
    public Object getRefcon() {
		return refcon;
	}
    
}