package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMMapPrepareCacheCallback {
	
	public void onMapPrepareCacheCallback(XPLMMapLayerID layer, float totalMapBoundsLeftTopRightBottom, XPLMMapProjectionID projection, Object refcon);

}
