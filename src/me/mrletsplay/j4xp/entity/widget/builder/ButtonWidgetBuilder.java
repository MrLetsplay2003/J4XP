package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetButton;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetMessageID;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class ButtonWidgetBuilder extends AbstractWidgetBuilder<WidgetButton, ButtonWidgetBuilder> {

	private ButtonType type;
	private ButtonBehavior behavior;
	private boolean state;
	private OnPushButtonPressed onPushButtonPressed;
	private OnPushButtonStateChanged onPushButtonStateChanged;
	
	public ButtonWidgetBuilder() {
		this.type = ButtonType.PUSH_BUTTON;
		this.behavior = ButtonBehavior.PUSH_BUTTON;
	}
	
	public ButtonWidgetBuilder withType(ButtonType type) {
		this.type = type;
		return this;
	}
	
	public ButtonWidgetBuilder withBehavior(ButtonBehavior behavior) {
		this.behavior = behavior;
		return this;
	}
	
	public ButtonWidgetBuilder withState(boolean state) {
		this.state = state;
		return this;
	}
	
	public ButtonWidgetBuilder onPushButtonPressed(OnPushButtonPressed onPushButtonPressed) {
		this.onPushButtonPressed = onPushButtonPressed;
		return this;
	}
	
	public ButtonWidgetBuilder onPushButtonStateChanged(OnPushButtonStateChanged onPushButtonStateChanged) {
		this.onPushButtonStateChanged = onPushButtonStateChanged;
		return this;
	}
	
	@Override
	public WidgetButton create() throws IllegalStateException {
		XPWidgetID w = createBase(XPStandardWidgetClass.BUTTON);
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.BUTTON_TYPE, type.getValue());
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.BUTTON_BEHAVIOR, behavior.getValue());
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.BUTTON_STATE, state ? 1 : 0);
		WidgetButton bt = new WidgetButton(w);
		w.registerHandler(message -> {
			if(message.getMessageID().equals(XPStandardWidgetMessageID.BUTTON_PUSH_BUTTON_PRESSED)) {
				if(onPushButtonPressed != null) return onPushButtonPressed.onPushButtonPressed(bt);
			}else if(message.getMessageID().equals(XPStandardWidgetMessageID.BUTTON_STATE_CHANGED)) {
				if(onPushButtonStateChanged != null) return onPushButtonStateChanged.onPushButtonStateChanged(bt, message.getParameter2() == 1);
			}
			return false;
		});
		return bt;
	}

}
