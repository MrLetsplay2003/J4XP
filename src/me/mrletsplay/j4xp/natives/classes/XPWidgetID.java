package me.mrletsplay.j4xp.natives.classes;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.J4XPIdentifiable;
import me.mrletsplay.j4xp.entity.widget.Widget;
import me.mrletsplay.j4xp.natives.interfaces.WidgetMessageHandler;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;
import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class XPWidgetID implements J4XPPluginOwnable, J4XPIdentifiable {

	private XPPlugin owner;
	private long rawID;
	private List<WidgetMessageHandler> handlers;
	private Widget widget;
	
	public XPWidgetID(XPPlugin owner, long rawID) {
		this.owner = owner;
		this.rawID = rawID;
		this.handlers = new ArrayList<>();
		if(owner != null) owner.addOwnedObject(this);
	}
	
	@Override
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

	@Override
	public XPPlugin getOwner() {
		return owner;
	}
	
}
