package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface ReceiveMonitorBoundsOS {
	
	public void onReceiveMonitorBoundsOS(int monitorIndex, int leftPx, int topPx, int rightPx, int bottomPx, Object refcon);

}
