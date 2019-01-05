package me.mrletsplay.j4xp.entity.data;

import me.mrletsplay.j4xp.natives.classes.XPLMDataRef;
import me.mrletsplay.j4xp.natives.enums.XPLMDataTypeID;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDataAccess;

public class DataRef {
	
	private XPLMDataRef rawRef;
	
	private DataRef(XPLMDataRef rawRef) {
		this.rawRef = rawRef;
	}

	public XPLMDataRef getRawRef() {
		return rawRef;
	}
	
	public boolean isWritable() {
		return XPLMDataAccess.canWriteDataRef(getRawRef());
	}
	
	public boolean supports(XPLMDataTypeID... types) {
		return XPLMDataAccess.getDataRefTypes(getRawRef()).hasFlags(types);
	}
	
	public int readInt() {
		return XPLMDataAccess.getDataI(getRawRef());
	}
	
	public void writeInt(int value) {
		XPLMDataAccess.setDataI(getRawRef(), value);
	}
	
	public float readFloat() {
		return XPLMDataAccess.getDataF(getRawRef());
	}
	
	public void writeFloat(float value) {
		XPLMDataAccess.setDataF(getRawRef(), value);
	}
	
	public double readDouble() {
		return XPLMDataAccess.getDataD(getRawRef());
	}
	
	public void writeDouble(double value) {
		XPLMDataAccess.setDataD(getRawRef(), value);
	}
	
	public int[] readIntArray(int offset, int max) {
		return XPLMDataAccess.getDataVI(getRawRef(), offset, max);
	}
	
	public void writeIntArray(int[] values, int offset, int max) {
		XPLMDataAccess.setDataVI(getRawRef(), values, offset, max);
	}
	
	public float[] readFloatArray(int offset, int max) {
		return XPLMDataAccess.getDataVF(getRawRef(), offset, max);
	}
	
	public void writeFloatArray(float[] values, int offset, int max) {
		XPLMDataAccess.setDataVF(getRawRef(), values, offset, max);
	}
	
	public byte[] readData(int offset, int max) {
		return XPLMDataAccess.getDataB(getRawRef(), offset, max);
	}
	
	public void writeData(byte[] values, int offset, int max) {
		XPLMDataAccess.setDataB(getRawRef(), values, offset, max);
	}
	
	public static DataRef find(String name) {
		return new DataRef(XPLMDataAccess.findDataRef(name));
	}
	
	public static DataRef of(XPLMDataRef rawRef) {
		return new DataRef(rawRef);
	}
	
}
