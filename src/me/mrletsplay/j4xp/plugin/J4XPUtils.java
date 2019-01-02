package me.mrletsplay.j4xp.plugin;

import java.util.Arrays;
import java.util.Objects;

import me.mrletsplay.j4xp.J4XP;

public class J4XPUtils {

	public static XPPlugin getMethodCaller() {
		if(J4XP.getPluginLoader() == null) return null;
		return Arrays.stream(new Exception().getStackTrace())
				.map(e -> J4XP.getPluginLoader().getEnabledPlugins().stream()
						.filter(p -> p.getLoader().ownsClass(e.getClassName()))
						.findFirst().orElse(null))
				.filter(Objects::nonNull)
				.findFirst().orElse(null);
	}
	
}
