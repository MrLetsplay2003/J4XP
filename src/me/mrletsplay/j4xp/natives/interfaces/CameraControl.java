package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMCameraPosition;

@FunctionalInterface
public interface CameraControl {

	public XPLMCameraPosition onCameraControl(boolean isLosingControl, Object refcon);
	
}
