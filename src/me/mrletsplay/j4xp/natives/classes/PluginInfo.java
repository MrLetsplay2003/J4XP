package me.mrletsplay.j4xp.natives.classes;

public class PluginInfo {

	private String name, filePath, signature, description;
	
	public PluginInfo(String name, String filePath, String signature, String description) {
		this.name = name;
		this.filePath = filePath;
		this.signature = signature;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public String getDescription() {
		return description;
	}

}
