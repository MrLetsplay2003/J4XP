package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMGetDataV<T> {

	public int read(Object refcon, T out, int offset, int count);
	
}
