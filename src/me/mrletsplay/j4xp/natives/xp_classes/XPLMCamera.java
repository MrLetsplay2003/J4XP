package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.classes.XPLMCameraControl;
import me.mrletsplay.j4xp.natives.classes.XPLMCameraPosition;
import me.mrletsplay.j4xp.natives.classes.XPNativeInterface;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMCameraControlDuration;
import me.mrletsplay.j4xp.natives.interfaces.CameraControl;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMCamera {
	
	public static XPLMCameraControl controlCamera(XPLMCameraControlDuration duration, CameraControl control, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_CONTROL_CAMERA, duration.getRawValue(), refcon);
		XPLMCameraControl c = new XPLMCameraControl(J4XPUtils.getMethodCaller(), duration, control, refcon);
		J4XP.setCameraControl(c);
		return c;
	}
	
	public static void dontControlCamera() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_DONT_CONTROL_CAMERA);
		J4XP.setCameraControl(null);
	}
	
	public static XPLMCameraControlDuration isCameraBeingControlled() {
		return XPLMCameraControlDuration.byValue((int) XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_IS_CAMERA_BEING_CONTROLLED));
	}
	
	public static XPLMCameraPosition readCameraPosition() {
		float[] vs = (float[]) XPNativeInterface.executeFunction(NativeFunction.XPLMCAMERA_READ_CAMERA_POSITION);
		return new XPLMCameraPosition(vs[0], vs[1], vs[2], vs[3], vs[4], vs[5], vs[6]);
	}
	
}