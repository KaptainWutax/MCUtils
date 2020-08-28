package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.BlockPalette;
import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.nbt.tag.NBTCompound;
import kaptainwutax.mcutils.nbt.tag.NBTInt;
import kaptainwutax.mcutils.nbt.tag.NBTList;
import kaptainwutax.mcutils.util.math.Vec3i;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.mcutils.version.MCVersion;

import java.util.*;

public class StructureInfo {

    private final MCVersion version;
    protected Vec3i size;

    protected Map<BPos, Integer> blockIDs = new LinkedHashMap<>();
    protected Map<BPos, NBTCompound> blockEntities = new HashMap<>();

    protected List<BlockPalette> palettes = new ArrayList<>();

    protected int dataVersion;

    public StructureInfo(MCVersion version) {
        this.version = version;
    }

    public MCVersion getVersion() {
        return this.version;
    }

    public Vec3i getSize() {
        return this.size;
    }

    public Map<BPos, Integer> getBlockIDs() {
        return this.blockIDs;
    }

    public Map<BPos, NBTCompound> getBlockEntities() {
        return this.blockEntities;
    }

    public BlockPalette getPalette() {
        return this.palettes.get(0);
    }

    public List<BlockPalette> getPalettes() {
        return this.palettes;
    }

    public int getDataVersion() {
        return this.dataVersion;
    }

    public void setSize(int x, int y, int z) {
        this.setSize(new Vec3i(x, y, z));
    }

    public void setSize(Vec3i size) {
        this.size = size;
    }

    public void setDataVersion(int dataVersion) {
        this.dataVersion = dataVersion;
    }

    public StructureInfo fromTag(NBTCompound nbt) {
        if(nbt.contains("size", NBTType.LIST)) {
            List<Integer> coords = nbt.getListElements("size", Integer.class);
            this.size = new Vec3i(coords.get(0), coords.get(1), coords.get(2));
        } else {
            throw new RuntimeException("Structure has no size!");
        }

        if(nbt.contains("blocks", NBTType.LIST)) {
            nbt.getListTag("blocks").getValue(NBTCompound.class).forEach(blockInfo -> {
                List<Integer> list = blockInfo.getListElements("pos", Integer.class);
                BPos pos = new BPos(list.get(0), list.get(1), list.get(2));
                this.blockIDs.put(pos, blockInfo.getInt("state"));
                if(!blockInfo.contains("nbt", NBTType.COMPOUND))return;
                this.blockEntities.put(pos, blockInfo.getCompoundTag("nbt"));
            });
        } else {
            throw new RuntimeException("Structure has no blocks!");
        }

        if(nbt.contains("palettes", NBTType.LIST)) {
            nbt.getListTag("palettes").getValue(NBTList.class).forEach(palette -> {
                this.palettes.add((new BlockPalette().fromTag(version, palette)));
            });
        } else if(nbt.contains("palette", NBTType.LIST)) {
            this.palettes.add(new BlockPalette().fromTag(version, nbt.getListTag("palette")));
        } else {
            throw new RuntimeException("Structure has no palette!");
        }

        this.dataVersion = nbt.getInt("DataVersion");
        return this;
    }

    public NBTCompound toTag() {
        return new NBTCompound().run(tag -> {
            tag.putTag("size", new NBTList(NBTType.INT).run(coords -> {
                coords.add(new NBTInt(this.size.getX()));
                coords.add(new NBTInt(this.size.getY()));
                coords.add(new NBTInt(this.size.getZ()));
            }));

            tag.putTag("blocks", new NBTList(NBTType.COMPOUND).run(list -> this.blockIDs.forEach((pos, state) -> {
                list.add(new NBTCompound().run(blockInfo -> {
                    NBTCompound nbt = this.blockEntities.get(pos);
                    if(nbt != null)blockInfo.putTag("nbt", nbt);

                    blockInfo.putTag("pos", new NBTList(NBTType.INT).run(coords -> {
                        coords.add(new NBTInt(pos.getX()));
                        coords.add(new NBTInt(pos.getY()));
                        coords.add(new NBTInt(pos.getZ()));
                    }));

                    blockInfo.putInt("state", state);
                }));
            })));

            if(this.palettes.size() == 1) {
                tag.putTag("palette", this.palettes.get(0).toTag());
            } else {
                tag.putTag("palettes", new NBTList(NBTType.LIST).run(palettes -> {
                    this.palettes.forEach(palette -> palettes.add(palette.toTag()));
                }));
            }

            tag.putInt("DataVersion", this.dataVersion);
        });
    }
    
}
