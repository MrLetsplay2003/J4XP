package me.mrletsplay.j4xp.natives.classes;

import me.mrletsplay.j4xp.natives.interfaces.GetData;
import me.mrletsplay.j4xp.natives.interfaces.GetDataV;
import me.mrletsplay.j4xp.natives.interfaces.SetData;
import me.mrletsplay.j4xp.natives.interfaces.SetDataV;

public class XPLMDataAccessor {

	private GetData<Integer> readInt;
	private SetData<Integer> writeInt;
	private GetData<Float> readFloat;
	private SetData<Float> writeFloat;
	private GetData<Double> readDouble;
	private SetData<Double> writeDouble;
	private SetDataV<int[]> writeIntArray;
	private GetDataV<int[]> readIntArray;
	private SetDataV<float[]> writeFloatArray;
	private GetDataV<float[]> readFloatArray;
	private SetDataV<byte[]> writeData;
	private GetDataV<byte[]> readData;
	private Object readRefcon, writeRefcon;
	
	public XPLMDataAccessor(
			GetData<Integer> readInt, SetData<Integer> writeInt,
			GetData<Float> readFloat, SetData<Float> writeFloat,
			GetData<Double> readDouble, SetData<Double> writeDouble,
			GetDataV<int[]> readIntArray, SetDataV<int[]> writeIntArray,
			GetDataV<float[]> readFloatArray, SetDataV<float[]> writeFloatArray,
			GetDataV<byte[]> readData, SetDataV<byte[]> writeData,
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
	
	public GetData<Integer> getReadInt() {
		return readInt;
	}
	
	public SetData<Integer> getWriteInt() {
		return writeInt;
	}
	
	public GetData<Float> getReadFloat() {
		return readFloat;
	}
	
	public SetData<Float> getWriteFloat() {
		return writeFloat;
	}
	
	public GetData<Double> getReadDouble() {
		return readDouble;
	}
	
	public SetData<Double> getWriteDouble() {
		return writeDouble;
	}
	
	public GetDataV<int[]> getReadIntArray() {
		return readIntArray;
	}
	
	public SetDataV<int[]> getWriteIntArray() {
		return writeIntArray;
	}
	
	public GetDataV<float[]> getReadFloatArray() {
		return readFloatArray;
	}
	
	public SetDataV<float[]> getWriteFloatArray() {
		return writeFloatArray;
	}
	
	public GetDataV<byte[]> getReadData() {
		return readData;
	}
	
	public SetDataV<byte[]> getWriteData() {
		return writeData;
	}
	
	public Object getReadRefcon() {
		return readRefcon;
	}
	
	public Object getWriteRefcon() {
		return writeRefcon;
	}
	
}
