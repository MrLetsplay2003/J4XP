package me.mrletsplay.j4xp.natives.enums;

import java.util.Arrays;

public enum XPLMCommandButtonID {
	NOTHING(0),
	START_ALL(1),
	START_1(2),
	START_2(3),
	START_3(4),
	START_4(5),
	START_5(6),
	START_6(7),
	START_7(8),
	THROT_UP(9),
	THROT_DOWN(10),
	PROP_UP(11),
	PROP_DOWN(12),
	MIXT_UP(13),
	MIXT_DOWN(14),
	CARB_TOGGLE(15),
	CARB_ON(16),
	CARB_OFF(17),
	TREV(18),
	TRM_UP(19),
	TRM_DOWN(20),
	ROT_TRM_UP(21),
	ROT_TRM_DOWN(22),
	RUD_LEFT(23),
	RUD_CENTER(24),
	RUD_RIGHT(25),
	AIL_LEFT(26),
	AIL_CENTER(27),
	AIL_RIGHT(28),
	B_RUD_LEFT(29),
	B_RUD_RIGHT(30),
	LOOK_UP(31),
	LOOK_DOWN(32),
	LOOK_LEFT(33),
	LOOK_RIGHT(34),
	GLANCE_LEFT(35),
	GLANCE_RIGHT(36),
	V_FNH(37),
	V_FWH(38),
	V_TRA(39),
	V_TWR(40),
	V_RUN(41),
	V_CHA(42),
	V_FR_1(43),
	V_FR_2(44),
	V_SPO(45),
	FLAPS_UP(46),
	FLAPS_DOWN(47),
	VCTSWPFWD(48),
	VCTSWPAFT(49),
	GEAR_TOGGLE(50),
	GEAR_UP(51),
	GEAR_DOWN(52),
	LEFT_BRAKE(53),
	RIGHT_BRAKE(54),
	BRAKES_REG(55),
	BRAKES_MAX(56),
	SPEED_BRAKE(57),
	OTT_DIS(58),
	OTT_ATR(59),
	OTT_ASI(60),
	OTT_HDG(61),
	OTT_ALT(62),
	OTT_VVI(63),
	TIM_START(64),
	TIM_RESET(65),
	ECAM_UP(66),
	ECAM_DOWN(67),
	FADEC(68),
	YAW_DAMP(69),
	ART_STAB(70),
	CHUTE(71),
	JATO(72),
	ARREST(73),
	JETTISON(74),
	FUEL_DUMP(75),
	PUFF_SMOKE(76),
	PREROTATE(77),
	UL_PREROT(78),
	UL_COLLEC(79),
	TOGA(80),
	SHUTDOWN(81),
	CON_ATC(82),
	FAIL_NOW(83),
	PAUSE(84),
	ROCK_UP(85),
	ROCK_DOWN(86),
	ROCK_LEFT(87),
	ROCK_RIGHT(88),
	ROCK_RGT(89),
	ROCK_FOR(90),
	ROCK_AFT(91),
	IDLE_HILO(82),
	LAN_LIGHTS(83),
	MAX(84),
	;
	
	private final int rawValue;
	
	private XPLMCommandButtonID(int rawValue) {
		this.rawValue = rawValue;
	}
	
	public int getRawValue() {
		return rawValue;
	}
	
	public static XPLMCommandButtonID byValue(int rawValue) {
		return Arrays.stream(values()).filter(b -> b.rawValue == rawValue).findFirst().orElse(null);
	}
}
