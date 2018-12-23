package me.mrletsplay.j4xp.natives;

@FunctionalInterface
public interface ReceiveMonitorBoundsGlobal {
	
	public void onReceiveMonitorBoundsGloba(int monitorIndex, int leftBx, int topBx, int rightBx, int bottomBx, Object refcon);

}
