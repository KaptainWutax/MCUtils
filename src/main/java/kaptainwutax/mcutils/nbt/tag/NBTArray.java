package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.nio.ByteOrder;

public abstract class NBTArray<T> extends NBTTag {

    private Object[] elements;

    @Override
    public final void readPayload(ByteBuffer buffer) throws IOException {
        this.elements = new Object[buffer.readInt(ByteOrder.BIG_ENDIAN)];

        for(int i = 0; i < this.elements.length; i++) {
            this.elements[i] = this.readElement(buffer);
        }
    }

    @Override
    public final void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeInt(this.elements.length, ByteOrder.BIG_ENDIAN);

        for(int i = 0; i < this.elements.length; i++) {
            this.writeElement((T)this.elements[i], buffer);
        }
    }

    public abstract T readElement(ByteBuffer buffer) throws IOException;

    public abstract void writeElement(T element, ByteBuffer buffer) throws IOException;

}
