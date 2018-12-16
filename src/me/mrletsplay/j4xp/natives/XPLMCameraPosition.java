package me.mrletsplay.j4xp.natives;

public class XPLMCameraPosition {

	private float x, y, z, pitch, heading, roll, zoom;
	
	public XPLMCameraPosition(float x, float y, float z, float pitch, float heading, float roll, float zoom) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.heading = heading;
		this.roll = roll;
		this.zoom = zoom;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	public float getPitch() {
		return pitch;
	}
	
	public float getHeading() {
		return heading;
	}
	
	public float getRoll() {
		return roll;
	}
	
	public float getZoom() {
		return zoom;
	}
	
}
