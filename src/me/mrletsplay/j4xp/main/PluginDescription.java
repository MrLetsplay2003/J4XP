package me.mrletsplay.j4xp.main;

import java.io.InputStream;

import me.mrletsplay.mrcore.config.impl.ConfigLoader;
import me.mrletsplay.mrcore.config.v2.CustomConfig;

public class PluginDescription {

	private String name, main, version, author, description;
	
	public PluginDescription(String name, String main, String version, String author, String description) {
		this.name = name;
		this.main = main;
		this.version = version;
		this.author = author;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMain() {
		return main;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PluginDescription load(InputStream in) {
		CustomConfig cc = ConfigLoader.loadStreamConfig(in, false);
		return new PluginDescription(cc.getString("name"), cc.getString("main"), cc.getString("version"), cc.getString("author"), cc.getString("description"));
	}
	
}
