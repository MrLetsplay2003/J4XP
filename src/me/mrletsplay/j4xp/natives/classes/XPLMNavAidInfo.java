package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMNavType;

public class XPLMNavAidInfo {
	
	private XPLMNavRef ref;
    private XPLMNavType type;
    private float latitude;
    private float longitude;
    private float height;
    private int frequency;
    private float heading;
    private String id;
    private String name;
    private String reg;
    
    public XPLMNavAidInfo(XPLMNavRef ref, XPLMNavType type, float latitude, float longitude, float height, int frequency, float heading, String id, String name, String reg){
    	this.ref = ref;
    	this.type = type;
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.height = height;
    	this.frequency = frequency;
    	this.heading = heading;
    	this.id = id;
    	this.name = name;
    	this.reg = reg;
    }
    
    public XPLMNavRef getRef() {
		return ref;
	}
    
    public XPLMNavType getType() {
		return type;
	}
    
    public float getLatitude() {
		return latitude;
	}
    
    public float getLongitude() {
		return longitude;
	}
    
    public float getHeight() {
		return height;
	}
    
    public int getFrequency() {
		return frequency;
	}
    
    public float getHeading() {
		return heading;
	}
    
    public String getId() {
		return id;
	}
    
    public String getName() {
		return name;
	}
    
    public String getReg() {
		return reg;
	}

}
