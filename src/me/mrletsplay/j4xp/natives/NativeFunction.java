package me.mrletsplay.j4xp.natives;

public enum NativeFunction {

	XPLMPLUGIN_GET_MY_ID(0),
	XPLMPLUGIN_COUNT_PLUGINS(1),
	XPLMPLUGIN_GET_NTH_PLUGIN(2),
	XPLMPLUGIN_FIND_PLUGIN_BY_PATH(3),
	XPLMPLUGIN_FIND_PLUGIN_BY_SIGNATURE(4),
	XPLMPLUGIN_GET_PLUGIN_INFO(5),
	XPLMPLUGIN_IS_PLUGIN_ENABLED(6),
	XPLMPLUGIN_ENABLE_PLUGIN(7),
	XPLMPLUGIN_DISABLE_PLUGIN(8),
	XPLMPLUGIN_RELOAD_PLUGINS(9),
	XPLMPLUGIN_SEND_MESSAGE_TO_PLUGIN(10),
	XPLMPLUGIN_HAS_FEATURE(11),
	XPLMPLUGIN_IS_FEATURE_ENABLED(12),
	XPLMPLUGIN_ENABLE_FEATURE(13),
	XPLMPLUGIN_ENUMERATE_FEATURES(14),
	
	XPWIDGETS_CREATE_WIDGET(15),
	XPWIDGETS_CREATE_CUSTOM_WIDGET(16),
	XPWIDGETS_DESTROY_WIDGET(17),
	XPWIDGETS_SEND_MESSAGE_TO_WIDGET(18),
	XPWIDGETS_PLACE_WIDGET_WITHIN(19),
	XPWIDGETS_COUNT_CHILD_WIDGETS(20),
	XPWIDGETS_GET_NTH_CHILD_WIDGET(21),
	XPWIDGETS_GET_PARENT_WIDGET(22),
	XPWIDGETS_SHOW_WIDGET(23),
	XPWIDGETS_HIDE_WIDGET(24),
	XPWIDGETS_IS_WIDGET_VISIBLE(25),
	XPWIDGETS_FIND_ROOT_WIDGET(26),
	XPWIDGETS_BRING_ROOT_WIDGET_TO_FRONT(27),
	XPWIDGETS_IS_WIDGET_IN_FRONT(28),
	XPWIDGETS_GET_WIDGET_GEOMETRY(29),
	XPWIDGETS_SET_WIDGET_GEOMETRY(30),
	XPWIDGETS_GET_WIDGET_FOR_LOCATION(31),
	XPWIDGETS_GET_WIDGET_EXPOSED_GEOMETRY(32),
	XPWIDGETS_SET_WIDGET_DESCRIPTOR(33),
	XPWIDGETS_GET_WIDGET_DESCRIPTOR(34),
	XPWIDGETS_GET_WIDGET_UNDERLYING_WINDOW(35),
	XPWIDGETS_SET_WIDGET_PROPERTY(36),
	XPWIDGETS_GET_WIDGET_PROPERTY(37),
	XPWIDGETS_SET_KEYBOARD_FOCUS(38),
	XPWIDGETS_LOSE_KEYBOARD_FOCUS(39),
	XPWIDGETS_GET_WIDGET_WITH_FOCUS(40),
	XPWIDGETS_ADD_WIDGET_CALLBACK(41),
	XPWIDGETS_GET_WIDGET_CLASS_FUNC(42),
	
	XPMENUS_
	;
	
	private final int id;
	
	private NativeFunction(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
}
