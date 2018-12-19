package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetTextField;
import me.mrletsplay.j4xp.natives.XPLMFontID;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetMessageID;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class TextFieldWidgetBuilder extends AbstractWidgetBuilder<WidgetTextField, TextFieldWidgetBuilder>{

	private TextFieldType type;
	private boolean passwordMode;
	private int maxCharacters;
	private XPLMFontID font;
	private OnTextFieldChanged onTextFieldChanged;
	
	public TextFieldWidgetBuilder() {
		this.type = TextFieldType.ENTRY_FIELD;
		this.font = XPLMFontID.BASIC;
	}
	
	public TextFieldWidgetBuilder withType(TextFieldType type) {
		this.type = type;
		return this;
	}
	
	public TextFieldWidgetBuilder withPasswordMode(boolean passwordMode) {
		this.passwordMode = passwordMode;
		return this;
	}
	
	public TextFieldWidgetBuilder withMaxCharacters(int maxCharacters) {
		this.maxCharacters = maxCharacters;
		return this;
	}
	
	public TextFieldWidgetBuilder withFont(XPLMFontID font) {
		this.font = font;
		return this;
	}
	
	@Override
	public WidgetTextField create() throws IllegalStateException {
		XPWidgetID w = createBase(XPStandardWidgetClass.TEXT_FIELD);
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.TEXT_FIELD_TYPE, type.getValue());
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.TEXT_FIELD_PASSWORD_MODE, passwordMode ? 1 : 0);
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.TEXT_FIELD_MAX_CHARACTERS, maxCharacters);
		XPWidgets.setWidgetProperty(w, XPStandardWidgetPropertyID.TEXT_FIELD_FONT, font.getRawValue());
		WidgetTextField f = new WidgetTextField(w);
		if(onTextFieldChanged != null) {
			w.registerHandler(message -> {
				if(message.getMessageID().equals(XPStandardWidgetMessageID.TEXT_FIELD_CHANGED)) {
					onTextFieldChanged.onTextFieldChanged(f);
				}
				return false;
			});
		}
		return f;
	}

}
