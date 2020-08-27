package kaptainwutax.mcutils.nbt;

import kaptainwutax.mcutils.nbt.tag.NBTTag;
import kaptainwutax.mcutils.net.ByteBuffer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTStream {

    public static NBTTag read(String path) throws IOException {
        return read(new File(path));
    }

    public static NBTTag read(File file) throws IOException {
        return read(Files.readAllBytes(file.toPath()));
    }

    public static NBTTag read(byte[] bytes) throws IOException {
        return NBTTag.create(new ByteBuffer(new GZIPInputStream(new ByteArrayInputStream(bytes))));
    }

    public static void write(NBTTag nbt, String path) throws IOException {
        write(nbt, new File(path));
    }

    public static void write(NBTTag nbt, File file) throws IOException {
        nbt.write(new ByteBuffer(new GZIPOutputStream(new FileOutputStream(file))));
    }

}
