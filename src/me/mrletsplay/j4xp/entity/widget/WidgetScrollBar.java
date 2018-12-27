package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public class WidgetScrollBar extends AbstractWidget {

	public WidgetScrollBar(XPWidgetID id) {
		super(id);
	}
	
	public int getSliderPosition() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.SCROLL_BAR_SLIDER_POSITION);
	}

}
