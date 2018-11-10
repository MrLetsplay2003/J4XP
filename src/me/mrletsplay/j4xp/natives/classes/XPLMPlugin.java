package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.CPPPluginID;
import me.mrletsplay.j4xp.natives.CPPPluginInfo;
import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

public class XPLMPlugin {
	
	public static CPPPluginID getMyID() {
		return new CPPPluginID((int) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_MY_ID));
	}

	public static CPPPluginID getPluginCount() {
		return new CPPPluginID((int) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_COUNT_PLUGINS));
	}
	
	public static CPPPluginID getNthPlugin(int index) {
		return new CPPPluginID((int) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_NTH_PLUGIN, index));
	}
	
	public static CPPPluginID findPluginByPath(String path) {
		return new CPPPluginID((int) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_FIND_PLUGIN_BY_PATH, path));
	}
	
	public static CPPPluginID findPluginBySignature(String signature) {
		return new CPPPluginID((int) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_FIND_PLUGIN_BY_SIGNATURE, signature));
	}
	
	public static CPPPluginInfo getPluginInfo(CPPPluginID pluginID) {
		Object[] rInfo = (Object[]) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_GET_PLUGIN_INFO, pluginID.getRawID());
		return new CPPPluginInfo((String) rInfo[0], (String) rInfo[1], (String) rInfo[2], (String) rInfo[3]);
	}
	
	public static boolean isPluginEnabled(CPPPluginID pluginID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_IS_PLUGIN_ENABLED, pluginID.getRawID());
	}
	
	public static boolean enablePlugin(CPPPluginID pluginID) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_ENABLE_PLUGIN, pluginID.getRawID());
	}
	
	public static void disablePlugin(CPPPluginID pluginID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_DISABLE_PLUGIN, pluginID.getRawID());
	}
	
	public static void reloadPlugins() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_RELOAD_PLUGINS);
	}
	
	//public static void sendMessageToPlugin(CPPPluginID pluginID, int message, ??? param) TODO
	
	public static boolean hasFeature(String feature) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_HAS_FEATURE, feature);
	}
	
	public static boolean isFeatureEnabled(String feature) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_IS_FEATURE_ENABLED, feature);
	}
	
	public static boolean enableFeature(String feature, boolean enable) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMPLUGIN_ENABLE_FEATURE, feature, enable);
	}
	
	// public static ??? enumerateFeatures(???) TODO
	
}
