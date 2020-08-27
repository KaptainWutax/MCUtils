package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;

public class NBTByte extends NBTWrapper<Byte> {

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readByte());
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeByte(this.getValue());
    }

}
