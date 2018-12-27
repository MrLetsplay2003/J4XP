package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface XPLMGetData<T> {

	public T read(Object refcon);
	
}
