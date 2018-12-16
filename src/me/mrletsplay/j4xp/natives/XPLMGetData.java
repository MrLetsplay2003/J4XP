package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMGetData<T> {

	public T read(Object refcon);
	
}
