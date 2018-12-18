package me.mrletsplay.j4xp.plugin;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.XPPluginMessage;

public class XPPlugin {
	
	private boolean enabled;
	private JARLoader loader;
	private List<PluginOwnable> ownedObjects;
	
	protected XPPlugin() {
		loader = (JARLoader) getClass().getClassLoader();
		ownedObjects = new ArrayList<>();
	}

	public void setEnabled(boolean enabled) {
		if(this.enabled != enabled) {
			this.enabled = enabled;
			if(enabled) {
				onEnable();
			}else {
				for(PluginOwnable o : ownedObjects) o.destroy();
				onDisable();
			}
		}
	}
	
	public void addOwnedObject(PluginOwnable ownable) {
		if(!ownable.getOwner().equals(this)) throw new IllegalArgumentException("Object not owned by this plugin");
		ownedObjects.add(ownable);
	}
	
	public List<PluginOwnable> getOwnedObjects() {
		return ownedObjects;
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
