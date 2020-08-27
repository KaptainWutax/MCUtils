package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;

public class NBTEnd extends NBTTag {

    public static final NBTEnd INSTANCE = new NBTEnd();

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
