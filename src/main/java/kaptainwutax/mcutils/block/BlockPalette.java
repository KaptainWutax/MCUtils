package kaptainwutax.mcutils.block;

import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.nbt.tag.NBTCompound;
import kaptainwutax.mcutils.nbt.tag.NBTList;
import kaptainwutax.mcutils.util.Identifier;
import kaptainwutax.mcutils.version.MCVersion;

import java.util.Arrays;
import java.util.List;

public class BlockPalette {

    private BlockState[] palette;

    public BlockPalette() {

    }

    public BlockPalette(BlockState[] palette) {
        this.palette = palette;
    }

    public BlockState get(int i) {
        return this.palette[i];
    }

    public int indexOf(Block block) {
        return this.indexOf(new BlockState(block));
    }

    public int indexOf(BlockState blockState) {
        for(int i = 0; i < palette.length; i++) {
            if(this.palette[i].equals(blockState))return i;
        }

        return -1;
    }

    public BlockPalette fromTag(MCVersion version, NBTList list) {
        BlockPalette palette = new BlockPalette(new BlockState[list.size()]);
        List<NBTCompound> infos = list.getValue(NBTCompound.class);

        for(int i = 0; i < list.size(); i++) {
            NBTCompound nbt = infos.get(i).getCompoundTagOrDefault("Properties", NBTCompound.NULL);
            Identifier id = new Identifier(infos.get(i).getString("Name"));
            palette.palette[i] = new BlockState(Block.VERSIONED_ID_REGISTRY.get(version).get(id), nbt);
        }

        return palette;
    }

    public NBTList toTag() {
        return new NBTList(NBTType.COMPOUND).run(palette -> {
            for(BlockState blockState: this.palette) {
                palette.add(new NBTCompound().run(info -> {
                    if(blockState.getProperties() != NBTCompound.NULL) {
                        info.putTag("Properties", blockState.getProperties());
                    }

                    info.putString("Name", blockState.getBlock().getRegistryName());
                }));
            }
        });
    }

    @Override
    public String toString() {
        return Arrays.toString(this.palette);
    }

}
