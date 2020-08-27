package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTIntArray extends NBTArray<Integer> {

    @Override
    public Integer readElement(ByteBuffer buffer) throws IOException {
        return buffer.readInt(ByteOrder.BIG_ENDIAN);
    }

    @Override
    public void writeElement(Integer element, ByteBuffer buffer) throws IOException {
        buffer.writeInt(element, ByteOrder.BIG_ENDIAN);
    }

}
