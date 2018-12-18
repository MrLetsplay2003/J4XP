package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetMainWindow;
import me.mrletsplay.j4xp.natives.WidgetMessageHandler;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class MainWindowWidgetBuilder extends AbstractWidgetBuilder<WidgetMainWindow, MainWindowWidgetBuilder> {

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
		XPWidgetID wID = createBase(XPStandardWidgetClass.MAIN_WINDOW);
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
