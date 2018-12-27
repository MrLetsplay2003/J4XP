package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.classes.ProbeResult;
import me.mrletsplay.j4xp.natives.classes.XPLMObjectRef;
import me.mrletsplay.j4xp.natives.classes.XPLMProbeInfo;
import me.mrletsplay.j4xp.natives.classes.XPLMProbeRef;
import me.mrletsplay.j4xp.natives.classes.XPNativeInterface;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMProbeResult;
import me.mrletsplay.j4xp.natives.enums.XPLMProbeType;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMScenery {
	
	public static XPLMProbeRef createProbe(XPLMProbeType probeType){
		return J4XP.getProbeRefs().create(J4XPUtils.getMethodCaller(), (long) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_CREATE_PROBE, probeType.getRawValue()));
	}
	
	public static void destroyProbe(XPLMProbeRef probe) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_DESTROY_PROBE, probe.getRawID());
	}
	
	public static ProbeResult probeTerrainXYZ(XPLMProbeRef probe, float x, float y, float z) {
		Object[] a = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_PROBE_TERRAIN_XYZ, probe.getRawID(), x, y, z);
		XPLMProbeResult r = XPLMProbeResult.byValue((int) a[0]);
		XPLMProbeInfo i = new XPLMProbeInfo((float) a[1], (float) a[2], (float) a[3], (float) a[4], (float) a[5], (float) a[6], (float) a[7], (float) a[8], (float) a[9], (boolean) a[10]);
		return new ProbeResult(r, i);
	}
	
	public static float getMagneticVariation(double latitude, double longitude) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_GET_MAGNETIC_VARIATION, latitude, longitude);
	}
	
	public static float degTrueToDegMagnetic(float headingDegreesTrue) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_DEG_TRUE_TO_DEG_MAGNETIC, headingDegreesTrue);
	}
	
	public static float degMagneticToDegTrue(float headingDegreesMagnetic) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_DEG_MAGNETIC_TO_DEG_TRUE, headingDegreesMagnetic);
	}
	
	public static XPLMObjectRef loadObject(String path) {
		return J4XP.getObjectRefs().getOrCreate(null, (long) XPNativeInterface.executeFunction(NativeFunction.XPLMSCENERY_LOAD_OBJECT, path)); // Lookup by path
	}

}