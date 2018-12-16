package me.mrletsplay.j4xp.natives;

public class XPLMDrawCallback {

	private long rawID;
	private DrawCallback callback;
	private XPLMDrawingPhase phase;
	private boolean wantsBefore;
	private Object refcon;
	
	public XPLMDrawCallback(long rawID, DrawCallback callback, XPLMDrawingPhase phase, boolean wantsBefore, Object refcon) {
		this.rawID = rawID;
		this.callback = callback;
		this.phase = phase;
		this.wantsBefore = wantsBefore;
		this.refcon = refcon;
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public DrawCallback getCallback() {
		return callback;
	}
	
	public XPLMDrawingPhase getPhase() {
		return phase;
	}
	
	public boolean isWantsBefore() {
		return wantsBefore;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
}
