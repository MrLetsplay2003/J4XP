package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.classes.XPWidgetID;

public abstract class AbstractWidget implements Widget {

	private XPWidgetID id;
	
	public AbstractWidget(XPWidgetID id) {
		this.id = id;
		id.setWidget(this);
	}
	
	@Override
	public XPWidgetID getID() {
		return id;
	}
	
}
