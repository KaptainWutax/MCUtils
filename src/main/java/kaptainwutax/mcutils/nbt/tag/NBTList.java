package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;
import kaptainwutax.mcutils.nbt.NBTType;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NBTList extends NBTTag {

    private List<NBTTag> elements = new ArrayList<>();
    private byte elementType;

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
            NBTTag nbt = NBTType.createEmpty(this.elementType);
            nbt.readPayload(buffer);
            this.elements.add(nbt);
        }
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        buffer.writeByte(this.elementType);
        buffer.writeInt(this.elements.size(), ByteOrder.BIG_ENDIAN);

        for(NBTTag element: this.elements) {
            element.writePayload(buffer);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<NBTTag> it = this.elements.iterator();

        while(it.hasNext()) {
            sb.append(it.next());
            sb.append(it.hasNext() ? ", " : "");
        }

        return sb.append("]").toString();
    }

}
