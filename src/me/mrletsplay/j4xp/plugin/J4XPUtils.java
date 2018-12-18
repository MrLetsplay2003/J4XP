package me.mrletsplay.j4xp.plugin;

import java.util.Arrays;
import java.util.Objects;

public class J4XPUtils {

	public static XPPlugin getMethodCaller() {
		return Arrays.stream(new Exception().getStackTrace())
				.map(e -> J4XPPluginLoader.getInstance().getEnabledPlugins().stream()
						.filter(p -> p.getLoader().ownsClass(e.getClassName()))
						.findFirst().orElse(null))
				.filter(Objects::nonNull)
				.findFirst().orElse(null);
	}
	
}
