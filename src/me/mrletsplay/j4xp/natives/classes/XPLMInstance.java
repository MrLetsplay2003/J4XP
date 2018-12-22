package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPLMDrawInfo;
import me.mrletsplay.j4xp.natives.XPLMInstanceRef;
import me.mrletsplay.j4xp.natives.XPLMObjectRef;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMInstance {
	
	public static XPLMInstanceRef createInstance(XPLMObjectRef obj, String[] datarefs) {
		return J4XP.getOrCreateInstanceRef(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_CREATE_INSTANCE, obj.getRawID(), datarefs));
	}
	
	public static void destroyInstance(XPLMInstanceRef instance) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_DESTROY_INSTANCE, instance);
	}
	
	public static void instanceSetPosition(XPLMInstanceRef instance, XPLMDrawInfo newPosition, float data) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_INSTANCE_SET_POSITION, instance.getRawID(), newPosition, data);
	}
	
}
