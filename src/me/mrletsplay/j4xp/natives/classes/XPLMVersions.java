package me.mrletsplay.j4xp.natives.classes;

public class XPLMVersions {
	private int XPlaneVersion;    
    private int XPLMVersion;
//	private XPLMHostApplicationID hostID;
    
    public XPLMVersions(int XPlaneVersion, int XPLMVersion/*, XPLMHostApplicationID hostID*/) {
		this.XPlaneVersion = XPlaneVersion;
		this.XPLMVersion = XPLMVersion;
//		this.hostID = hostID;
	}
    
    public int getXPlaneVersion() {
		return XPlaneVersion;
	}
    
    public int getXPLMVersion() {
		return XPLMVersion;
	}
    
//    public XPLMHostApplicationID getHostID() {
//		return hostID;
//	}
}
