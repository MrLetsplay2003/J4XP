package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMMapLabelDrawingCallback {
	
	public void onMapLabelDrawingCallback(XPLMMapLayerID layer, float mapBoundsLeftTopRightBottom, float zoomRatio, float mapUnitsPerUserInterfaceUnit, XPLMMapStyle mapStyle, XPLMMapProjectionID projection, Object refcon);

}
