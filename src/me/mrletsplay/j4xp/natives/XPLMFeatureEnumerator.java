package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMFeatureEnumerator {
	
	public void onFeatureEnumerator(String feature, Object refcon);
}
