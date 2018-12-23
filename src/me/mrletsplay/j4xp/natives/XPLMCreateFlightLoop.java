package me.mrletsplay.j4xp.natives;

public class XPLMCreateFlightLoop {
	
	private int structSize;
    private XPLMFlightLoopPhaseType phase;
    private XPLMFlightLoop callbackFunc;
    private Object refcon;
    
    public XPLMCreateFlightLoop(int structSize, XPLMFlightLoopPhaseType phase, XPLMFlightLoop callbackFunc, Object refcon) {
		this.structSize = structSize;
		this.phase = phase;
		this.callbackFunc = callbackFunc;
		this.refcon = refcon;
	}
    
    public int getStructSize() {
		return structSize;
	}
    
    public XPLMFlightLoopPhaseType getPhase() {
		return phase;
	}
    
    public XPLMFlightLoop getCallbackFunc() {
		return callbackFunc;
	}
    
    public Object getRefcon() {
		return refcon;
	}
    
}