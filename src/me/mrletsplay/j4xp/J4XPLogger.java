package me.mrletsplay.j4xp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class J4XPLogger {
	
	private Map<J4XPLogLevel, J4XPLogWriter> logWriters;
	private OutputStream fileOutputStream;
	private J4XPLogWriter defaultWriter;
	
	public J4XPLogger() {
		try {
			logWriters = new HashMap<>();
			fileOutputStream = new FileOutputStream(J4XP.getLogFile(), true);
			
			PrintStream origSysOut = System.out, origSysErr = System.err;
			
			System.setOut(defaultWriter = registerLogger(J4XPLogLevel.INFO, origSysOut));
			registerLogger(J4XPLogLevel.FILE_ONLY_DEBUG, origSysOut);
			registerLogger(J4XPLogLevel.DEBUG, origSysOut);

			System.setErr(registerLogger(J4XPLogLevel.ERROR, origSysErr));
			registerLogger(J4XPLogLevel.WARN, origSysErr);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private J4XPLogWriter registerLogger(J4XPLogLevel logLevel, PrintStream originalOut) throws UnsupportedEncodingException {
		J4XPLogWriter w = new J4XPLogWriter(fileOutputStream, originalOut, logLevel);
		logWriters.put(logLevel, w);
		return w;
	}
	
	public void log(J4XPLogLevel logLevel, String message) {
		getLogWriter(logLevel).println(message);
	}
	
	private J4XPLogWriter getLogWriter(J4XPLogLevel level) {
		return logWriters.getOrDefault(level, defaultWriter);
	}
	
	public void log(Exception e) {
		log(J4XPLogLevel.ERROR, e.toString());
		for(StackTraceElement el : e.getStackTrace()) {
			log(J4XPLogLevel.ERROR, "at " + el.toString());
		}
	}
	
	public void close() {
		logWriters.values().forEach(J4XPLogWriter::flush);
		logWriters.values().forEach(J4XPLogWriter::close);
	}
	
}
