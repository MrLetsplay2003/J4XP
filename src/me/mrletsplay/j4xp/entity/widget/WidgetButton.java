package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class WidgetButton extends AbstractWidget {

	public WidgetButton(XPWidgetID id) {
		super(id);
	}
	
	public boolean getState() {
		return XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.BUTTON_STATE) == 1;
	}

}
