package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;

public class NBTByteArray extends NBTArray<Byte> {

    @Override
    public Byte readElement(ByteBuffer buffer) throws IOException {
        return buffer.readByte();
    }

    @Override
    public void writeElement(Byte element, ByteBuffer buffer) throws IOException {
        buffer.writeByte(element);
    }

}
