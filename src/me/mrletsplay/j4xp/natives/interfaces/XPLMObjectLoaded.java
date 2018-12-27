package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPLMObjectRef;

@FunctionalInterface
public interface XPLMObjectLoaded {

	public void onObjectLoaded(XPLMObjectRef object, Object refcon);

}
