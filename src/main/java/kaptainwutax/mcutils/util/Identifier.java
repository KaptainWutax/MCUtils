package kaptainwutax.mcutils.util;

import java.util.Objects;
import java.util.regex.Pattern;

public class Identifier {

    protected final String namespace;
    protected final String path;

    protected Identifier(String[] id) {
        this.namespace = (id[0] == null || id[0].isEmpty()) ? "minecraft" : id[0];
        this.path = id[1];
    }

    public Identifier(String namespace, String path) {
        this(new String[] {namespace, path});
    }

    public Identifier(String id) {
        this(split(id));
    }

    public static String[] split(String id) {
        String[] s = id.split(Pattern.quote(":"));
        return s.length == 1 ? new String[] {"minecraft", id} : s;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other)return true;
        if(!(other instanceof Identifier))return false;
        Identifier that = (Identifier)other;
        return this.getNamespace().equals(that.getNamespace()) && this.getPath().equals(that.getPath());
    }

    @Override
    public int hashCode() {
        return this.getNamespace().hashCode() * 31 + this.getPath().hashCode();
    }

    @Override
    public String toString() {
        return this.namespace + ":" + this.path;
    }

}
