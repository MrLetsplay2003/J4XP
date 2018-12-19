package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class WidgetScrollBar extends AbstractWidget {

	public WidgetScrollBar(XPWidgetID id) {
		super(id);
	}
	
	public int getSliderPosition() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.SCROLL_BAR_SLIDER_POSITION);
	}

}
