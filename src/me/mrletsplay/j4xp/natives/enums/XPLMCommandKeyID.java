package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMCommandKeyID {
	
	PAUSE(0),
	REVTHRUST(1),
	JETTISON(2),
	BRAKESREG(3),
	BRAKESMAX(4),
	GEAR(5),
	TIME_DOWN(6),
	TIME_UP(7),
	FADEC(8),
	OTTO_DIS(9),
	OTTO_ATR(10),
	OTTO_ASI(11),
	OTTO_HDG(12),
	OTTO_GPS(13),
	OTTO_LEV(14),
	OTTO_HNAV(15),
	OTTO_ALT(16),
	OTTO_VVI(17),
	OTTO_VNAV(18),
	OTTO_NAV1(19),
	OTTO_NAV2(20),
	TARG_DOWN(21),
	TARG_UP(22),
	HDG_DOWN(23),
	HDG_UP(24),
	BARO_DOWN(25),
	BARO_UP(26),
	OBS_1_DOWN(27),
	OBS_1_UP(28),
	OBS_2_DOWN(29),
	OBS_2_UP(30),
	COM1_1(31),
	COM1_2(32),
	COM1_3(33),
	COM1_4(34),
	NAV1_1(35),
	NAV1_2(36),
	NAV1_3(37),
	NAV1_4(38),
	COM2_1(39),
	COM2_2(40),
	COM2_3(41),
	COM2_4(42),
	NAV2_1(43),
	NAV2_2(44),
	NAV2_3(45),
	NAV2_4(46),
	ADF_1(47),
	ADF_2(48),
	ADF_3(49),
	ADF_4(50),
	ADF_5(51),
	ADF_6(52),
	TRANSPON_1(53),
	TRANSPON_2(54),
	TRANSPON_3(55),
	TRANSPON_4(56),
	TRANSPON_5(57),
	TRANSPON_6(58),
	TRANSPON_7(59),
	TRANSPON_8(60),
	FLAPS_UP(61),
	FLAPS_DOWN(62),
	CHEAT_OFF(63),
	CHEAT_ON(64),
	SBRK_OFF(65),
	SBRK_ON(66),
	AILTRIM_LEFT(67),
	AILTRIM_RIGHT(68),
	RUDTRIM_LEFT(69),
	RUDTRIM_RIGHT(70),
	ELVTRIM_DOWN(71),
	ELVTRIM_UP(72),
	FORWARD(73),
	DOWN(74),
	LEFT(75),
	RIGHT(76),
	BACK(77),
	TOWER(78),
	RUNWAY(79),
	CHASE(80),
	FREE_1(81),
	FREE_2(82),
	SPOT(83),
	FULLSCREEN_1(84),
	FULLSCREEN_2(85),
	TANSPAN(86),
	SMOKE(87),
	MAP(88),
	ZOOM_IN(89),
	ZOOM_OUT(90),
	CYCLE_DUMP(91),
	REPLAY(92),
	TRAN_ID(93),
	MAX(94),
	;
	
	private final int rawValue;
	
	private XPLMCommandKeyID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMCommandKeyID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
	
}
