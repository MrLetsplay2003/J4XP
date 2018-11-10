package me.mrletsplay.j4xp.natives;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class XPWidgetID {

	private long rawID;
	private List<WidgetMessageHandler> handlers;
	
	public XPWidgetID(long rawID) {
		this.rawID = rawID;
		this.handlers = new ArrayList<>();
	}
	
	public long getRawID() {
		return rawID;
	}
	
	public void registerHandler(WidgetMessageHandler listener) {
		handlers.add(listener);
	}
	
	public List<WidgetMessageHandler> getHandlers() {
		return handlers;
	}
	
	public void destroy() {
		XPWidgets.destroyWidget(this, true);
	}
	
}
