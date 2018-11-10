package me.mrletsplay.j4xp.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.mrletsplay.j4xp.natives.XPWidgetID;
import me.mrletsplay.j4xp.plugin.XPPlugin;

public class J4XP {
	
	private static PrintWriter logW;
	private static List<XPWidgetID> widgets;

	public static void main(String[] args) {
		System.out.println("To be loaded by the X-Plane 11 C++ plugin");
	}
	
	public static void init() {
		try {
			logW = new PrintWriter(new FileOutputStream(getLogFile(), true), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		log("Starting J4XP...");
		widgets = new ArrayList<>();
		XPPluginLoader.getInstance().loadPlugins(Arrays.asList(getPluginFolder().listFiles()));
	}
	
	public static void stop() {
		for(XPPlugin pl : XPPluginLoader.getInstance().getEnabledPlugins()) {
			pl.setEnabled(false);
		}
		logW.flush();
		logW.close();
	}
	
	public static void log(String message) {
		logW.println(message);
		logW.flush();
	}
	
	public static XPWidgetID getWidgetID(long rawID) {
		XPWidgetID id = widgets.stream().filter(i -> i.getRawID() == rawID).findFirst().orElse(null);
		if(id == null) {
			id = new XPWidgetID(rawID);
			widgets.add(id);
		}
		return id;
	}
	
	public static PrintWriter getLogWriter() {
		return logW;
	}
	
	public static File getJarFolder() {
		try {
			return new File(J4XP.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static File getPluginFolder() {
		File plF = new File(getJarFolder(), "plugins");
		if(!plF.exists()) plF.mkdirs();
		return plF;
	}
	
	public static File getLogFile() {
		File lF = new File(getJarFolder(), "log.txt");
		return lF;
	}
	
}
