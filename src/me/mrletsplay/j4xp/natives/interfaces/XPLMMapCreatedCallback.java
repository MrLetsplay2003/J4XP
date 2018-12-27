package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface XPLMMapCreatedCallback {
	
	public void onMapCreatedCallback(String mapIdentifier, Object refcon);

}
