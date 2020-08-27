package kaptainwutax.mcutils.nbt.tag;

import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NBTCompound extends NBTTag {

    private final Map<String, NBTTag> children;

    public NBTCompound() {
        this(new HashMap<>());
    }

    protected NBTCompound(Map<String, NBTTag> children) {
        this.children = children;
    }

    @Override
    public void readPayload(ByteBuffer buffer) throws IOException {
        for(this.children.clear(); ; ) {
            NBTTag nbt = NBTTag.create(buffer);
            if(nbt instanceof NBTEnd)break;
            this.children.put(nbt.getName(), nbt);
        }
    }

    @Override
    public void writePayload(ByteBuffer buffer) throws IOException {
        for(NBTTag nbt: this.children.values()) {
            nbt.write(buffer);
        }

        NBTEnd.INSTANCE.write(buffer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<NBTTag> it = this.children.values().iterator();

        while(it.hasNext()) {
            NBTTag e = it.next();
            sb.append("\"").append(e.getName()).append("\": ").append(e);
            sb.append(it.hasNext() ? ", " : "");
        }

        return sb.append("}").toString();
    }

}
