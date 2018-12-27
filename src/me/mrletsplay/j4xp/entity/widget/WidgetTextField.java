package me.mrletsplay.j4xp.entity.widget;

import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public class WidgetTextField extends AbstractWidget {

	public WidgetTextField(XPWidgetID id) {
		super(id);
	}
	
	public int getEditFieldSelectionStart() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.TEXT_FIELD_EDIT_SEL_START);
	}
	
	public int getEditFieldSelectionEnd() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.TEXT_FIELD_EDIT_SEL_END);
	}
	
	public int getEditFieldDragSelectionStart() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.TEXT_FIELD_EDIT_SEL_DRAG_START);
	}
	
	public int getGetScrollPosition() {
		return (int) XPWidgets.getWidgetProperty(getID(), XPStandardWidgetPropertyID.TEXT_FIELD_SCROLL_POSITION);
	}
	
}
