package kaptainwutax.mcutils.net;

import java.io.*;
import java.nio.ByteOrder;

public class ByteBuffer {

    protected final InputStream in;
    protected final OutputStream out;

    public ByteBuffer(InputStream in) {
        this(in, null);
    }

    public ByteBuffer(OutputStream out) {
        this(null, out);
    }

    public ByteBuffer(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public int read() throws IOException {
        return this.in.read();
    }

    public ByteBuffer write(int b) throws IOException {
        this.out.write(b);
        return this;
    }

    private boolean readBoolean() throws IOException {
        int v = this.read();
        if(v < 0)throw new EOFException();
        return v != 0;
    }

    public ByteBuffer writeBoolean(boolean v) throws IOException {
        this.out.write(v ? 1 : 0);
        return this;
    }

    public int readUnsignedByte() throws IOException {
        int v = this.in.read();
        if(v < 0)throw new EOFException();
        return v;
    }

    public byte readByte() throws IOException {
        return (byte)this.readUnsignedByte();
    }

    public ByteBuffer writeByte(int v) throws IOException {
        this.out.write(v);
        return this;
    }

    public int readUnsignedShort(ByteOrder order) throws IOException {
        int a = this.in.read();
        int b = this.in.read();
        if((a | b) < 0)throw new EOFException();
        return order == ByteOrder.BIG_ENDIAN ? (a << 8) + b : (b << 8) + a;
    }

    public short readShort(ByteOrder order) throws IOException {
        return (short)this.readUnsignedShort(order);
    }

    public ByteBuffer writeShort(short v, ByteOrder order) throws IOException {
        if(order == ByteOrder.BIG_ENDIAN) {
            this.out.write((v >>> 8) & 0xFF);
            this.out.write(v & 0xFF);
        } else {
            this.out.write(v & 0xFF);
            this.out.write((v >>> 8) & 0xFF);
        }

        return this;
    }

    public char readChar(ByteOrder order) throws IOException {
        return (char)this.readUnsignedShort(order);
    }

    public ByteBuffer writeChar(char v, ByteOrder order) throws IOException {
        if(order == ByteOrder.BIG_ENDIAN) {
            this.out.write((v >>> 8) & 0xFF);
            this.out.write(v & 0xFF);
        } else {
            this.out.write(v & 0xFF);
            this.out.write((v >>> 8) & 0xFF);
        }

        return this;
    }

    public int readInt(ByteOrder order) throws IOException {
        int a = this.in.read();
        int b = this.in.read();
        int c = this.in.read();
        int d = this.in.read();
        if((a | b | c | d) < 0)throw new EOFException();
        return order == ByteOrder.BIG_ENDIAN
                ? (a << 24) + (b << 16) + (c << 8) + d
                : (d << 24) + (c << 16) + (b << 8) + a;
    }

    public ByteBuffer writeInt(int v, ByteOrder order) throws IOException {
        if(order == ByteOrder.BIG_ENDIAN) {
            this.out.write((v >>> 24) & 0xFF);
            this.out.write((v >>> 16) & 0xFF);
            this.out.write((v >>> 8) & 0xFF);
            this.out.write(v & 0xFF);
        } else {
            this.out.write(v & 0xFF);
            this.out.write((v >>> 8) & 0xFF);
            this.out.write((v >>> 16) & 0xFF);
            this.out.write((v >>> 24) & 0xFF);
        }

        return this;
    }

    public long readLong(ByteOrder order) throws IOException {
        byte a = this.readByte(), b = this.readByte(), c = this.readByte(), d = this.readByte();
        byte e = this.readByte(), f = this.readByte(), g = this.readByte(), h = this.readByte();
        return order == ByteOrder.BIG_ENDIAN
                ? ((long)a << 56) + ((long)b << 48) + ((long)c << 40) + ((long)d << 32) + ((long)e << 24) + (f << 16) + (g << 8) + h
                : ((long)h << 56) + ((long)g << 48) + ((long)f << 40) + ((long)e << 32) + ((long)d << 24) + (c << 16) + (b << 8) + a;
    }

    public ByteBuffer writeLong(long v, ByteOrder order) throws IOException {
        if(order == ByteOrder.BIG_ENDIAN) {
            this.out.write((byte)(v >>> 56));
            this.out.write((byte)(v >>> 48));
            this.out.write((byte)(v >>> 40));
            this.out.write((byte)(v >>> 32));
            this.out.write((byte)(v >>> 24));
            this.out.write((byte)(v >>> 16));
            this.out.write((byte)(v >>> 8));
            this.out.write((byte)v);
        } else {
            this.out.write((byte)v);
            this.out.write((byte)(v >>> 8));
            this.out.write((byte)(v >>> 16));
            this.out.write((byte)(v >>> 24));
            this.out.write((byte)(v >>> 56));
            this.out.write((byte)(v >>> 48));
            this.out.write((byte)(v >>> 40));
            this.out.write((byte)(v >>> 32));
        }

        return this;
    }

    public float readFloat(ByteOrder order) throws IOException {
        return Float.intBitsToFloat(this.readInt(order));
    }

    public ByteBuffer writeFloat(float v, ByteOrder order) throws IOException {
        return this.writeInt(Float.floatToIntBits(v), order);
    }

    public double readDouble(ByteOrder order) throws IOException {
        return Double.longBitsToDouble(this.readLong(order));
    }

    public ByteBuffer writeDouble(double v, ByteOrder order) throws IOException {
        return this.writeLong(Double.doubleToLongBits(v), order);
    }

    public String readChars(ByteOrder order) throws IOException {
        char[] arr = new char[this.readUnsignedShort(order)];
        for(int i = 0; i < arr.length; i++)arr[i] = (char)this.readByte();
        return new String(arr);
    }

    public ByteBuffer writeChars(String v, ByteOrder order) throws IOException {
        this.writeShort((short)v.length(), order);
        for(int i = 0; i < v.length(); i++)this.writeByte(v.charAt(i));
        return this;
    }

}
