package kaptainwutax.mcutils.nbt.tag;

public abstract class NBTWrapper<T> extends NBTTag {

    private T value;

    public T getValue() {
        return value;
    }

    public NBTWrapper<T> setValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
