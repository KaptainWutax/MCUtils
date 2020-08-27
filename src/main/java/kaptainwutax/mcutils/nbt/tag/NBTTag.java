package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.net.ByteBuffer;
import kaptainwutax.mcutils.net.IByteSerializable;

import java.io.IOException;
import java.nio.ByteOrder;

public abstract class NBTTag<T> implements IByteSerializable {

    private String name;
    private T value;

    public NBTTag(T value) {
        this.setValue(value);
    }

    public final String getName() {
        return this.name;
    }

    public T getValue() {
        return value;
    }

    public final byte getType() {
        return NBTType.getTypeOf((Class<? extends NBTTag<?>>)this.getClass());
    }

    public void setValue(T value) {
        this.value = value;
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

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static NBTTag<?> create(ByteBuffer buffer) throws IOException {
        NBTTag<?> tag = NBTType.createEmpty(buffer.readByte());
        tag.read(buffer);
        return tag;
    }

}
