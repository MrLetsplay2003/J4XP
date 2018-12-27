package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.J4XP;
import me.mrletsplay.j4xp.natives.classes.DoublePoint;
import me.mrletsplay.j4xp.natives.classes.FloatPoint;
import me.mrletsplay.j4xp.natives.classes.XPLMCreateMapLayer;
import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;
import me.mrletsplay.j4xp.natives.classes.XPLMMapProjectionID;
import me.mrletsplay.j4xp.natives.classes.XPNativeInterface;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMMapOrientation;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapCreatedCallback;
import me.mrletsplay.j4xp.plugin.J4XPUtils;

public class XPLMMap {
	
	public static XPLMMapLayerID createMapLayer(XPLMCreateMapLayer params) {
		return J4XP.getMapLayerIDs().getOrCreate(J4XPUtils.getMethodCaller(),
				(long) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_CREATE_MAP_LAYER, params.getMapToCreateLayerIn(), params.getLayerType().getRawValue(), params.getShowUiToggle(), params.getLayerName()));
	}
	
	public static boolean destroyMapLayer(XPLMMapLayerID layer) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_DESTROY_MAP_LAYER, layer.getRawID());
	}
	
	public static void registerMapCreationHook(XPLMMapCreatedCallback callback, Object refcon) { // TODO: Callback
		XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_REGISTER_MAP_CREATION_HOOK, callback, refcon);
	}
	
	public static boolean mapExists(String mapIdentifier) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_MAP_EXISTS, mapIdentifier);
	}
	
	public static void drawMapIconFromSheet(XPLMMapLayerID layer, char pngPath, int s, int t, int ds, int dt, float mapX, float mapY, XPLMMapOrientation orientation, float rotationDegrees, float mapWidth) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_DRAW_MAP_ICON_FROM_SHEET, layer.getRawID(), pngPath, s, t, ds, dt, mapX, mapY, orientation, rotationDegrees, mapWidth);
	}
	
	public static void drawMapLabel(XPLMMapLayerID layer, String text, float mapX, float mapY, XPLMMapOrientation orientation, float rotationDegrees) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_DRAW_MAP_LABEL, layer.getRawID(), text, mapX, mapY, orientation, rotationDegrees);
	}
	
	public static FloatPoint mapProject(XPLMMapProjectionID projection, double latitude, double longitude) {
		float[] p = (float[]) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_MAP_PROJECT, projection, latitude, longitude);
		return new FloatPoint(p[0], p[1]);
	}
	
	public static DoublePoint mapUnproject(XPLMMapProjectionID projection, float mapX, float mapY) {
		double[] p = (double[]) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_MAP_UNPROJECT, projection, mapX, mapY);
		return new DoublePoint(p[0], p[1]);
	}
	
	public static float mapScaleMeter(XPLMMapProjectionID projection, float mapX, float mapY) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_MAP_SCALE_METER, projection.getRawID(), mapX, mapY);
	}
	
	public float mapGetNorthHeading(XPLMMapProjectionID projection, float mapX, float mapY) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMMAP_MAP_GET_NORTH_HEADING, projection.getRawID(), mapX, mapY);
	}
	
}
