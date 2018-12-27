package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;
import me.mrletsplay.j4xp.natives.classes.XPLMMapProjectionID;
import me.mrletsplay.j4xp.natives.enums.XPLMMapStyle;

public interface XPLMMapIconDrawingCallback {
	
	public void onMapIconDrawingCallback(XPLMMapLayerID layer, float mapBoundsLeftTopRightBottom,  float zoomRatio, float mapUnitsPerUserInterfaceUnit, XPLMMapStyle mapStyle, XPLMMapProjectionID projection, Object refcon);

}
