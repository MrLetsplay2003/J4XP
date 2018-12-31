package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMDrawInfo;
import me.mrletsplay.j4xp.natives.classes.XPLMInstanceRef;
import me.mrletsplay.j4xp.natives.classes.XPLMObjectRef;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMInstance {
	
	public static XPLMInstanceRef createInstance(XPLMObjectRef obj, String[] datarefs) {
		return J4XP.getInstanceRefs().create(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_CREATE_INSTANCE, obj.getRawID(), datarefs));
	}
	
	public static void destroyInstance(XPLMInstanceRef instance) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_DESTROY_INSTANCE, instance.getRawID());
	}
	
	public static void instanceSetPosition(XPLMInstanceRef instance, XPLMDrawInfo newPosition, float data) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMINSTANCE_INSTANCE_SET_POSITION, instance.getRawID(), newPosition.getX(), newPosition.getY(), newPosition.getZ(), newPosition.getPitch(), newPosition.getHeading(), newPosition.getRoll(), data);
	}
	
}
