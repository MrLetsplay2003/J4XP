package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetCaption;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public class CaptionWidgetBuilder extends AbstractWidgetBuilder<WidgetCaption, CaptionWidgetBuilder>{

	private boolean isLit;
	
	public CaptionWidgetBuilder() {
		left = 0;
		top = 100;
		right = 100;
		bottom = 0;
		visible = true;
		descriptor = null;
		isRoot = true;
		container = null;
	}
	
	public CaptionWidgetBuilder withLitStatus(boolean isLit) {
		this.isLit = isLit;
		return this;
	}

	@Override
	public WidgetCaption create() throws IllegalStateException {
		XPWidgetID wID = createBase(XPStandardWidgetClass.CAPTION);
		if(isLit) XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.CAPTION_LIT, 1);
		return new WidgetCaption(wID);
	}

}
