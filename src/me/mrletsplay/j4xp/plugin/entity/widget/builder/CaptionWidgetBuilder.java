package me.mrletsplay.j4xp.plugin.entity.widget.builder;

import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;
import me.mrletsplay.j4xp.plugin.entity.widget.WidgetCaption;

public class CaptionWidgetBuilder implements WidgetBuilder<WidgetCaption, CaptionWidgetBuilder>{

	private int left, top, right, bottom;
	private boolean visible;
	private String descriptor;
	private boolean isRoot;
	private XPWidgetID container;
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
	
	@Override
	public CaptionWidgetBuilder withBounds(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		return this;
	}

	@Override
	public CaptionWidgetBuilder withVisibility(boolean visible) {
		this.visible = visible;
		return this;
	}

	@Override
	public CaptionWidgetBuilder withDescriptor(String descriptor) {
		this.descriptor = descriptor;
		return this;
	}

	@Override
	public CaptionWidgetBuilder withRootStatus(boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}

	@Override
	public CaptionWidgetBuilder withContainer(XPWidgetID container) {
		this.container = container;
		return this;
	}
	
	public CaptionWidgetBuilder withLitStatus(boolean isLit) {
		this.isLit = isLit;
		return this;
	}

	@Override
	public WidgetCaption create() throws IllegalStateException {
		if(isRoot && container != null) throw new IllegalStateException("Can't be root and have a container at the same time");
		if(descriptor == null) throw new IllegalStateException("Missing descriptor");
		XPWidgetID wID = XPWidgets.createWidget(left, top, right, bottom, visible, descriptor, isRoot, container, XPStandardWidgetClass.CAPTION);
		if(isLit) XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.CAPTION_LIT, 1);
		return new WidgetCaption(wID);
	}

}
