package kaptainwutax.mcutils.nbt;

import kaptainwutax.mcutils.nbt.tag.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NBTType {

	public static final Map<Byte, Supplier<? extends NBTTag<?>>> REGISTRY = new HashMap<>();
	public static final byte END = 0;
	public static final byte BYTE = 1;
	public static final byte SHORT = 2;
	public static final byte INT = 3;
	public static final byte LONG = 4;
	public static final byte FLOAT = 5;
	public static final byte DOUBLE = 6;
	public static final byte BYTE_ARRAY = 7;
	public static final byte STRING = 8;
	public static final byte LIST = 9;
	public static final byte COMPOUND = 10;
	public static final byte INT_ARRAY = 11;
	public static final byte LONG_ARRAY = 12;
	private static final Map<Class<? extends NBTTag<?>>, Byte> TYPE_REGISTRY = new HashMap<>();

	static {
		register(NBTEnd.class, END, NBTEnd::new);
		register(NBTByte.class, BYTE, NBTByte::new);
		register(NBTShort.class, SHORT, NBTShort::new);
		register(NBTInt.class, INT, NBTInt::new);
		register(NBTLong.class, LONG, NBTLong::new);
		register(NBTFloat.class, FLOAT, NBTFloat::new);
		register(NBTDouble.class, DOUBLE, NBTDouble::new);
		register(NBTByteArray.class, BYTE_ARRAY, NBTByteArray::new);
		register(NBTString.class, STRING, NBTString::new);
		register(NBTList.class, LIST, NBTList::new);
		register(NBTCompound.class, COMPOUND, NBTCompound::new);
		register(NBTIntArray.class, INT_ARRAY, NBTIntArray::new);
		register(NBTLongArray.class, LONG_ARRAY, NBTLongArray::new);
	}

	public static <T extends NBTTag<?>> void register(Class<T> tagClass, int type, Supplier<T> supplier) {
		if (REGISTRY.containsKey((byte) type)) {
			throw new RuntimeException("Type " + type + " is already taken");
		}

		REGISTRY.put((byte) type, supplier);
		TYPE_REGISTRY.put(tagClass, (byte) type);
	}

	public static byte getTypeOf(Class<? extends NBTTag<?>> tagClass) {
		return TYPE_REGISTRY.getOrDefault(tagClass, (byte) -1);
	}

	public static NBTTag<?> createEmpty(byte type) {
		Supplier<? extends NBTTag<?>> supplier = NBTType.REGISTRY.get(type);

		if (supplier == null) {
			throw new RuntimeException("Deserializing unregistered tag of type " + type);
		}

		return supplier.get();
	}

}
