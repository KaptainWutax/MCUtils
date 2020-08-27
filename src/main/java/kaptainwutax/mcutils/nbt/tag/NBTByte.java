package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;

public class NBTByte extends NBTTag<Byte> {

    public static final NBTByte NULL = new NBTByte() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTByte() {
        this((byte)0);
    }

    public NBTByte(byte value) {
        super(value);
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readByte());
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeByte(this.getValue());
    }

}
