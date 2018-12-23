package me.mrletsplay.j4xp.natives;

public class XPLMPlaneDrawState {
	
    int structSize;
    float gearPosition;
    float flapRatio;
    float spoilerRatio;
    float speedBrakeRatio;
    float slatRatio;
    float wingSweep;
    float thrust;
    float yokePitch;
    float yokeHeading;
    float yokeRoll;
    
    public XPLMPlaneDrawState(int structSize, float gearPosition, float flapRatio, float spoilerRatio, float speedBrakeRatio, float slatRatio, float wingSweep, float thrust, float yokePitch, float yokeHeading, float yokeRoll) {
		this.structSize = structSize;
		this.gearPosition = gearPosition;
		this.flapRatio = flapRatio;
		this.spoilerRatio = spoilerRatio;
		this.speedBrakeRatio = speedBrakeRatio;
		this.slatRatio = slatRatio;
		this.wingSweep = wingSweep;
		this.thrust = thrust;
		this.yokePitch = yokePitch;
		this.yokeHeading = yokeHeading;
		this.yokeRoll = yokeRoll;
	}
    
    public int getStructSize() {
		return structSize;
	}
    
    public float getGearPosition() {
		return gearPosition;
	}
    
    public float getFlapRatio() {
		return flapRatio;
	}
    
    public float getSpeedBrakeRatio() {
		return speedBrakeRatio;
	}
    
    public float getSlatRatio() {
		return slatRatio;
	}
    
    public float getWingSweep() {
		return wingSweep;
	}
    
    public float getThrust() {
		return thrust;
	}
    
    public float getYokePitch() {
		return yokePitch;
	}
    
    public float getYokeHeading() {
		return yokeHeading;
	}
    
    public float getYokeRoll() {
		return yokeRoll;
	}
    
}
