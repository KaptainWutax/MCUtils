package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;
import kaptainwutax.mcutils.net.IByteSerializable;
import kaptainwutax.mcutils.nbt.NBTType;

import java.io.IOException;
import java.nio.ByteOrder;

public abstract class NBTTag implements IByteSerializable {

    private String name;

    public final String getName() {
        return this.name;
    }

    public final byte getType() {
        return NBTType.getTypeOf(this.getClass());
    }

    @Override
    public void read(ByteBuffer buffer) throws IOException {
        this.name = buffer.readChars(ByteOrder.BIG_ENDIAN);
        this.readPayload(buffer);
    }

    @Override
    public void write(ByteBuffer buffer) throws IOException {
        if(this.getType() < 0) {
            throw new RuntimeException("Serializing unregistered tag " + this.getClass());
        }

        buffer.writeByte(this.getType());
        buffer.writeChars(this.name, ByteOrder.BIG_ENDIAN);
        this.writePayload(buffer);
    }

    public abstract void readPayload(ByteBuffer buffer) throws IOException;

    public abstract void writePayload(ByteBuffer buffer) throws IOException;


    public static NBTTag create(ByteBuffer buffer) throws IOException {
        NBTTag tag = NBTType.createEmpty(buffer.readByte());
        tag.read(buffer);
        return tag;
    }

}
