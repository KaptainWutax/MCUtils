package kaptainwutax.mcutils.nbt;

import kaptainwutax.mcutils.nbt.tag.NBTCompound;
import kaptainwutax.mcutils.nbt.tag.NBTTag;
import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipException;

public class NBTIO {

    public static NBTCompound read(String path) throws IOException {
        return read(new File(path));
    }

    public static NBTCompound read(File file) throws IOException {
        return read(Files.readAllBytes(file.toPath()));
    }

    public static NBTCompound read(byte[] bytes) throws IOException {
        InputStream in;

        try {
            in = new GZIPInputStream(new ByteArrayInputStream(bytes));
        } catch(ZipException e) {
            in = new ByteArrayInputStream(bytes);
        }

        NBTTag<?> tag = NBTTag.create(new ByteBuffer(in));
        in.close();

        if(tag instanceof NBTCompound)return (NBTCompound)tag;
        NBTCompound compound = new NBTCompound();
        compound.getValue().put("", tag);
        return compound;
    }

    public static void write(NBTTag<?> tag, String path, boolean compressed) throws IOException {
        write(tag, new File(path), compressed);
    }

    public static void write(NBTTag<?> tag, File file, boolean compressed) throws IOException {
        OutputStream out = new FileOutputStream(file);
        if(compressed)out = new GZIPOutputStream(out);
        tag.write(new ByteBuffer(out));
        out.flush();
        out.close();
    }

}
