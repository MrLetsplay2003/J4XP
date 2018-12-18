package me.mrletsplay.j4xp.natives.classes;

import java.awt.Point;
import java.awt.geom.Point2D;

import me.mrletsplay.j4xp.natives.NativeFunction;
import me.mrletsplay.j4xp.natives.Point3D;
import me.mrletsplay.j4xp.natives.XPLMFontID;
import me.mrletsplay.j4xp.natives.XPLMTextureID;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

public class XPLMGraphics {
	
	public static void setGraphicsState(int enableFog, int numberTexUnits, int enableLighting, int enableAlphaTesting, int enableAlphaBlending, int enableDepthTesting, int enableDepthWriting) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_SET_GRAPHICS_STATE, enableFog, numberTexUnits, enableLighting, enableAlphaTesting, enableAlphaBlending, enableDepthTesting, enableDepthWriting);
	}
	
	public static void bindTexture2d(int textureNum, int textureUnit) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_BIND_TEXTURE_2D, textureNum, textureUnit);
	}
	
	public static int[] generateTextureNumbers(int count) {
		return (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_MOUSE_LOCATION, count);
	}
	
	public static int getTexture(XPLMTextureID texture) {
		return (int) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_GET_TEXTURE, texture);
	}
	
	public static Point3D worldToLocal(double latitude, double longitude, double altitude) {
		double[] p = (double[]) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_WORLD_TO_LOCAL, new double[] { latitude, longitude, altitude});
		return new Point3D(p[0], p[1], p[2]);
	}
	
	public static Point3D localToWorld(double x, double y, double z) {
		double[] p = (double[]) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_WORLD_TO_LOCAL, new double[] { x, y, z});
		return new Point3D(p[0], p[1], p[2]);
	}
	
	public static void drawTranslucentDarkBox(int left, int top, int right, int bottom) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_DRAW_TRANSLUCENT_DARK_BOX, left, top, right, bottom);
	}
	
	public static void drawString(int colorRGB, int xOffset, int yOffset, String str, int wordWrapWidth, XPLMFontID fontID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_DRAW_STRING, colorRGB, xOffset, yOffset, wordWrapWidth, str, fontID.getRawValue());
	}
	
	public static void drawNumber(int colorRGB, int xOffset, int yOffset, double value, int digits, int decimals, int showSign, XPLMFontID fontID) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_DRAW_NUMBER, colorRGB, xOffset, yOffset, digits, decimals, showSign, value, fontID.getRawValue());
	}
	
	public static Point2D getFontDimensions(XPLMFontID fontID) {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_GET_FONT_DIMENSIONS, fontID.getRawValue());
		return new Point(p[0], p[1]);
	}
	
	public static float measureString(XPLMFontID fontID, String str, int numChars) {
		return (float) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_MEASURE_STRING, fontID.getRawValue(), str, numChars);
	}
	
}
