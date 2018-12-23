package me.mrletsplay.j4xp.plugin;

import java.util.ArrayList;
import java.util.List;

import me.mrletsplay.j4xp.natives.XPPluginMessage;

public class XPPlugin {
	
	private boolean enabled;
	private JARLoader loader;
	private List<J4XPPluginOwnable> ownedObjects;
	private PluginDescription description;
	
	protected XPPlugin() {
		loader = (JARLoader) getClass().getClassLoader();
		ownedObjects = new ArrayList<>();
		description = loader.loadDescription();
	}
	
	public PluginDescription getDescription() {
		return description;
	}
	
	public String getName() {
		return description.getName();
	}

	public void setEnabled(boolean enabled) {
		if(this.enabled != enabled) {
			this.enabled = enabled;
			if(enabled) {
				onEnable();
			}else {
				for(J4XPPluginOwnable o : ownedObjects) o.destroy();
				onDisable();
			}
		}
	}
	
	public void addOwnedObject(J4XPPluginOwnable ownable) {
		if(!ownable.getOwner().equals(this)) throw new IllegalArgumentException("Object not owned by this plugin");
		ownedObjects.add(ownable);
	}

	public void removeOwnedObject(J4XPPluginOwnable ownable) {
		if(!ownable.getOwner().equals(this)) throw new IllegalArgumentException("Object not owned by this plugin");
		ownedObjects.remove(ownable);
	}
	
	public List<J4XPPluginOwnable> getOwnedObjects() {
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
