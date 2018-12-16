package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface CameraControl {

	public XPLMCameraPosition onCameraControl(boolean isLosingControl, Object refcon);
	
}
