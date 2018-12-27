package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMCameraControlDuration;
import me.mrletsplay.j4xp.natives.interfaces.CameraControl;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPLMCameraControl implements J4XPPluginOwnable {

	private XPPlugin owner;
	private XPLMCameraControlDuration howLong;
	private CameraControl controlFunction;
	private Object refcon;
	
	public XPLMCameraControl(XPPlugin owner, XPLMCameraControlDuration howLong, CameraControl controlFunction, Object refcon) {
		this.howLong = howLong;
		this.controlFunction = controlFunction;
		this.refcon = refcon;
	}
	
	public XPLMCameraControlDuration getHowLong() {
		return howLong;
	}
	
	public CameraControl getControlFunction() {
		return controlFunction;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
	@Override
	public XPPlugin getOwner() {
		return owner;
	}

	@Override
	public void destroy() {
		// Destruction handled by J4XP#stop()
	}
	
}
