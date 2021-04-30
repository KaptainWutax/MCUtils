package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTInt extends NBTTag<Integer> {

	public static final NBTInt NULL = new NBTInt() {
		@Override
		public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }

		@Override
		public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
	};

	public NBTInt() {
		this(0);
	}

	public NBTInt(int value) {
		super(value);
	}

	@Override
	public void readPayload(ByteBuffer buffer) throws IOException {
		this.setValue(buffer.readInt(ByteOrder.BIG_ENDIAN));
	}

	@Override
	public void writePayload(ByteBuffer buffer) throws IOException {
		buffer.writeInt(this.getValue(), ByteOrder.BIG_ENDIAN);
	}

}
