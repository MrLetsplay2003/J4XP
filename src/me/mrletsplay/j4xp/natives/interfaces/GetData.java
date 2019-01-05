package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface GetData<T> {

	public T read(Object refcon);
	
}
