package me.mrletsplay.j4xp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J4XPLogWriter extends PrintStream {

	private OutputStream fileStream;
	private PrintStream originalOut;
	private ByteArrayOutputStream buffer;
	private J4XPLogLevel logLevel;
	
	public J4XPLogWriter(OutputStream fileStream, PrintStream originalOut, J4XPLogLevel logLevel) throws UnsupportedEncodingException {
		super(fileStream, true, "UTF-8");
		this.fileStream = fileStream;
		this.originalOut = originalOut;
		this.logLevel = logLevel;
		this.buffer = new ByteArrayOutputStream(1024);
	}
	
	@Override
	public void write(int b) {
		originalOut.write(b);
		buffer.write(b);
		flush();
	}
	
	@Override
	public void write(byte[] buf, int off, int len) {
		originalOut.write(buf, off, len);
		buffer.write(buf, off, len);
		flush();
	}
	
	@Override
	public void println() {
		print('\n');
		flush();
	}
	
	@Override
	public void flush() { // TODO: Force all bytes on flush()
		super.flush();
		try {
			String[] spl = buffer.toString("UTF-8").split("\n", -1);
			buffer.reset();
			if(!spl[spl.length - 1].isEmpty()) {
				buffer.write(spl[spl.length - 1].getBytes());
			}
			Arrays.stream(spl).limit(spl.length - 1).filter(a -> !a.isEmpty()).forEach(s -> logLine("[" + logLevel.toString() + "] " + s));
		} catch (IOException e) {}
		try {
			fileStream.flush();
		} catch (IOException e) {}
		originalOut.flush();
	}
	
	private void logLine(String line) {
		try {
			fileStream.write(line.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {}
		if(logLevel.ordinal() <= J4XPLogLevel.FILE_ONLY_DEBUG.ordinal()) return;
		for(String s : wrapString(line, 95)) {
			J4XP.getConsole().appendLine(s);
		}
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
	
}
