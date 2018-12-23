package me.mrletsplay.j4xp.natives;

public class XPLMFMSEntryInfo {
	
	private int index;    
    private XPLMNavType type;
    private char id;
    private XPLMNavRef ref;
    private int altitude;
    private float lat;
    private float lon;
    
    public XPLMFMSEntryInfo(int index, XPLMNavType type, char id, XPLMNavRef ref, int altitude, float lat, float lon) {
    	this.index = index;
    	this.type = type;
    	this.id = id;
    	this.ref = ref;
    	this.altitude = altitude;
    	this.lat = lat;
    	this.lon = lon;
    }
    
    public int getIndex() {
		return index;
	}
    
    public XPLMNavType getType() {
		return type;
	}
    
    public char getId() {
		return id;
	}
    
    public XPLMNavRef getRef() {
		return ref;
	}
    
    public int getAltitude() {
		return altitude;
	}
    
    public float getLat() {
		return lat;
	}
    
    public float getLon() {
		return lon;
	}

}
