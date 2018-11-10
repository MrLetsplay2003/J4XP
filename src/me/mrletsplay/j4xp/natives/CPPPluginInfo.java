package me.mrletsplay.j4xp.natives;

public class CPPPluginInfo {

	private String name, filePath, signature, description;
	
	public CPPPluginInfo(String name, String filePath, String signature, String description) {
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
