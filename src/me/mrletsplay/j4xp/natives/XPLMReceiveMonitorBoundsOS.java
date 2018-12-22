package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface XPLMReceiveMonitorBoundsOS {
	
	public void onReceiveMonitorBoundsOS(int monitorIndex, int leftPx, int topPx, int rightPx, int bottomPx, Object refcon);

}
