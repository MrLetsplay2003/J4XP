package me.mrletsplay.j4xp.entity.data;

import me.mrletsplay.j4xp.entity.Builder;
import me.mrletsplay.j4xp.natives.classes.XPLMDataAccessor;
import me.mrletsplay.j4xp.natives.classes.XPLMDataRef;
import me.mrletsplay.j4xp.natives.enums.XPLMDataTypeID;
import me.mrletsplay.j4xp.natives.interfaces.GetData;
import me.mrletsplay.j4xp.natives.interfaces.GetDataV;
import me.mrletsplay.j4xp.natives.interfaces.SetData;
import me.mrletsplay.j4xp.natives.interfaces.SetDataV;
import me.mrletsplay.j4xp.natives.xp_classes.XPLMDataAccess;
import me.mrletsplay.mrcore.misc.EnumFlagCompound;
import me.mrletsplay.mrcore.misc.FlagCompound;

public class DataAccessorBuilder implements Builder<DataRef, DataAccessorBuilder> {

	private String name;
	private EnumFlagCompound<XPLMDataTypeID> types;
	private boolean writable;
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
	private Object writeRefcon, readRefcon;
	
	public DataAccessorBuilder(String name) {
		this.name = name;
		this.types = EnumFlagCompound.noneOf(XPLMDataTypeID.class);
		this.writable = false;
	}
	
	public DataAccessorBuilder withWritableStatus(boolean writable) {
		this.writable = writable;
		return this;
	}
	
	public DataAccessorBuilder withAllowedTypes(XPLMDataTypeID... types) {
		this.types.addFlags(new FlagCompound(types));
		return this;
	}
	
	public DataAccessorBuilder withIntAccessor(GetData<Integer> readInt, SetData<Integer> writeInt) {
		this.readInt = readInt;
		this.writeInt = writeInt;
		return this;
	}
	
	public DataAccessorBuilder withFloatAccessor(GetData<Float> readFloat, SetData<Float> writeFloat) {
		this.readFloat = readFloat;
		this.writeFloat = writeFloat;
		return this;
	}
	
	public DataAccessorBuilder withDoubleAccessor(GetData<Double> readDouble, SetData<Double> writeDouble) {
		this.readDouble = readDouble;
		this.writeDouble = writeDouble;
		return this;
	}
	
	public DataAccessorBuilder withIntArrayAccessor(GetDataV<int[]> readIntArray, SetDataV<int[]> writeIntArray) {
		this.readIntArray = readIntArray;
		this.writeIntArray = writeIntArray;
		return this;
	}
	
	public DataAccessorBuilder withFloatArrayAccessor(GetDataV<float[]> readFloatArray, SetDataV<float[]> writeFloatArray) {
		this.readFloatArray = readFloatArray;
		this.writeFloatArray = writeFloatArray;
		return this;
	}
	
	public DataAccessorBuilder withRawAccessor(GetDataV<byte[]> readData, SetDataV<byte[]> writeData) {
		this.readData = readData;
		this.writeData = writeData;
		return this;
	}
	
	public DataAccessorBuilder withRefcons(Object readRefcon, Object writeRefcon) {
		this.readRefcon = readRefcon;
		this.writeRefcon = writeRefcon;
		return this;
	}
	
	@Override
	public DataRef create() throws IllegalStateException {
		for(XPLMDataTypeID t : types.getApplicable()) {
			Object r, w;
			switch(t) {
				case DATA:
					r = readData;
					w = writeData;
					break;
				case DOUBLE:
					r = readDouble;
					w = writeDouble;
					break;
				case FLOAT:
					r = readFloat;
					w = writeFloat;
					break;
				case FLOAT_ARRAY:
					r = readFloatArray;
					w = writeFloatArray;
					break;
				case INT:
					r = readInt;
					w = writeInt;
					break;
				case INT_ARRAY:
					r = readIntArray;
					w = writeIntArray;
					break;
				default:
					throw new IllegalStateException("Invalid type: " + t);
			}
			if(r == null) throw new IllegalStateException("No read function provided for type " + t);
			if(writable) if(w == null) throw new IllegalStateException("No write function provided for type " + t);
		}
		XPLMDataAccessor acc = new XPLMDataAccessor(readInt, writeInt, readFloat, writeFloat, readDouble, writeDouble, readIntArray, writeIntArray, readFloatArray, writeFloatArray, readData, writeData, readRefcon, writeRefcon);
		XPLMDataRef ref = XPLMDataAccess.registerDataAccessor(name, types, writable, acc);
		return DataRef.of(ref);
	}

}
