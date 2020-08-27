package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public class NBTString extends NBTWrapper<String> {

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(buffer.readChars(ByteOrder.BIG_ENDIAN));
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeChars(this.getValue(), ByteOrder.BIG_ENDIAN);
    }

}
