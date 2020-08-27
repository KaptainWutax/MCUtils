package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTFloat extends NBTTag<Float> {

    public static final NBTFloat NULL = new NBTFloat() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTFloat() {
        this(0.0F);
    }

    public NBTFloat(float value) {
        super(value);
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readFloat(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeFloat(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
