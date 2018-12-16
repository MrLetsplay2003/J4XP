package me.mrletsplay.j4xp.natives.classes;

import java.awt.Point;
import java.awt.geom.Point2D;

import me.mrletsplay.j4xp.natives.NativeFunction;
//import me.mrletsplay.j4xp.natives.XPLMTexureID;
import me.mrletsplay.j4xp.natives.XPNativeInterface;

public class XPLMGraphics {
	
	public static void setGraphicsState(int enableFog, int numberTexUnits, int enableLighting, int enableAlphaTesting, int enableAlphaBlending, int enableDepthTesting, int enableDepthWriting) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_SET_GRAPHICS_STATE, new int[] {enableFog, numberTexUnits, enableLighting, enableAlphaTesting, enableAlphaBlending, enableDepthTesting, enableDepthWriting});
	}
	
	public static void bindTexture2d(int textureNum, int textureUnit) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_BIND_TEXTURE_2D, new int[] {textureNum, textureUnit});
	}
	
	public static Point2D generateTextureNumbers(int count) {
		int[] p = (int[]) XPNativeInterface.executeFunction(NativeFunction.XPLMDISPLAY_GET_MOUSE_LOCATION, count);
		return new Point(p[0],p[1]);//TODO: ICH GLAUBE NICHT, DASS DAS SO STIMMT!!!!
	}
	
/*	public static int getTexture(XPLMTexureID texture) {
		
	}*/
	
/*	public static Point2D worldToLocal(double latitude, double longitude, double altitude) {
		double[] p = (double[]) XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_WORLD_TO_LOCAL, new double[] { latitude, longitude, altitude});
		return new Point(p[0], p[1], p[2]);
	}*/
	
	//TODO LOCALTOWORLD
	
	public static void drawTranslucentDarkBox(int left, int top, int right, int bottom) {
		XPNativeInterface.executeFunction(NativeFunction.XPLMGRAPHICS_DRAW_TRANSLUCENT_DARK_BOX, new int[] { left, top, right, bottom});
	}
	
	//TODO DrawString
	
	//TODO DrawNumber
	
	//TODO GetFontDimensions
	
	//TODO MeasureString
	
}
