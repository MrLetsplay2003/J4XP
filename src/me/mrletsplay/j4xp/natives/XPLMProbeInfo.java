package me.mrletsplay.j4xp.natives;

public class XPLMProbeInfo {

	private float locationX;
	private float locationY;
	private float locationZ;
	private float normalX;
	private float normalY;
	private float normalZ;
	private float velocityX;
	private float velocityY;
	private float velocityZ;
	private boolean isWet;
	
	public XPLMProbeInfo(float locationX, float locationY, float locationZ, float normalX, float normalY, float normalZ, float velocityX, float velocityY, float velocityZ, boolean isWet) {
		this.locationX = locationX;
		this.locationY = locationY;
		this.locationZ = locationZ;
		this.normalX = normalX;
		this.normalY = normalY;
		this.normalZ = normalZ;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.velocityZ = velocityZ;
		this.isWet = isWet;
	}
	
	public float getLocationX() {
		return locationX;
	}
	
	public float getLocationY() {
		return locationY;
	}
	
	public float getLocationZ() {
		return locationZ;
	}
	
	public float getNormalX() {
		return normalX;
	}
	
	public float getNormalY() {
		return normalY;
	}
	
	public float getNormalZ() {
		return normalZ;
	}
	
	public float getVelocityX() {
		return velocityX;
	}
	
	public float getVelocityY() {
		return velocityY;
	}
	
	public float getVelocityZ() {
		return velocityZ;
	}
	
	public boolean isWet() {
		return isWet;
	}

}