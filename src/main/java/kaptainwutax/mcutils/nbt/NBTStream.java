package kaptainwutax.mcutils.nbt;

import kaptainwutax.mcutils.nbt.tag.NBTTag;
import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipException;

public class NBTStream {

    public static NBTTag read(String path) throws IOException {
        return read(new File(path));
    }

    public static NBTTag read(File file) throws IOException {
        return read(Files.readAllBytes(file.toPath()));
    }

    public static NBTTag read(byte[] bytes) throws IOException {
        InputStream in;

        try {
            in = new GZIPInputStream(new ByteArrayInputStream(bytes));
        } catch(ZipException e) {
            in = new ByteArrayInputStream(bytes);
        }

        NBTTag nbt = NBTTag.create(new ByteBuffer(in));
        in.close();
        return nbt;
    }

    public static void write(NBTTag nbt, String path, boolean compressed) throws IOException {
        write(nbt, new File(path), compressed);
    }

    public static void write(NBTTag nbt, File file, boolean compressed) throws IOException {
        OutputStream out = new FileOutputStream(file);
        if(compressed)out = new GZIPOutputStream(out);
        nbt.write(new ByteBuffer(out));
        out.flush();
        out.close();
    }

}
