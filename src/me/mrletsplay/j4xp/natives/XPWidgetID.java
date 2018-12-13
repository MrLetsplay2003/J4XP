package me.mrletsplay.j4xp.natives;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.entity.widget.Widget;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class XPWidgetID {

	private long rawID;
	private List<WidgetMessageHandler> handlers;
	private Widget widget;
	
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
	
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	public Widget getWidget() {
		return widget;
	}
	
	public void destroy() {
		XPWidgets.destroyWidget(this, true);
	}
	
	public void hide() {
		XPWidgets.hideWidget(this);
	}
	
}
