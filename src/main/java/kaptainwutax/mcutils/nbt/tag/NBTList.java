package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NBTList extends NBTTag<List<NBTTag<?>>> {

    public static final NBTList NULL = new NBTList() {
        @Override public void readPayload(ByteBuffer buffer) { throw new NullPointerException(); }
        @Override public void writePayload(ByteBuffer buffer) { throw new NullPointerException(); }
    };

    private byte elementType;

    public NBTList() {
        this(ArrayList::new);
    }

    public NBTList(Supplier<List<NBTTag<?>>> supplier) {
        super(supplier.get());
    }

    public final byte getElementType() {
        return this.elementType;
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        this.elementType = buffer.readByte();
        int length = buffer.readInt(ByteOrder.BIG_ENDIAN);

        if(this.elementType == NBTType.END && length > 0) {
            throw new RuntimeException("List of length " + length + " with no type");
        }

        for(int i = 0; i < length; i++) {
            NBTTag<?> nbt = NBTType.createEmpty(this.elementType);
            nbt.readPayload(buffer);
            this.getValue().add(nbt);
        }
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeByte(this.elementType);
        buffer.writeInt(this.getValue().size(), ByteOrder.BIG_ENDIAN);

        for(NBTTag<?> element: this.getValue()) {
            element.writePayload(buffer);
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.getValue().size();
    }

    public boolean contains(Object value) {
        return super.getValue().stream().map(NBTTag::getValue).anyMatch(value::equals);
    }

    public NBTTag<?> get(int i) {
        return this.getValue().get(i);
    }

    public <T extends NBTTag<?>> T get(int i, Class<T> tagClass) {
        NBTTag<?> tag = this.getValue().get(i);
        return tagClass.isAssignableFrom(tag.getClass()) ? (T)tag : null;
    }

    public Object getElement(int i) {
        return this.getValue().get(i).getValue();
    }

    public <T> T getElement(int i, Class<T> elementClass) {
        NBTTag<?> tag = this.getValue().get(i);
        return elementClass.isAssignableFrom(tag.getValue().getClass()) ? (T)tag.getValue() : null;
    }

    public <T extends NBTTag<?>> List<T> getValue(Class<T> tagClass) {
        return IntStream.range(0, this.size()).mapToObj(i -> this.get(i, tagClass))
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<Object> getElements() {
        return IntStream.range(0, this.size()).mapToObj(this::getElement).collect(Collectors.toList());
    }

    public <T> List<T> getElements(Class<T> elementClass) {
        return IntStream.range(0, this.size()).mapToObj(i -> this.getElement(i, elementClass))
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<NBTTag<?>> it = this.getValue().iterator();

        while(it.hasNext()) {
            sb.append(it.next());
            sb.append(it.hasNext() ? ", " : "");
        }

        return sb.append("]").toString();
    }

}
