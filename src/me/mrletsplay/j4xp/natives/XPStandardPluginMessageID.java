package me.mrletsplay.j4xp.natives;

public enum XPStandardPluginMessageID implements XPPluginMessageID {
	
	PLANE_CRASHED(101),
	PLANE_LOADED(102),
	AIRPORT_LOADED(103),
	SCENERY_LOADED(104),
	AIRPLANE_COUNT_CHANGED(105),
	PLANE_UNLOADED(106),
	WILL_WRITE_PREFS(107),
	LIVERY_LOADED(108),
	ENTERED_VR(109),
	EXITING_VR(110),
	;
	
	private int messageID;
	
	private XPStandardPluginMessageID(int messageID) {
		this.messageID = messageID;
	}

	@Override
	public int getMessageID() {
		return messageID;
	}

}
