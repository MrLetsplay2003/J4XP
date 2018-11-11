package me.mrletsplay.j4xp.plugin.entity.widget.builder;

import me.mrletsplay.j4xp.natives.WidgetMessageHandler;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;
import me.mrletsplay.j4xp.plugin.entity.widget.WidgetMainWindow;

public class MainWindowWidgetBuilder implements WidgetBuilder<WidgetMainWindow, MainWindowWidgetBuilder> {

	private int left, top, right, bottom;
	private boolean visible;
	private String descriptor;
	private boolean isRoot;
	private XPWidgetID container;
	private MainWindowType windowType;
	private boolean hasCloseBoxes;
	private WidgetCloseAction closeAction;
	
	public MainWindowWidgetBuilder() {
		left = 0;
		top = 100;
		right = 100;
		bottom = 0;
		visible = true;
		descriptor = null;
		isRoot = true;
		container = null;
		windowType = MainWindowType.DEFAULT;
		hasCloseBoxes = false;
	}
	
	@Override
	public MainWindowWidgetBuilder withBounds(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		return this;
	}

	@Override
	public MainWindowWidgetBuilder withVisibility(boolean visible) {
		this.visible = visible;
		return this;
	}

	@Override
	public MainWindowWidgetBuilder withDescriptor(String descriptor) {
		this.descriptor = descriptor;
		return this;
	}

	@Override
	public MainWindowWidgetBuilder withRootStatus(boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}

	@Override
	public MainWindowWidgetBuilder withContainer(XPWidgetID container) {
		this.container = container;
		return this;
	}
	
	public MainWindowWidgetBuilder withWindowType(MainWindowType windowType) {
		this.windowType = windowType;
		return this;
	}
	
	public MainWindowWidgetBuilder withCloseBoxes(boolean hasCloseBoxes) {
		this.hasCloseBoxes = hasCloseBoxes;
		return this;
	}
	
	public MainWindowWidgetBuilder withAutoHandleClose(WidgetCloseAction closeAction) {
		this.closeAction = closeAction;
		return this;
	}
	
	public WidgetMainWindow create() throws IllegalStateException {
		if(isRoot && container != null) throw new IllegalStateException("Can't be root and have a container at the same time");
		if(descriptor == null) throw new IllegalStateException("Missing descriptor");
		XPWidgetID wID = XPWidgets.createWidget(left, top, right, bottom, visible, descriptor, isRoot, container, XPStandardWidgetClass.MAIN_WINDOW);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.MAIN_WINDOW_TYPE, windowType.getValue());
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.MAIN_WINDOW_HAS_CLOSE_BOXES, hasCloseBoxes ? 1 : 0);
		if(hasCloseBoxes && closeAction != null) {
			switch (closeAction) {
				case DESTROY:
				{
					wID.registerHandler(WidgetMessageHandler.mainWindowCloseDestroy());
				}
				case HIDE:
				{
					wID.registerHandler(WidgetMessageHandler.mainWindowCloseHide());
				}
			}
		}
		return new WidgetMainWindow(wID);
	}
	
}
