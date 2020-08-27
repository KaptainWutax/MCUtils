package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTDouble extends NBTWrapper<Double> {

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readDouble(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeDouble(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
