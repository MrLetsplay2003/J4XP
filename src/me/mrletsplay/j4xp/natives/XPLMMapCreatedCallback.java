package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMMapCreatedCallback {
	
	public void onMapCreatedCallback(String mapIdentifier, Object refcon);

}
