package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTShort extends NBTTag<Short> {

    public static final NBTShort NULL = new NBTShort() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTShort() {
        this((short)0);
    }

    public NBTShort(short value) {
        super(value);
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readShort(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeShort(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
