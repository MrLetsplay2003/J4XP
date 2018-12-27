package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetButton;
import me.mrletsplay.j4xp.natives.classes.XPWidgetID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetMessageID;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.xp_classes.XPWidgets;

public class ButtonWidgetBuilder extends AbstractWidgetBuilder<WidgetButton, ButtonWidgetBuilder> {

	private ButtonType type;
	private ButtonBehavior behavior;
	private boolean state;
	private OnPushButtonPressed onPushButtonPressed;
	private OnButtonStateChanged onButtonStateChanged;
	
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
	
	public ButtonWidgetBuilder onButtonStateChanged(OnButtonStateChanged onButtonStateChanged) {
		this.onButtonStateChanged = onButtonStateChanged;
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
				if(onButtonStateChanged != null) return onButtonStateChanged.onButtonStateChanged(bt, message.getParameter2() == 1);
			}
			return false;
		});
		return bt;
	}

}
