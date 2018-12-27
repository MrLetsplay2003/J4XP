package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.interfaces.XPPluginMessageID;

public class XPPluginMessage {

	private XPLMPluginID fromPluginID;
	private XPPluginMessageID messageID;
	private Object param;
	
	public XPPluginMessage(XPLMPluginID fromPluginID, XPPluginMessageID messageID, Object param) {
		this.fromPluginID = fromPluginID;
		this.messageID = messageID;
		this.param = param;
	}
	
	public XPLMPluginID getFromPluginID() {
		return fromPluginID;
	}
	
	public XPPluginMessageID getMessageID() {
		return messageID;
	}
	
	public Object getParameter() {
		return param;
	}
	
}
