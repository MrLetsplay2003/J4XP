package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMMapLayerID;

@FunctionalInterface
public interface XPLMMapWillBeDeletedCallback {
	
	public void onMapWillBeDeletedCallback(XPLMMapLayerID layer, Object refcon);

}
