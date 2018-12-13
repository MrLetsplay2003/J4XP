package me.mrletsplay.j4xp;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.entity.widget.WidgetCaption;
import me.mrletsplay.j4xp.entity.widget.WidgetMainWindow;
import me.mrletsplay.j4xp.entity.widget.builder.MainWindowType;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetBuilder;
import me.mrletsplay.j4xp.entity.widget.builder.WidgetCloseAction;

public class J4XPConsole {

	private WidgetMainWindow consoleWidget;
	private List<WidgetCaption> consoleLineWidgets;
	
	public J4XPConsole() {
		consoleLineWidgets = new ArrayList<>();
		
		consoleWidget = WidgetBuilder.newMainWindowBuilder()
				.withBounds(100, 400, 400, 100)
				.withCloseBoxes(true)
				.withAutoHandleClose(WidgetCloseAction.HIDE)
				.withWindowType(MainWindowType.TRANSLUCENT)
				.withDescriptor("J4XP Console")
				.withVisibility(true)
				.create();
		
		for(int i = 0; i < 14; i++) {
			WidgetCaption c = WidgetBuilder.newCaptionBuilder()
				.withBounds(100, 400 - i * 20, 400, 350 - i * 20)
				.withRootStatus(false)
				.withContainer(consoleWidget)
				.withDescriptor("")
				.withLitStatus(true)
				.create();
			consoleLineWidgets.add(0, c);
		}
		
	}
	
	public void updateLog() {
		for(int i = 0; i < consoleLineWidgets.size(); i++) {
			int idx = J4XP.getLog().getBuffer().size() - i - 1;
			if(idx < 0 || idx >= J4XP.getLog().getBuffer().size()) continue;
			String l = J4XP.getLog().getBuffer().get(idx);
			J4XP.getLog().getLogWriter().println(l);
			if(l != null) consoleLineWidgets.get(i).setDescriptor(l);
		}
	}
	
	public WidgetMainWindow getConsoleWidget() {
		return consoleWidget;
	}
	
}
