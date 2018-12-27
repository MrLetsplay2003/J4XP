package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;
import me.mrletsplay.j4xp.natives.classes.XPLMMapProjectionID;
import me.mrletsplay.j4xp.natives.enums.XPLMMapStyle;

@FunctionalInterface
public interface XPLMMapDrawingCallback {
	
	public void onMapDrawingCallback(XPLMMapLayerID inLayer, float mapBoundsLeftTopRightBottom, float zoomRatio, float mapUnitsPerUserInterfaceUnit, XPLMMapStyle mapStyle, XPLMMapProjectionID projection, Object refcon);
	
}
