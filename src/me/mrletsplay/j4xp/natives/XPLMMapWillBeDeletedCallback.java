package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMMapWillBeDeletedCallback {
	
	public void onMapWillBeDeletedCallback(XPLMMapLayerID layer, Object refcon);

}
