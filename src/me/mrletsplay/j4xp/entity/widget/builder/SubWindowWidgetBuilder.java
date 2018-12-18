package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetSubWindow;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class SubWindowWidgetBuilder extends AbstractWidgetBuilder<WidgetSubWindow, SubWindowWidgetBuilder> {

	private SubWindowType windowType;
	
	public SubWindowWidgetBuilder() {
		left = 0;
		top = 100;
		right = 100;
		bottom = 0;
		visible = true;
		descriptor = null;
		isRoot = true;
		container = null;
		windowType = SubWindowType.DEFAULT;
	}
	
	public SubWindowWidgetBuilder withWindowType(SubWindowType windowType) {
		this.windowType = windowType;
		return this;
	}

	@Override
	public WidgetSubWindow create() throws IllegalStateException {
		XPWidgetID wID = createBase(XPStandardWidgetClass.SUB_WINDOW);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SUB_WINDOW_TYPE, windowType.getValue());
		return new WidgetSubWindow(wID);
	}

}
