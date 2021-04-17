package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.net.ByteBuffer;
import kaptainwutax.mcutils.net.IByteSerializable;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Objects;

public abstract class NBTTag<T> implements IByteSerializable {

    private String name = "";
    private T value;

    public NBTTag(T value) {
        this.setValue(value);
    }

    public static NBTTag<?> create(ByteBuffer buffer) throws IOException {
        NBTTag<?> tag = NBTType.createEmpty(buffer.readByte());
        tag.read(buffer);
        return tag;
    }

    public final String getName() {
        return this.name;
    }

    public T getValue() {
        return value;
    }

    @SuppressWarnings("unchecked")
    public final byte getType() {
        return NBTType.getTypeOf((Class<? extends NBTTag<?>>)this.getClass());
    }

    public NBTTag<?> setValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public void read(ByteBuffer buffer) throws IOException {
        this.name = buffer.readASCII(ByteOrder.BIG_ENDIAN);
        this.readPayload(buffer);
    }

    @Override
    public void write(ByteBuffer buffer) throws IOException {
        if(this.getType() < 0)throw new RuntimeException("Serializing unregistered tag " + this.getClass());
        this.writePayload(buffer.writeByte(this.getType()).writeASCII(this.name, ByteOrder.BIG_ENDIAN));
    }

    public abstract void readPayload(ByteBuffer buffer) throws IOException;

    public abstract void writePayload(ByteBuffer buffer) throws IOException;

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof NBTTag)) return false;
        NBTTag<?> that = (NBTTag<?>)other;
        return this.getType() == that.getType() && this.getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
