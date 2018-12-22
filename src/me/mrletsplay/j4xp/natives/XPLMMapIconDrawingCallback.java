package me.mrletsplay.j4xp.natives;

public interface XPLMMapIconDrawingCallback {
	
	public void onMapIconDrawingCallback(XPLMMapLayerID layer, float mapBoundsLeftTopRightBottom,  float zoomRatio, float mapUnitsPerUserInterfaceUnit, XPLMMapStyle mapStyle, XPLMMapProjectionID projection, Object refcon);

}
