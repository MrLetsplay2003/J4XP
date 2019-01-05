package me.mrletsplay.j4xp.natives.interfaces;

@FunctionalInterface
public interface GetDataV<T> {

	public int read(Object refcon, T out, int offset, int count);
	
}
