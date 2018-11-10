package me.mrletsplay.j4xp.plugin;

import me.mrletsplay.j4xp.main.JARLoader;
import me.mrletsplay.j4xp.natives.XPPluginMessage;

public class XPPlugin {
	
	private boolean enabled;
	private JARLoader loader;
	
	protected XPPlugin() {}

	public void setLoader(JARLoader loader) {
		this.loader = loader;
	}
	
	public void setEnabled(boolean enabled) {
		if(this.enabled != enabled) {
			this.enabled = enabled;
			if(enabled) {
				onEnable();
			}else {
				onDisable();
			}
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public JARLoader getLoader() {
		return loader;
	}
	
	public void onEnable() {}
	
	public void onDisable() {}
	
	public void onPluginMessage(XPPluginMessage message) {}
	
}
