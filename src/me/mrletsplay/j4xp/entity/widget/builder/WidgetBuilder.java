package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.Builder;
import me.mrletsplay.j4xp.entity.widget.Widget;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;

public interface WidgetBuilder<T extends Widget, Self extends WidgetBuilder<T, Self>> extends Builder<T, Self> {

	public static MainWindowWidgetBuilder newMainWindowBuilder() {
		return new MainWindowWidgetBuilder();
	}

	public static SubWindowWidgetBuilder newSubWindowBuilder() {
		return new SubWindowWidgetBuilder();
	}

	public static CaptionWidgetBuilder newCaptionBuilder() {
		return new CaptionWidgetBuilder();
	}

	public static ScrollBarWidgetBuilder newScrollBarBuilder() {
		return new ScrollBarWidgetBuilder();
	}

	public static ButtonWidgetBuilder newButtonBuilder() {
		return new ButtonWidgetBuilder();
	}
	
	public Self withBounds(int left, int top, int right, int bottom);
	
	public Self withVisibility(boolean visible);
	
	public Self withDescriptor(String descriptor);
	 
	public Self withRootStatus(boolean isRoot);
	
	public Self withContainer(XPWidgetID container);
	
	public default Self withContainer(Widget container) {
		return withContainer(container.getID());
	}
	
}
