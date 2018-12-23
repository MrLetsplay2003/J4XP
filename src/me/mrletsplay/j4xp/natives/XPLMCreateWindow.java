package me.mrletsplay.j4xp.natives;

public class XPLMCreateWindow {

	private int left, top, right, bottom;
	private boolean visible;
	private XPLMDrawWindow drawFunction;
	private XPLMHandleMouseClick handleMouseClickFunction;
	private XPLMHandleKey handleKeyFunction;
	private XPLMHandleCursor handleCursorFunction;
	private XPLMHandleMouseWheel handleMouseWheelFunction;
	private Object refcon;
	private XPLMWindowDecoration decorateAsFloatingWindow;
	private XPLMWindowLayer layer;
	private XPLMHandleMouseClick handleRightClickFunction;
	
	public XPLMCreateWindow(int left, int top, int right, int bottom, boolean visible, XPLMDrawWindow drawFunction, XPLMHandleMouseClick handleMouseClickFunction, XPLMHandleKey handleKeyFunction, XPLMHandleCursor handleCursorFunction, XPLMHandleMouseWheel handleMouseWheelFunction, Object refcon, XPLMWindowDecoration decorateAsFloatingWindow, XPLMWindowLayer layer, XPLMHandleMouseClick handleRightClickFunction) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.visible = visible;
		this.drawFunction = drawFunction;
		this.handleMouseClickFunction = handleMouseClickFunction;
		this.handleKeyFunction = handleKeyFunction;
		this.handleCursorFunction = handleCursorFunction;
		this.handleMouseWheelFunction = handleMouseWheelFunction;
		this.refcon = refcon;
		this.decorateAsFloatingWindow = decorateAsFloatingWindow;
		this.layer = layer;
		this.handleRightClickFunction = handleRightClickFunction;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getLeft() {
		return left;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
	
	public int getTop() {
		return top;
	}
	
	public void setRight(int right) {
		this.right = right;
	}
	
	public int getRight() {
		return right;
	}
	
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	
	public int getBottom() {
		return bottom;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setDrawFunction(XPLMDrawWindow drawFunction) {
		this.drawFunction = drawFunction;
	}
	
	public XPLMDrawWindow getDrawFunction() {
		return drawFunction;
	}
	
	public void setHandleMouseClickFunction(XPLMHandleMouseClick handleMouseClickFunction) {
		this.handleMouseClickFunction = handleMouseClickFunction;
	}
	
	public XPLMHandleMouseClick getHandleMouseClickFunction() {
		return handleMouseClickFunction;
	}
	
	public void setHandleKeyFunction(XPLMHandleKey handleKeyFunction) {
		this.handleKeyFunction = handleKeyFunction;
	}
	
	public XPLMHandleKey getHandleKeyFunction() {
		return handleKeyFunction;
	}
	
	public void setHandleCursorFunction(XPLMHandleCursor handleCursorFunction) {
		this.handleCursorFunction = handleCursorFunction;
	}
	
	public XPLMHandleCursor getHandleCursorFunction() {
		return handleCursorFunction;
	}
	
	public void setHandleMouseWheelFunction(XPLMHandleMouseWheel handleMouseWheelFunction) {
		this.handleMouseWheelFunction = handleMouseWheelFunction;
	}
	
	public XPLMHandleMouseWheel getHandleMouseWheelFunction() {
		return handleMouseWheelFunction;
	}
	
	public void setRefcon(Object refcon) {
		this.refcon = refcon;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
	public void setDecorateAsFloatingWindow(XPLMWindowDecoration decorateAsFloatingWindow) {
		this.decorateAsFloatingWindow = decorateAsFloatingWindow;
	}
	
	public XPLMWindowDecoration getDecorateAsFloatingWindow() {
		return decorateAsFloatingWindow;
	}
	
	public void setLayer(XPLMWindowLayer layer) {
		this.layer = layer;
	}
	
	public XPLMWindowLayer getLayer() {
		return layer;
	}
	
	public void setHandleRightClickFunction(XPLMHandleMouseClick handleRightClickFunction) {
		this.handleRightClickFunction = handleRightClickFunction;
	}
	
	public XPLMHandleMouseClick getHandleRightClickFunction() {
		return handleRightClickFunction;
	}
	
}
