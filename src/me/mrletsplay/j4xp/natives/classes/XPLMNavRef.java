package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XPIdentifiable;

public class XPLMNavRef implements J4XPIdentifiable {
	
	private int rawID;
	
	public XPLMNavRef(int rawID) {
		this.rawID = rawID;
	}
	
	@Override
	public long getRawID() {
		return rawID;
	}

}
