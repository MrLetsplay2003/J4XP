package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.XPLMPluginID;
import me.mrletsplay.j4xp.natives.PluginInfo;
import me.mrletsplay.j4xp.natives.XPLMFeatureEnumerator;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

public class XPLMPlugin {
	
	public static XPLMPluginID getMyID() {
		return new XPLMPluginID((long) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_MY_ID));
	}

	public static XPLMPluginID getPluginCount() {
		return new XPLMPluginID((long) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_COUNT_PLUGINS));
	}
	
	public static XPLMPluginID getNthPlugin(int index) {
		return new XPLMPluginID((long) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_NTH_PLUGIN, index));
	}
	
	public static XPLMPluginID findPluginByPath(String path) {
		return new XPLMPluginID((long) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_FIND_PLUGIN_BY_PATH, path));
	}
	
	public static XPLMPluginID findPluginBySignature(String signature) {
		return new XPLMPluginID((long) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_FIND_PLUGIN_BY_SIGNATURE, signature));
	}
	
	public static PluginInfo getPluginInfo(XPLMPluginID pluginID) {
		Object[] rInfo = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_PLUGIN_INFO, pluginID.getRawID());
		return new PluginInfo((String) rInfo[0], (String) rInfo[1], (String) rInfo[2], (String) rInfo[3]);
	}
	
	public static boolean isPluginEnabled(XPLMPluginID pluginID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_IS_PLUGIN_ENABLED, pluginID.getRawID());
	}
	
	public static boolean enablePlugin(XPLMPluginID pluginID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_ENABLE_PLUGIN, pluginID.getRawID());
	}
	
	public static void disablePlugin(XPLMPluginID pluginID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_DISABLE_PLUGIN, pluginID.getRawID());
	}
	
	public static void reloadPlugins() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_RELOAD_PLUGINS);
	}
	
	//public static void sendMessageToPlugin(PluginID pluginID, int message, ??? param) TODO
	
	public static boolean hasFeature(String feature) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_HAS_FEATURE, feature);
	}
	
	public static boolean isFeatureEnabled(String feature) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_IS_FEATURE_ENABLED, feature);
	}
	
	public static boolean enableFeature(String feature, boolean enable) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_ENABLE_FEATURE, feature, enable);
	}
	
	 public static void enumerateFeatures(XPLMFeatureEnumerator enumerator, Object refcon) {
		 XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_ENUMERATE_FEATURES, enumerator, refcon);
	 }
	
}
