package me.mrletsplay.j4xp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import me.mrletsplay.j4xp.plugin.J4XPPluginOwnable;
import me.mrletsplay.j4xp.plugin.XPPlugin;
import me.mrletsplay.mrcore.misc.LookupList;
import me.mrletsplay.mrcore.misc.SingleLookupList;

public class J4XPIDCache<T extends J4XPIdentifiable> {
	
	private static List<J4XPIDCache<?>> caches;
	
	static {
		caches = new ArrayList<>();
	}
	
	public static List<J4XPIDCache<?>> getCaches() {
		return caches;
	}

	private BiFunction<XPPlugin, Long, T> creationFunction;
	private LookupList<Long, T> elements;
	
	public J4XPIDCache(BiFunction<XPPlugin, Long, T> creationFunction) {
		this.creationFunction = creationFunction;
		this.elements = new SingleLookupList<>(J4XPIdentifiable::getRawID);
		caches.add(this);
	}
	
	public J4XPIDCache(Function<Long, T> creationFunction) {
		this((o, id) -> creationFunction.apply(id));
	}
	
	public J4XPIDCache() {
		this.elements = new SingleLookupList<>(J4XPIdentifiable::getRawID);
	}
	
	public <E extends T> void add(E t) {
		elements.add(t);
	}
	
	public T create(XPPlugin owner) {
		T e = creationFunction.apply(owner, newID());
		add(e);
		return e;
	}
	
	public T create(XPPlugin owner, long rawID) {
		T e = creationFunction.apply(owner, rawID);
		add(e);
		return e;
	}
	
	public <E extends T> E create(Function<Long, E> creationFunction) {
		E e = creationFunction.apply(newID());
		add(e);
		return null;
	}
	
	public T get(long rawID) {
		return elements.stream().filter(e -> e.getRawID() == rawID).findFirst().orElse(null);
	}
	
	public T getOrCreate(long rawID, Function<Long, T> creationFunction) {
		if(creationFunction == null) throw new IllegalStateException("No creation function provided");
		T t = get(rawID);
		if(t == null) {
			t = creationFunction.apply(rawID);
			elements.add(t);
		}
		return t;
	}
	
	public T getOrCreate(XPPlugin plugin, long rawID) {
		return getOrCreate(rawID, id -> creationFunction.apply(plugin, rawID));
	}
	
	public void remove(long rawID) {
		Iterator<T> it = elements.iterator();
		while(it.hasNext()) {
			T t = it.next();
			if(t.getRawID() == rawID) {
				it.remove();
				if(t instanceof J4XPPluginOwnable) {
					((J4XPPluginOwnable) t).getOwner().removeOwnedObject((J4XPPluginOwnable) t);
				}
			}
		}
	}
	
	public long newID() {
		return System.currentTimeMillis();
	}
	
	public List<T> getElements() {
		return elements;
	}
	
}
