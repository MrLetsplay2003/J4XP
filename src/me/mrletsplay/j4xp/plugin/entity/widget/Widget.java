package me.mrletsplay.j4xp.plugin.entity.widget;

import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public interface Widget {
	
	public XPWidgetID getID();
	
	public default void destroy() {
		XPWidgets.destroyWidget(getID(), true);
	}

}
