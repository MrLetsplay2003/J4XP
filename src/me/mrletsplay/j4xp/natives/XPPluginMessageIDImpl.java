package me.mrletsplay.j4xp.natives;

public class XPPluginMessageIDImpl implements XPPluginMessageID {

	private int messageID;
	
	public XPPluginMessageIDImpl(int messageID) {
		this.messageID = messageID;
	}
	
	@Override
	public int getMessageID() {
		return messageID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof XPPluginMessageID)) return false;
		XPPluginMessageID o = (XPPluginMessageID) obj;
		return messageID == o.getMessageID();
	}

}
