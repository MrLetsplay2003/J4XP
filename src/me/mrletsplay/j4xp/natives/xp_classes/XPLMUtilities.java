package me.mrletsplay.j4xp.natives.xp_classes;

import me.mrletsplay.j4xp.natives.XPNativeInterface;
import me.mrletsplay.j4xp.natives.classes.XPLMCommandRef;
import me.mrletsplay.j4xp.natives.classes.XPLMVersions;
import me.mrletsplay.j4xp.natives.enums.NativeFunction;
import me.mrletsplay.j4xp.natives.enums.XPLMCommandButtonID;
import me.mrletsplay.j4xp.natives.enums.XPLMCommandKeyID;
import me.mrletsplay.j4xp.natives.enums.XPLMDataFileType;
import me.mrletsplay.j4xp.natives.enums.XPLMHostApplicationID;
import me.mrletsplay.j4xp.natives.enums.XPLMLanguageCode;
import me.mrletsplay.j4xp.natives.interfaces.XPLMCommandCallback;
import me.mrletsplay.j4xp.natives.interfaces.XPLMError;

public class XPLMUtilities {
	
	public static void speakString(String string) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_SPEAK_STRING, string);
	}
	
	public static void commandKeyStroke(XPLMCommandKeyID key) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_KEY_STROKE, key.getRawValue());
	}
	
	public static void commandButtonPress(XPLMCommandButtonID  button) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_BUTTON_PRESS, button);
	}
	
	public static void commandButtonRelease(XPLMCommandButtonID  button) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_BUTTON_RELEASE, button);
	}
	
	public static String getVirtualKeyDescription(char virtualKey) {
		return (String) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_VIRTUAL_KEY_DESCRIPTION, virtualKey);
	}
	
	public static void reloadScenery() {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_RELOAD_SCENERY);
	}
	
	public static void getSystemPath(String systemPath) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_SYSTEM_PATH, systemPath);
	}
	
	public static void getPrefsPath(String prefsPath) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_PREFS_PATH, prefsPath);
	}
	
	public static String getDirectorySeparator() {
		return (String) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_DIRECTORY_SEPARATOR);
	}
	
	public static String extractFileAndPath(String fullPath) {
		return (String) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_EXTRACT_FILE_AND_PATH, fullPath);
	}
	
	//TODO: GetDirectoryContents
	
	public static boolean initialized() {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_INITIALIZED);
	}
	
	public static XPLMVersions getVersions(XPLMHostApplicationID hostID) {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_VERSIONS, hostID);
		return new XPLMVersions(p[0], p[1]);
	}
	
	public static XPLMLanguageCode getLanguage() {
		return (XPLMLanguageCode) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_GET_LANGUAGE);
	}
	
	public static void debugString(String string) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_DEBUG_STRING, string);
	}
	
	public static void setErrorCallback(XPLMError callback) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_SET_ERROR_CALLBACK, callback);
	}
	
	public static void findSymbol(String string) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_FIND_SYMBOL, string);
	}
	
	public static boolean loadDataFile(XPLMDataFileType fileType, String filePath) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_LOAD_DATA_FILE, fileType.getRawValue(), filePath);
	}
	
	public static boolean saveDataFile(XPLMDataFileType fileType, String filePath) {
		return (boolean) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_SAVE_DATA_FILE, fileType.getRawValue(), filePath);
	}
	
	public static XPLMCommandRef findCommand(String name) {
		return (XPLMCommandRef) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_FIND_COMMAND, name);
	}
	
	public static void commandBegin(XPLMCommandRef command) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_BEGIN, command);
	}
	
	public static void commandEnd(XPLMCommandRef command) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_END, command);
	}
	
	public static void commandOnce(XPLMCommandRef command) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_COMMAND_ONCE, command);
	}
	
	public static XPLMCommandRef createCommand(String name, String description) {
		return (XPLMCommandRef) XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_CREATE_COMMAND, name, description);
	}
	
	public static void registerCommandHandler(XPLMCommandRef command, XPLMCommandCallback handler, boolean before, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_REGISTER_COMMAND_HANDLER , command.getRawID(), handler, before, refcon);
	}
	
	public static void unregisterCommandHandler(XPLMCommandRef command, XPLMCommandCallback handler, boolean before, Object refcon) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMUTILITIES_UNREGISTER_COMMAND_HANDLER , command.getRawID(), handler, before, refcon);
	}

}
