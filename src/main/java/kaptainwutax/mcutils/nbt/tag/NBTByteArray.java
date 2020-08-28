package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NBTByteArray extends NBTTag<byte[]> {

    public static final NBTByteArray NULL = new NBTByteArray() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTByteArray() {
        this(0);
    }

    public NBTByteArray(int length) {
        this(new byte[length]);
    }

    public NBTByteArray(byte[] value) {
        super(value);
    }

    public byte[] copyValue() {
        return super.getValue().clone();
    }

    public Stream<Byte> stream() {
        return IntStream.range(0, super.getValue().length).mapToObj(i -> this.getValue()[i]);
    }

    public Byte[] toBoxed() {
       return this.stream().toArray(Byte[]::new);
    }

    public List<Byte> toList() {
        return this.stream().collect(Collectors.toList());
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(new byte[buffer.readInt(ByteOrder.BIG_ENDIAN)]);
        for(int i = 0; i < this.getValue().length; i++)this.getValue()[i] = buffer.readByte();
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeInt(this.getValue().length, ByteOrder.BIG_ENDIAN);
        for(byte b : this.getValue())buffer.writeByte(b);
    }

}
