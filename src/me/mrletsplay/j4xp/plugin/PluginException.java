package me.mrletsplay.j4xp.plugin;

public class PluginException extends RuntimeException {

	private static final long serialVersionUID = 437498629081202664L;

	public PluginException(String message, Throwable cause) {
		super(message, cause);
	}

	public PluginException(String message) {
		super(message);
	}

	public PluginException(Throwable cause) {
		super(cause);
	}
	
}
