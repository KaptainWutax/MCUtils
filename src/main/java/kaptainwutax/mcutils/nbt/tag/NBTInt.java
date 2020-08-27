package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTInt extends NBTWrapper<Integer> {

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readInt(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeInt(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
