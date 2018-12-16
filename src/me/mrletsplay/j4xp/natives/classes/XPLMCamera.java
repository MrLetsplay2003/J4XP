package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.CameraControl;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPLMCameraControlDuration;
import me.mrletsplay.j4xp.natives.XPLMCameraPosition;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

// TODO: Control camera
public class XPLMCamera {
	
	public static void controlCamera(XPLMCameraControlDuration duration, CameraControl control, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_CONTROL_CAMERA, duration.getRawValue(), control, refcon);
	}
	
	public static void dontControlCamera() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_DONT_CONTROL_CAMERA);
	}
	
	public static XPLMCameraControlDuration isCameraBeingControlled() {
		return XPLMCameraControlDuration.byValue((int) XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_IS_CAMERA_BEING_CONTROLLED));
	}
	
	public static XPLMCameraPosition readCameraPosition() {
		float[] vs = (float[]) XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_READ_CAMERA_POSITION);
		return new XPLMCameraPosition(vs[0], vs[1], vs[2], vs[3], vs[4], vs[5], vs[6]);
	}
	
}