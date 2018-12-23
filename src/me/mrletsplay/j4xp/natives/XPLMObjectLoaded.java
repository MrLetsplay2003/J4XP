package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMObjectLoaded {

	public void onObjectLoaded(XPLMObjectRef object, Object refcon);

}
