package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.interfaces.XPWidgetMessageID;

public class XPWidgetMessage {
	
	private XPWidgetMessageID messageID;
	private XPWidgetID widget;
	private long param1, param2;
	
	public XPWidgetMessage(XPWidgetMessageID messageID, XPWidgetID widget, long param1, long param2) {
		this.messageID = messageID;
		this.widget = widget;
		this.param1 = param1;
		this.param2 = param2;
	}
	
	public XPWidgetMessageID getMessageID() {
		return messageID;
	}
	
	public XPWidgetID getWidget() {
		return widget;
	}
	
	public long getParameter1() {
		return param1;
	}
	
	public long getParameter2() {
		return param2;
	}

}
