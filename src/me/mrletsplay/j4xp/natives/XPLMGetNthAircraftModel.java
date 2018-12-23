package me.mrletsplay.j4xp.natives;

public class XPLMGetNthAircraftModel {
	
    private String fileName;    
    private String path;
    
    public XPLMGetNthAircraftModel(String fileName, String path) {
		this.fileName = fileName;
		this.path = path;
	}
    
    public String getFileName() {
		return fileName;
	}
    
    public String getPath() {
		return path;
    }
}