package me.mrletsplay.j4xp.plugin.entity.widget;

import me.mrletsplay.j4xp.natives.XPWidgetID;

public class WidgetMainWindow implements Widget {

	private XPWidgetID widgetID;
	
	public WidgetMainWindow(XPWidgetID widgetID) {
		this.widgetID = widgetID;
	}

	@Override
	public XPWidgetID getID() {
		return widgetID;
	}
	
}
