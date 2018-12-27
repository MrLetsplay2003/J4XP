package me.mrletsplay.j4xp.natives.interfaces;

import me.mrletsplay.j4xp.natives.classes.XPWidgetMessage;
import me.mrletsplay.j4xp.natives.enums.XPStandardWidgetMessageID;

@FunctionalInterface
public interface WidgetMessageHandler {

	public boolean onWidgetMessage(XPWidgetMessage message);
	
	public static WidgetMessageHandler mainWindowCloseDestroy() {
		return m -> {
			if(m.getMessageID().equals(XPStandardWidgetMessageID.MAIN_WINDOW_CLOSE_BUTTON_PUSHED)) {
				m.getWidget().destroy();
				return true;
			}
			return false;
		};
	}
	
	public static WidgetMessageHandler mainWindowCloseHide() {
		return m -> {
			if(m.getMessageID().equals(XPStandardWidgetMessageID.MAIN_WINDOW_CLOSE_BUTTON_PUSHED)) {
				m.getWidget().hide();
				return true;
			}
			return false;
		};
	}
	
	
}
