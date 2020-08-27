package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;

public class NBTEnd extends NBTTag<Void> {

    public static final NBTEnd INSTANCE = new NBTEnd();

    public NBTEnd() {
        super(null);
    }

    @Override
    public void read(ByteBuffer buffer) {

    }

    @Override
    public void write(ByteBuffer buffer) throws IOException {
        buffer.writeByte(this.getType());
    }

    @Override
    public void readPayload(ByteBuffer buffer) {

    }

    @Override
    public void writePayload(ByteBuffer buffer) {

    }

}
