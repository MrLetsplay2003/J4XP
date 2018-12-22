package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMMapDrawingCallback {
	
	public void onMapDrawingCallback(XPLMMapLayerID inLayer, float mapBoundsLeftTopRightBottom, float zoomRatio, float mapUnitsPerUserInterfaceUnit, XPLMMapStyle mapStyle, XPLMMapProjectionID projection, Object refcon);
	
}
