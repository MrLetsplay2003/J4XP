package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.Widget;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public abstract class AbstractWidgetBuilder<T extends Widget, Self extends AbstractWidgetBuilder<T, Self>> implements WidgetBuilder<T, Self> {

	protected int left, top, right, bottom;
	protected boolean visible;
	protected String descriptor;
	protected boolean isRoot;
	protected XPWidgetID container;
	
	public AbstractWidgetBuilder() {
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
	public Self withBounds(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		return getSelf();
	}

	@Override
	public Self withVisibility(boolean visible) {
		this.visible = visible;
		return getSelf();
	}

	@Override
	public Self withDescriptor(String descriptor) {
		this.descriptor = descriptor;
		return getSelf();
	}

	@Override
	public Self withRootStatus(boolean isRoot) {
		this.isRoot = isRoot;
		return getSelf();
	}

	@Override
	public Self withContainer(XPWidgetID container) {
		this.container = container;
		return getSelf();
	}
	
	protected XPWidgetID createBase(XPStandardWidgetClass widgetClass) {
		if(isRoot && container != null) throw new IllegalStateException("Can't be root and have a container at the same time");
		if(descriptor == null) throw new IllegalStateException("Missing descriptor");
		return XPWidgets.createWidget(left, top, right, bottom, visible, descriptor, isRoot, container, widgetClass);
	}
	
}
