package me.mrletsplay.j4xp.plugin.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.plugin.entity.widget.Widget;

public interface WidgetBuilder<T extends Widget, Self extends WidgetBuilder<T, Self>> {

	public static MainWindowWidgetBuilder newMainWindowBuilder() {
		return new MainWindowWidgetBuilder();
	}

	public static SubWindowWidgetBuilder newSubWindowBuilder() {
		return new SubWindowWidgetBuilder();
	}

	public static CaptionWidgetBuilder newCaptionBuilder() {
		return new CaptionWidgetBuilder();
	}
	
	public Self withBounds(int left, int top, int right, int bottom);
	
	public Self withVisibility(boolean visible);
	
	public Self withDescriptor(String descriptor);
	 
	public Self withRootStatus(boolean isRoot);
	
	public Self withContainer(XPWidgetID container);
	
	public default Self withContainer(Widget container) {
		return withContainer(container.getID());
	}
	
	public T create() throws IllegalStateException;
	
}
