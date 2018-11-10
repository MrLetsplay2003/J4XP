package me.mrletsplay.j4xp.natives;

public class XPPluginMessage {

	private CPPPluginID fromPluginID;
	private XPPluginMessageID messageID;
	private Object param;
	
	public XPPluginMessage(CPPPluginID fromPluginID, XPPluginMessageID messageID, Object param) {
		this.fromPluginID = fromPluginID;
		this.messageID = messageID;
		this.param = param;
	}
	
	public CPPPluginID getFromPluginID() {
		return fromPluginID;
	}
	
	public XPPluginMessageID getMessageID() {
		return messageID;
	}
	
	public Object getParameter() {
		return param;
	}
	
}
