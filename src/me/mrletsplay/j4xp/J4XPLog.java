package me.mrletsplay.j4xp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		Arrays.stream(message.split("\n")).forEach(m -> {
			logW.println("[" + logLevel.toString() + "] " + message);
			logW.flush();
			for(String s : wrapString(m, 100)) {
				logConsole(logLevel, s);
			}
		});
	}
	
	private List<String> wrapString(String str, int len) {
		List<String> l = new ArrayList<>();
		while(str.length() > len) {
			l.add(str.substring(0, len));
			str = str.substring(len);
		}
		l.add(str);
		return l;
	}
	
	public void log(Exception e) {
		log(J4XPLogLevel.ERROR, e.toString());
		for(StackTraceElement el : e.getStackTrace()) {
			log(J4XPLogLevel.ERROR, "at " + el.toString());
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
	
//	public PrintWriter getLogWriter() {
//		return logW;
//	}
	
}
