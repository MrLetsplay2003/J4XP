package me.mrletsplay.j4xp.natives;

public class XPLMDataAccessor {

	private XPLMGetData<Integer> readInt;
	private XPLMSetData<Integer> writeInt;
	private XPLMGetData<Float> readFloat;
	private XPLMSetData<Float> writeFloat;
	private XPLMGetData<Double> readDouble;
	private XPLMSetData<Double> writeDouble;
	private XPLMSetDataV<int[]> writeIntArray;
	private XPLMGetDataV<int[]> readIntArray;
	private XPLMSetDataV<float[]> writeFloatArray;
	private XPLMGetDataV<float[]> readFloatArray;
	private XPLMSetDataV<byte[]> writeData;
	private XPLMGetDataV<byte[]> readData;
	private Object readRefcon, writeRefcon;
	
	public XPLMDataAccessor(
			XPLMGetData<Integer> readInt, XPLMSetData<Integer> writeInt,
			XPLMGetData<Float> readFloat, XPLMSetData<Float> writeFloat,
			XPLMGetData<Double> readDouble, XPLMSetData<Double> writeDouble,
			XPLMGetDataV<int[]> readIntArray, XPLMSetDataV<int[]> writeIntArray,
			XPLMGetDataV<float[]> readFloatArray, XPLMSetDataV<float[]> writeFloatArray,
			XPLMGetDataV<byte[]> readData, XPLMSetDataV<byte[]> writeData,
			Object readRefcon, Object writeRefcon
			) {
		this.readInt = readInt;
		this.writeInt = writeInt;
		this.readFloat = readFloat;
		this.writeFloat = writeFloat;
		this.readDouble = readDouble;
		this.writeDouble = writeDouble;
		this.readIntArray = readIntArray;
		this.writeIntArray = writeIntArray;
		this.readFloatArray  = readFloatArray;
		this.writeFloatArray = writeFloatArray;
		this.readData = readData;
		this.writeData = writeData;
		this.readRefcon = readRefcon;
		this.writeRefcon = writeRefcon;
	}
	
	public XPLMGetData<Integer> getReadInt() {
		return readInt;
	}
	
	public XPLMSetData<Integer> getWriteInt() {
		return writeInt;
	}
	
	public XPLMGetData<Float> getReadFloat() {
		return readFloat;
	}
	
	public XPLMSetData<Float> getWriteFloat() {
		return writeFloat;
	}
	
	public XPLMGetData<Double> getReadDouble() {
		return readDouble;
	}
	
	public XPLMSetData<Double> getWriteDouble() {
		return writeDouble;
	}
	
	public XPLMGetDataV<int[]> getReadIntArray() {
		return readIntArray;
	}
	
	public XPLMSetDataV<int[]> getWriteIntArray() {
		return writeIntArray;
	}
	
	public XPLMGetDataV<float[]> getReadFloatArray() {
		return readFloatArray;
	}
	
	public XPLMSetDataV<float[]> getWriteFloatArray() {
		return writeFloatArray;
	}
	
	public XPLMGetDataV<byte[]> getReadData() {
		return readData;
	}
	
	public XPLMSetDataV<byte[]> getWriteData() {
		return writeData;
	}
	
	public Object getReadRefcon() {
		return readRefcon;
	}
	
	public Object getWriteRefcon() {
		return writeRefcon;
	}
	
}
