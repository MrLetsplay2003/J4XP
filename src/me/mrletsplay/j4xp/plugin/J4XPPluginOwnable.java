package me.mrletsplay.j4xp.plugin;

import me.mrletsplay.j4xp.J4XPDestructible;

/**
 * Represents an object that should be removed when its owning plugin is disabled.<br>
 * When the object should be removed, the {@link #destroy()} method is called. The respective object should then handle its own destruction.<br>
 * Before an object can be destroyed automatically, it needs to be added to a plugin using {@link XPPlugin#addOwnedObject(PluginOwnable)}. This should normally be done inside the constructor of its respective class.<br>
 * A null owner indicates that this object is owned by either J4XP or a native C++ plugin
 * @author MrLetsplay2003
 */
public interface J4XPPluginOwnable extends J4XPDestructible {

	public XPPlugin getOwner();
	
}
