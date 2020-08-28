package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NBTLongArray extends NBTTag<long[]> {

    public static final NBTLongArray NULL = new NBTLongArray() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTLongArray() {
        this(0);
    }

    public NBTLongArray(int length) {
        this(new long[length]);
    }

    public NBTLongArray(long[] value) {
        super(value);
    }

    public long[] copyValue() {
        return super.getValue().clone();
    }

    public Stream<Long> stream() {
        return Arrays.stream(this.getValue()).boxed();
    }

    public Long[] toBoxed() {
        return this.stream().toArray(Long[]::new);
    }

    public List<Long> toList() {
        return this.stream().collect(Collectors.toList());
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(new long[buffer.readInt(ByteOrder.BIG_ENDIAN)]);
        for(int i = 0; i < this.getValue().length; i++)this.getValue()[i] = buffer.readLong(ByteOrder.BIG_ENDIAN);
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeInt(this.getValue().length, ByteOrder.BIG_ENDIAN);
        for(long v : this.getValue())buffer.writeLong(v, ByteOrder.BIG_ENDIAN);
    }

}
