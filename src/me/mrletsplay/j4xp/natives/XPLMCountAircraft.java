package me.mrletsplay.j4xp.natives;

public class XPLMCountAircraft {
	
	private int totalAircraft;   
    private int activeAircraft;
    private XPLMPluginID controller;
    
    public XPLMCountAircraft(int totalAircraft, int activeAircraft, XPLMPluginID controller) {
		this.totalAircraft = totalAircraft;
		this.activeAircraft = activeAircraft;
		this.controller = controller;
	}
    
    public int getTotalAircraft() {
		return totalAircraft;
	}
    
    public int getActiveAircraft() {
		return activeAircraft;
	}
    
    public XPLMPluginID getController() {
		return controller;
	}

}
