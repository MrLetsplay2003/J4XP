package me.mrletsplay.j4xp.plugin.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;
import me.mrletsplay.j4xp.plugin.entity.widget.WidgetSubWindow;

public class SubWindowWidgetBuilder implements WidgetBuilder<WidgetSubWindow, SubWindowWidgetBuilder>{

	private int left, top, right, bottom;
	private boolean visible;
	private String descriptor;
	private boolean isRoot;
	private XPWidgetID container;
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
	}
	
	@Override
	public SubWindowWidgetBuilder withBounds(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		return this;
	}

	@Override
	public SubWindowWidgetBuilder withVisibility(boolean visible) {
		this.visible = visible;
		return this;
	}

	@Override
	public SubWindowWidgetBuilder withDescriptor(String descriptor) {
		this.descriptor = descriptor;
		return this;
	}

	@Override
	public SubWindowWidgetBuilder withRootStatus(boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}

	@Override
	public SubWindowWidgetBuilder withContainer(XPWidgetID container) {
		this.container = container;
		return this;
	}
	
	public SubWindowWidgetBuilder withWindowType(SubWindowType windowType) {
		this.windowType = windowType;
		return this;
	}

	@Override
	public WidgetSubWindow create() throws IllegalStateException {
		if(isRoot && container != null) throw new IllegalStateException("Can't be root and have a container at the same time");
		if(descriptor == null) throw new IllegalStateException("Missing descriptor");
		XPWidgetID wID = XPWidgets.createWidget(left, top, right, bottom, visible, descriptor, isRoot, container, XPStandardWidgetClass.SUB_WINDOW);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SUB_WINDOW_TYPE, windowType.getValue());
		return new WidgetSubWindow(wID);
	}

}
