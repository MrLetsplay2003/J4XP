package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMSetDataV<T> {

	public void write(Object refcon, T value, int offset, int max);
	
}
