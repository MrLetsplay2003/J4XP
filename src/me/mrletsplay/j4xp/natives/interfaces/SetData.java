package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface SetData<T> {

	public void write(Object refcon, T value);
	
}
