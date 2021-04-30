package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTDouble extends NBTTag<Double> {

	public static final NBTDouble NULL = new NBTDouble() {
		@Override
		public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }

		@Override
		public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
	};

	public NBTDouble() {
		this(0.0D);
	}

	public NBTDouble(double value) {
		super(value);
	}

	@Override
	public void readPayload(ByteBuffer buffer) throws IOException {
		this.setValue(buffer.readDouble(ByteOrder.BIG_ENDIAN));
	}

	@Override
	public void writePayload(ByteBuffer buffer) throws IOException {
		buffer.writeDouble(this.getValue(), ByteOrder.BIG_ENDIAN);
	}

}
