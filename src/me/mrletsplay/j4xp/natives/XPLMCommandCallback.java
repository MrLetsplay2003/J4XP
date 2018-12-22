package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMCommandCallback {
	
	public boolean onCommandCallback(XPLMCommandRef command, XPLMCommandPhase phase, Object refcon);

}
