package me.mrletsplay.j4xp.natives.interfaces;

public interface XPLMFlightLoop {
	
	public float onFlightLoop(float elapsedSinceLastCall, float elapsedTimeSinceLastFlightLoop, int counter, Object refcon);

}
