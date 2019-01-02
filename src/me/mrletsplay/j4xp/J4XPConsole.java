package me.mrletsplay.j4xp;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.entity.widget.WidgetCaption;
import me.mrletsplay.j4xp.entity.widget.WidgetMainWindow;
import me.mrletsplay.j4xp.entity.widget.builder.MainWindowType;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetCloseAction;

public class J4XPConsole {

	private static final int MAX_BUFFER_SIZE = 500;

	private WidgetMainWindow consoleWidget;
	private List<WidgetCaption> consoleLineWidgets;
	private List<String> lineBuffer;
	private boolean needsUpdate;
	private int offset;
	
	public J4XPConsole() {
		consoleLineWidgets = new ArrayList<>();
		
		consoleWidget = WidgetBuilder.newMainWindowBuilder()
				.withBounds(100, 600, 800, 100)
				.withCloseBoxes(true)
				.withAutoHandleClose(WidgetCloseAction.HIDE)
				.withWindowType(MainWindowType.TRANSLUCENT)
				.withDescriptor("J4XP Console")
				.withVisibility(false)
				.create();
		
		WidgetBuilder.newScrollBarBuilder()
				.withBounds(780, 580, 800, 100)
				.withScrollBarMin(0)
				.withScrollBarMax(100)
				.withRootStatus(false)
				.withContainer(consoleWidget)
				.withDescriptor("")
				.withVisibility(true)
				.onSliderPositionChanged(w -> {
					offset = w.getSliderPosition();
					needsUpdate = true;
					updateLog();
					return true;
				})
				.create();
		
		for(int i = 0; i < 24; i++) {
			WidgetCaption c = WidgetBuilder.newCaptionBuilder()
				.withBounds(100, 580 - i * 20, 780, 560 - i * 20)
				.withRootStatus(false)
				.withContainer(consoleWidget)
				.withDescriptor("")
				.withLitStatus(true)
				.create();
			consoleLineWidgets.add(0, c);
		}
		
		this.lineBuffer = new ArrayList<>();
	}
	
	public void scrollToBottom() {
		offset = 0;
		needsUpdate = true;
		updateLog();
	}
	
	public void forceLogUpdate() {
		needsUpdate = true;
		updateLog();
	}
	
	public void updateLog() {
		if(!needsUpdate) return;
		for(int i = 0; i < consoleLineWidgets.size(); i++) {
			int idx = lineBuffer.size() - i - 1 - offset;
			if(idx < 0 || idx >= lineBuffer.size()) {
				consoleLineWidgets.get(i).setDescriptor("");
				continue;
			}
			String l = lineBuffer.get(idx);
			if(l != null) consoleLineWidgets.get(i).setDescriptor(l);
		}
		needsUpdate = false;
	}
	
	public WidgetMainWindow getConsoleWidget() {
		return consoleWidget;
	}
	
	public void appendLine(String line) {
		lineBuffer.add(line);
		while(lineBuffer.size() > MAX_BUFFER_SIZE) lineBuffer.remove(0);
		needsUpdate = true;
	}
	
}
