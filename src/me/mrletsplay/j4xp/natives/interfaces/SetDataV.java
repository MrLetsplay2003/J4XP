package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface SetDataV<T> {

	public void write(Object refcon, T value, int offset, int max);
	
}
