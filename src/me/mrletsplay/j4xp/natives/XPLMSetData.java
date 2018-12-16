package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMSetData<T> {

	public void write(Object refcon, T value);
	
}
