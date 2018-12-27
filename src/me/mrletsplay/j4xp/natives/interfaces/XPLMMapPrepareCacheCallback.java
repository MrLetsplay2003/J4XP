package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;
import me.mrletsplay.j4xp.natives.classes.XPLMMapProjectionID;

@FunctionalInterface
public interface XPLMMapPrepareCacheCallback {
	
	public void onMapPrepareCacheCallback(XPLMMapLayerID layer, float totalMapBoundsLeftTopRightBottom, XPLMMapProjectionID projection, Object refcon);

}
