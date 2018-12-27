package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.enums.XPLMMapLayerType;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapDrawingCallback;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapIconDrawingCallback;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapLabelDrawingCallback;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapPrepareCacheCallback;
import me.mrletsplay.j4xp.natives.interfaces.XPLMMapWillBeDeletedCallback;

public class XPLMCreateMapLayer {

	private String mapToCreateLayerIn;
	private XPLMMapLayerType layerType;
	private XPLMMapWillBeDeletedCallback willBeDeletedCallback;
	private XPLMMapPrepareCacheCallback prepCacheCallback;
	private XPLMMapDrawingCallback drawCallback;
	private XPLMMapIconDrawingCallback iconCallback;
	private XPLMMapLabelDrawingCallback labelCallback;
	private boolean showUiToggle;
	private String layerName;
	private Object refcon;
	
	public XPLMCreateMapLayer(String mapToCreateLayerIn, XPLMMapLayerType layerType, XPLMMapWillBeDeletedCallback willBeDeletedCallback, XPLMMapPrepareCacheCallback prepCacheCallback, XPLMMapDrawingCallback drawCallback, XPLMMapIconDrawingCallback iconCallback, XPLMMapLabelDrawingCallback labelCallback, boolean showUiToggle, String layerName, Object refcon) {
		this.mapToCreateLayerIn = mapToCreateLayerIn;
		this.layerName = layerName;
		this.willBeDeletedCallback = willBeDeletedCallback;
		this.prepCacheCallback = prepCacheCallback;
		this.drawCallback = drawCallback;
		this.iconCallback = iconCallback;
		this.labelCallback = labelCallback;
		this.showUiToggle = showUiToggle;
		this.layerName = layerName;
		this.refcon = refcon;
	}
	
	public String getMapToCreateLayerIn() {
		return mapToCreateLayerIn;
	}
	
	public XPLMMapLayerType getLayerType() {
		return layerType;
	}
	
	public XPLMMapWillBeDeletedCallback getWillBeDeletedCallback() {
		return willBeDeletedCallback;
	}
	
	public XPLMMapPrepareCacheCallback getPrepCacheCallback() {
		return prepCacheCallback;
	}
	
	public XPLMMapDrawingCallback getDrawCallback() {
		return drawCallback;
	}
	
	public XPLMMapIconDrawingCallback getIconCallback() {
		return iconCallback;
	}
	
	public XPLMMapLabelDrawingCallback getLabelCallback() {
		return labelCallback;
	}

	public boolean getShowUiToggle() {
		return showUiToggle;
	}
	
	public String getLayerName() {
		return layerName;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
}
