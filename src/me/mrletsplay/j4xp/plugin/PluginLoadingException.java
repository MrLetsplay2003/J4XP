package me.mrletsplay.j4xp.plugin;

public class PluginLoadingException extends PluginException {

	private static final long serialVersionUID = 4691255806929122951L;

	public PluginLoadingException(String message, Throwable cause) {
		super(message, cause);
	}

	public PluginLoadingException(String message) {
		super(message);
	}

	public PluginLoadingException(Throwable cause) {
		super(cause);
	}
	
}
