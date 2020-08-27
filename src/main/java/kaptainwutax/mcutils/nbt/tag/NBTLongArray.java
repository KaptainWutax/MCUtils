package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTLongArray extends NBTArray<Long> {

    @Override
    public Long readElement(ByteBuffer buffer) throws IOException {
        return buffer.readLong(ByteOrder.BIG_ENDIAN);
    }

    @Override
    public void writeElement(Long element, ByteBuffer buffer) throws IOException {
        buffer.writeLong(element, ByteOrder.BIG_ENDIAN);
    }

}
