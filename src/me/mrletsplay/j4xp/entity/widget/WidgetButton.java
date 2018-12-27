package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public class WidgetButton extends AbstractWidget {

	public WidgetButton(XPWidgetID id) {
		super(id);
	}
	
	public void setState(boolean state) {
		XPWidgets.setWidgetProperty(getID(), XPStandardWidgetPropertyID.BUTTON_STATE, state ? 1 : 0);
	}
	
	public boolean getState() {
		return XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.BUTTON_STATE) == 1;
	}

}
