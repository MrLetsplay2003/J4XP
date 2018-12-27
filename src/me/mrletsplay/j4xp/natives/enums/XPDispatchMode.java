package me.mrletsplay.j4xp.natives.enums;

public enum XPDispatchMode {

	DIRECT(0),
	UP_CHAIN(1),
	RECURSIVE(2),
	DIRECT_ALL_CALLBACKS(3),
	ONCE(4);
	
	private int id;
	
	private XPDispatchMode(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
}
