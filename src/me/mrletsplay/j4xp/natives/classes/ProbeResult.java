package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMProbeResult;

public class ProbeResult {
	
	private XPLMProbeResult result;
	private XPLMProbeInfo info;
	
	public ProbeResult(XPLMProbeResult result, XPLMProbeInfo info) {
		this.result = result;
		this.info = info;
	}
	
	public XPLMProbeResult getResult() {
		return result;
	}
	
	public XPLMProbeInfo getInfo() {
		return info;
	}

}