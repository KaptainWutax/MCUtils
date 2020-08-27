package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTFloat extends NBTWrapper<Float> {

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readFloat(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeFloat(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
