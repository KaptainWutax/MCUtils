package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTLong extends NBTTag<Long> {

    public static final NBTLong NULL = new NBTLong() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTLong() {
        this(0L);
    }

    public NBTLong(long value) {
        super(value);
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readLong(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeLong(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
