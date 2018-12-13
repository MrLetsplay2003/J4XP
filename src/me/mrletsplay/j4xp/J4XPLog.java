package me.mrletsplay.j4xp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.mrletsplay.mrcore.misc.StringUtils;

public class J4XPLog {

	private static final int MAX_BUFFER_SIZE = 100;
	
	private PrintWriter logW;
	private List<String> buffer;
	
	public J4XPLog() {
		this.buffer = new ArrayList<>();
		try {
			logW = new PrintWriter(new FileOutputStream(J4XP.getLogFile(), true), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void log(J4XPLogLevel logLevel, String message) {
		Arrays.stream(message.split("\n")).forEach(m -> logW.println(message));
		logW.flush();
		for(String s : StringUtils.wrapString(message, 40)) {
			logConsole(logLevel, s);
		}
	}
	
	private void logConsole(J4XPLogLevel logLevel, String message) {
		if(logLevel.ordinal() > J4XPLogLevel.DEBUG.ordinal()) buffer.add(message);
		while(buffer.size() > MAX_BUFFER_SIZE) buffer.remove(0);
		if(logLevel.ordinal() > J4XPLogLevel.DEBUG.ordinal() && J4XP.getConsole() != null) J4XP.getConsole().updateLog();
	}
	
	public void close() {
		logW.flush();
		logW.close();
	}
	
	public List<String> getBuffer() {
		return buffer;
	}
	
	public PrintWriter getLogWriter() {
		return logW;
	}
	
}
