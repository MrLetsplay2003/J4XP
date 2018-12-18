package me.mrletsplay.j4xp.entity.widget.builder;

import me.mrletsplay.j4xp.entity.widget.WidgetScrollBar;
import me.mrletsplay.j4xp.natives.XPStandardWidgetClass;
import me.mrletsplay.j4xp.natives.XPStandardWidgetMessageID;
import me.mrletsplay.j4xp.natives.XPStandardWidgetPropertyID;
import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.natives.classes.XPWidgets;

public class ScrollBarWidgetBuilder extends AbstractWidgetBuilder<WidgetScrollBar, ScrollBarWidgetBuilder> {

	private ScrollBarType type;
	private int sliderPosition, scrollBarMin, scrollBarMax, scrollBarPagePageAmount;
	private OnSliderPositionChanged onSliderPositionChanged;
	
	public ScrollBarWidgetBuilder() {
		this.type = ScrollBarType.SCROLL_BAR;
		this.scrollBarMax = 100;
		this.scrollBarPagePageAmount = 5;
	}
	
	public ScrollBarWidgetBuilder withType(ScrollBarType type) {
		this.type = type;
		return this;
	}
	
	public ScrollBarWidgetBuilder withSliderPosition(int sliderPosition) {
		this.sliderPosition = sliderPosition;
		return this;
	}
	
	public ScrollBarWidgetBuilder withScrollBarMin(int scrollBarMin) {
		this.scrollBarMin = scrollBarMin;
		return this;
	}
	
	public ScrollBarWidgetBuilder withScrollBarMax(int scrollBarMax) {
		this.scrollBarMax = scrollBarMax;
		return this;
	}
	
	public ScrollBarWidgetBuilder withScrollBarPagePageAmount(int scrollBarPagePageAmount) {
		this.scrollBarPagePageAmount = scrollBarPagePageAmount;
		return this;
	}
	
	public ScrollBarWidgetBuilder withOnSliderPositionChanged(OnSliderPositionChanged onSliderPositionChanged) {
		this.onSliderPositionChanged = onSliderPositionChanged;
		return this;
	}
	
	@Override
	public WidgetScrollBar create() throws IllegalStateException {
		XPWidgetID wID = createBase(XPStandardWidgetClass.SCROLL_BAR);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SCROLL_BAR_TYPE, type.getValue());
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SCROLL_BAR_SLIDER_POSITION, sliderPosition);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SCROLL_BAR_MIN, scrollBarMin);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SCROLL_BAR_MAX, scrollBarMax);
		XPWidgets.setWidgetProperty(wID, XPStandardWidgetPropertyID.SCROLL_BAR_PAGE_AMOUNT, scrollBarPagePageAmount);
		WidgetScrollBar sb = new WidgetScrollBar(wID);
		if(onSliderPositionChanged != null) {
			wID.registerHandler(message -> {
				if(message.getMessageID().equals(XPStandardWidgetMessageID.SCROLL_BAR_SLIDER_POSITION_CHANGED)) {
					return onSliderPositionChanged.onSliderPositionChanged(sb);
				}
				return false;
			});
		}
		return sb;
	}

}
