package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.interfaces.XPWidgetMessageID;

public class XPWidgetMessageIDImpl implements XPWidgetMessageID {

	private int messageID;
	
	public XPWidgetMessageIDImpl(int messageID) {
		this.messageID = messageID;
	}
	
	@Override
	public int getMessageID() {
		return messageID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof XPWidgetMessageID)) return false;
		XPWidgetMessageID o = (XPWidgetMessageID) obj;
		return messageID == o.getMessageID();
	}

}
