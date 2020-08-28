package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NBTIntArray extends NBTTag<int[]> {

    public static final NBTIntArray NULL = new NBTIntArray() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    public NBTIntArray() {
        this(0);
    }

    public NBTIntArray(int length) {
        this(new int[length]);
    }

    public NBTIntArray(int[] value) {
        super(value);
    }

    public int[] copyValue() {
        return super.getValue().clone();
    }

    public Stream<Integer> stream() {
        return Arrays.stream(this.getValue()).boxed();
    }

    public Integer[] toBoxed() {
        return this.stream().toArray(Integer[]::new);
    }

    public List<Integer> toList() {
        return this.stream().collect(Collectors.toList());
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.setValue(new int[buffer.readInt(ByteOrder.BIG_ENDIAN)]);
        for(int i = 0; i < this.getValue().length; i++)this.getValue()[i] = buffer.readInt(ByteOrder.BIG_ENDIAN);
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeInt(this.getValue().length, ByteOrder.BIG_ENDIAN);
        for(int v : this.getValue())buffer.writeInt(v, ByteOrder.BIG_ENDIAN);
    }

}
