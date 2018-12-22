package me.mrletsplay.j4xp.natives;

public class XPLMCreateMapLayer {

	private int structSize;
	private String mapToCreateLayerIn;
	private XPLMMapLayerType layerType;
	private XPLMMapWillBeDeletedCallback willBeDeletedCallback;
	private XPLMMapPrepareCacheCallback prepCacheCallback;
	private XPLMMapDrawingCallback drawCallback;
	private XPLMMapIconDrawingCallback iconCallback;
	private XPLMMapLabelDrawingCallback labelCallback;
	private int showUiToggle;
	private String layerName;
	private Object refcon;
	
	public XPLMCreateMapLayer(int structSize, String mapToCreateLayerIn, XPLMMapLayerType layerType, XPLMMapWillBeDeletedCallback willBeDeletedCallback, XPLMMapPrepareCacheCallback prepCacheCallback, XPLMMapDrawingCallback drawCallback, XPLMMapIconDrawingCallback iconCallback, XPLMMapLabelDrawingCallback labelCallback, int showUiToggle, String layerName, Object refcon) {
		this.structSize = structSize;
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
	
	public int getStructSize() {
		return structSize;
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

	public int getShowUiToggle() {
		return showUiToggle;
	}
	
	public String getLayerName() {
		return layerName;
	}
	
	public Object getRefcon() {
		return refcon;
	}
	
}
