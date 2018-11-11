package me.mrletsplay.j4xp.plugin.entity.widget;

import me.mrletsplay.j4xp.natives.XPWidgetGeometry;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public interface Widget {
	
	public XPWidgetID getID();
	
	public default void setDescriptor(String descriptor) {
		XPWidgets.setWidgetDescriptor(getID(), descriptor);
	}
	
	public default String getDescriptor() {
		return XPWidgets.getWidgetDescriptor(getID());
	}
	
	public default void setBounds(int left, int top, int right, int bottom) {
		XPWidgets.setWidgetGeometry(getID(), left, top, right, bottom);
	}
	
	public default XPWidgetGeometry getBounds() {
		return XPWidgets.getWidgetGeometry(getID());
	}
	
	public default XPWidgetGeometry getExposedBounds() {
		return XPWidgets.getWidgetExposedGeometry(getID());
	}
	
	public default void show() {
		XPWidgets.showWidget(getID());
	}
	
	public default void hide() {
		XPWidgets.hideWidget(getID());
	}
	
	public default boolean isVisible() {
		return XPWidgets.isWidgetVisible(getID());
	}
	
	public default void toggleVisibility() {
		if(isVisible()) {
			hide();
		}else {
			show();
		}
	}
	
	public default void destroy() {
		XPWidgets.destroyWidget(getID(), true);
	}

}
