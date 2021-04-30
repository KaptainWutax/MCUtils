package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NBTCompound extends NBTTag<Map<String, NBTTag<?>>> {

	public static final NBTCompound NULL = new NBTCompound() {
		@Override
		public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }

		@Override
		public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
	};

	public NBTCompound() {
		this(HashMap::new);
	}

	public NBTCompound(Supplier<Map<String, NBTTag<?>>> supplier) {
		super(supplier.get());
	}

	@Override
	public void readPayload(ByteBuffer buffer) throws IOException {
		for (this.getValue().clear(); ; ) {
			NBTTag<?> nbt = NBTTag.create(buffer);
			if (nbt instanceof NBTEnd) break;
			this.getValue().put(nbt.getName(), nbt);
		}
	}

	@Override
	public void writePayload(ByteBuffer buffer) throws IOException {
		for (Map.Entry<String, NBTTag<?>> entry : this.getValue().entrySet()) {
			String name = entry.getKey();
			NBTTag<?> tag = entry.getValue();
			tag.writePayload(buffer.writeByte(tag.getType()).writeASCII(name, ByteOrder.BIG_ENDIAN));
		}

		NBTEnd.INSTANCE.write(buffer);
	}

	public NBTCompound run(Consumer<NBTCompound> action) {
		action.accept(this);
		return this;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int size() {
		return this.getValue().size();
	}

	public boolean contains(String key) {
		return this.getValue().containsKey(key);
	}

	public boolean contains(String key, int type) {
		NBTTag<?> tag = this.getTag(key);
		return tag != null && tag.getType() == type;
	}

	//====================================================================================================//

	public NBTTag<?> getTag(String key) {
		return this.getValue().get(key);
	}

	public NBTTag<?> getTagOrDefault(String key, NBTTag<?> defaultValue) {
		return this.getValue().getOrDefault(key, defaultValue);
	}

	public NBTCompound putTag(String key, NBTTag<?> value) {
		if (value.getType() < 0) throw new RuntimeException("Serializing unregistered tag " + this.getClass());
		else if (value.getType() == NBTType.END) throw new RuntimeException("Cannot write END tag to compound");
		this.getValue().put(key, value);
		return this;
	}

	//====================================================================================================//

	public boolean getBoolean(String key) {
		return this.getBooleanOrDefault(key, false);
	}

	public boolean getBooleanOrDefault(String key, boolean defaultValue) {
		NBTByte tag = this.getByteTag(key);
		return tag == null ? defaultValue : tag.getValue() != 0;
	}

	public NBTCompound putBoolean(String key, boolean value) {
		this.getValue().put(key, new NBTByte((byte) (value ? 1 : 0)));
		return this;
	}

	//====================================================================================================//

	public NBTByte getByteTag(String key) {
		return this.getByteTagOrDefault(key, null);
	}

	public NBTByte getByteTagOrDefault(String key, NBTByte defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.BYTE) return defaultTag;
		return (NBTByte) nbt;
	}

	public byte getByte(String key) {
		return this.getByteTagOrDefault(key, NBTByte.NULL).getValue();
	}

	public byte getByteOrDefault(String key, byte defaultValue) {
		NBTByte tag = this.getByteTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putByte(String key, byte value) {
		this.getValue().put(key, new NBTByte(value));
		return this;
	}

	//====================================================================================================//

	public NBTShort getShortTag(String key) {
		return this.getShortTagOrDefault(key, null);
	}

	public NBTShort getShortTagOrDefault(String key, NBTShort defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.SHORT) return defaultTag;
		return (NBTShort) nbt;
	}

	public short getShort(String key) {
		return this.getShortTagOrDefault(key, NBTShort.NULL).getValue();
	}

	public short getShortOrDefault(String key, short defaultValue) {
		NBTShort tag = this.getShortTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putShort(String key, short value) {
		this.getValue().put(key, new NBTShort(value));
		return this;
	}

	//====================================================================================================//

	public NBTInt getIntTag(String key) {
		return this.getIntTagOrDefault(key, null);
	}

	public NBTInt getIntTagOrDefault(String key, NBTInt defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.INT) return defaultTag;
		return (NBTInt) nbt;
	}

	public int getInt(String key) {
		return this.getIntTagOrDefault(key, NBTInt.NULL).getValue();
	}

	public int getIntOrDefault(String key, int defaultValue) {
		NBTInt tag = this.getIntTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putInt(String key, int value) {
		this.getValue().put(key, new NBTInt(value));
		return this;
	}

	//====================================================================================================//

	public NBTLong getLongTag(String key) {
		return this.getLongTagOrDefault(key, null);
	}

	public NBTLong getLongTagOrDefault(String key, NBTLong defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.LONG) return defaultTag;
		return (NBTLong) nbt;
	}

	public long getLong(String key) {
		return this.getLongTagOrDefault(key, NBTLong.NULL).getValue();
	}

	public long getLongOrDefault(String key, long defaultValue) {
		NBTLong tag = this.getLongTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putLong(String key, long value) {
		this.getValue().put(key, new NBTLong(value));
		return this;
	}

	//====================================================================================================//

	public NBTFloat getFloatTag(String key) {
		return this.getFloatTagOrDefault(key, null);
	}

	public NBTFloat getFloatTagOrDefault(String key, NBTFloat defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.FLOAT) return defaultTag;
		return (NBTFloat) nbt;
	}

	public float getFloat(String key) {
		return this.getFloatTagOrDefault(key, NBTFloat.NULL).getValue();
	}

	public float getFloatOrDefault(String key, float defaultValue) {
		NBTFloat tag = this.getFloatTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putFloat(String key, float value) {
		this.getValue().put(key, new NBTFloat(value));
		return this;
	}

	//====================================================================================================//

	public NBTDouble getDoubleTag(String key) {
		return this.getDoubleTagOrDefault(key, null);
	}

	public NBTDouble getDoubleTagOrDefault(String key, NBTDouble defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.DOUBLE) return defaultTag;
		return (NBTDouble) nbt;
	}

	public double getDouble(String key) {
		return this.getDoubleTagOrDefault(key, NBTDouble.NULL).getValue();
	}

	public double getDoubleOrDefault(String key, double defaultValue) {
		NBTDouble tag = this.getDoubleTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putDouble(String key, double value) {
		this.getValue().put(key, new NBTDouble(value));
		return this;
	}

	//====================================================================================================//

	public NBTByteArray getByteArrayTag(String key) {
		return this.getByteArrayTagOrDefault(key, null);
	}

	public NBTByteArray getByteArrayTagOrDefault(String key, NBTByteArray defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.BYTE_ARRAY) return defaultTag;
		return (NBTByteArray) nbt;
	}

	public byte[] getByteArray(String key) {
		return this.getByteArrayTagOrDefault(key, NBTByteArray.NULL).getValue();
	}

	public byte[] getByteArrayOrDefault(String key, byte[] defaultValue) {
		NBTByteArray tag = this.getByteArrayTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putByteArray(String key, byte[] value) {
		this.getValue().put(key, new NBTByteArray(value));
		return this;
	}

	//====================================================================================================//

	public NBTString getStringTag(String key) {
		return this.getStringTagOrDefault(key, null);
	}

	public NBTString getStringTagOrDefault(String key, NBTString defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.STRING) return defaultTag;
		return (NBTString) nbt;
	}

	public String getString(String key) {
		return this.getStringTagOrDefault(key, NBTString.NULL).getValue();
	}

	public String getStringOrDefault(String key, String defaultValue) {
		NBTString tag = this.getStringTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putString(String key, String value) {
		this.getValue().put(key, new NBTString(value));
		return this;
	}

	//====================================================================================================//

	public NBTList getListTag(String key) {
		return this.getListTagOrDefault(key, null);
	}

	public NBTList getListTagOrDefault(String key, NBTList defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.LIST) return defaultTag;
		return (NBTList) nbt;
	}

	public List<NBTTag<?>> getList(String key) {
		return this.getListTagOrDefault(key, NBTList.NULL).getValue();
	}

	public List<NBTTag<?>> getListOrDefault(String key, List<NBTTag<?>> defaultValue) {
		NBTList tag = this.getListTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public <T extends NBTTag<?>> List<T> getList(String key, Class<T> tagClass) {
		return this.getListTagOrDefault(key, NBTList.NULL).getValue(tagClass);
	}

	public <T extends NBTTag<?>> List<T> getListOrDefault(String key, List<T> defaultValue, Class<T> tagClass) {
		NBTList tag = this.getListTag(key);
		return tag == null ? defaultValue : tag.getValue(tagClass);
	}

	public List<Object> getListElements(String key) {
		return this.getListTagOrDefault(key, NBTList.NULL).getElements();
	}

	public List<Object> getListElementsOrDefault(String key, List<Object> defaultValue) {
		NBTList tag = this.getListTag(key);
		return tag == null ? defaultValue : tag.getElements();
	}

	public <T> List<T> getListElements(String key, Class<T> elementClass) {
		return this.getListTagOrDefault(key, NBTList.NULL).getElements(elementClass);
	}

	public <T> List<T> getListElementsOrDefault(String key, List<T> defaultValue, Class<T> elementClass) {
		NBTList tag = this.getListTag(key);
		return tag == null ? defaultValue : tag.getElements(elementClass);
	}

	//====================================================================================================//

	public NBTCompound getCompoundTag(String key) {
		return this.getCompoundTagOrDefault(key, null);
	}

	public NBTCompound getCompoundTagOrDefault(String key, NBTCompound defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.COMPOUND) return defaultTag;
		return (NBTCompound) nbt;
	}

	public Map<String, NBTTag<?>> getCompound(String key) {
		return this.getCompoundTagOrDefault(key, NBTCompound.NULL).getValue();
	}

	public Map<String, NBTTag<?>> getCompoundOrDefault(String key, Map<String, NBTTag<?>> defaultValue) {
		NBTCompound tag = this.getCompoundTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	//====================================================================================================//

	public NBTIntArray getIntArrayTag(String key) {
		return this.getIntArrayTagOrDefault(key, null);
	}

	public NBTIntArray getIntArrayTagOrDefault(String key, NBTIntArray defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.INT_ARRAY) return defaultTag;
		return (NBTIntArray) nbt;
	}

	public int[] getIntArray(String key) {
		return this.getIntArrayTagOrDefault(key, NBTIntArray.NULL).getValue();
	}

	public int[] getIntArrayOrDefault(String key, int[] defaultValue) {
		NBTIntArray tag = this.getIntArrayTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putIntArray(String key, int[] value) {
		this.getValue().put(key, new NBTIntArray(value));
		return this;
	}

	//====================================================================================================//

	public NBTLongArray getLongArrayTag(String key) {
		return this.getLongArrayTagOrDefault(key, null);
	}

	public NBTLongArray getLongArrayTagOrDefault(String key, NBTLongArray defaultTag) {
		NBTTag<?> nbt = this.getValue().get(key);
		if (nbt == null || nbt.getType() != NBTType.BYTE_ARRAY) return defaultTag;
		return (NBTLongArray) nbt;
	}

	public long[] getLongArray(String key) {
		return this.getLongArrayTagOrDefault(key, NBTLongArray.NULL).getValue();
	}

	public long[] getLongArrayOrDefault(String key, long[] defaultValue) {
		NBTLongArray tag = this.getLongArrayTag(key);
		return tag == null ? defaultValue : tag.getValue();
	}

	public NBTCompound putLongArray(String key, long[] value) {
		this.getValue().put(key, new NBTLongArray(value));
		return this;
	}

	//====================================================================================================//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		Iterator<Map.Entry<String, NBTTag<?>>> it = this.getValue().entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, NBTTag<?>> e = it.next();
			sb.append("\"").append(e.getKey()).append("\": ").append(e.getValue());
			sb.append(it.hasNext() ? ", " : "");
		}

		return sb.append("}").toString();
	}

}
