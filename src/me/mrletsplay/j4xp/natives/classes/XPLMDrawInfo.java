package me.mrletsplay.j4xp.natives.classes;

public class XPLMDrawInfo {

	private float x;
	private float y;
	private float z;
	private float pitch;
	private float heading;
	private float roll;

	public XPLMDrawInfo(float x, float y, float z, float pitch, float heading, float roll) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.heading = heading;
		this.roll = roll;
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

}