package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.BlockPalette;
import kaptainwutax.mcutils.block.BlockState;
import kaptainwutax.mcutils.block.Tile;
import kaptainwutax.mcutils.nbt.NBTType;
import kaptainwutax.mcutils.nbt.tag.NBTCompound;
import kaptainwutax.mcutils.nbt.tag.NBTInt;
import kaptainwutax.mcutils.nbt.tag.NBTList;
import kaptainwutax.mcutils.util.math.Vec3i;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.mcutils.version.MCVersion;

import java.util.*;
import java.util.stream.Collectors;

public class PieceInfo {

    public static final Comparator<Tile> TILE_SORTER = Comparator.<Tile>comparingInt(tile -> tile.getPos().getY())
            .thenComparing(tile -> tile.getPos().getX()).thenComparing(tile -> tile.getPos().getZ());

    private final MCVersion version;
    protected Vec3i size;

    protected Map<BPos, Integer> blockIDs = new LinkedHashMap<>();
    protected Map<BPos, NBTCompound> blockEntities = new HashMap<>();

    protected List<BlockPalette> palettes = new ArrayList<>();

    protected int dataVersion;

    public PieceInfo(MCVersion version) {
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

    public List<TileView> getTiles() {
        return this.blockIDs.keySet().stream().map(pos -> new TileView(this, pos)).collect(Collectors.toList());
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

    public PieceInfo fromTag(NBTCompound nbt) {
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

    public static class TileView extends Tile {
        private final PieceInfo parent;
        private final BPos pos;

        public TileView(PieceInfo parent, BPos pos) {
            super(pos, null, null);
            this.parent = parent;
            this.pos = pos;
        }

        @Override
        public BPos getPos() {
            return this.pos;
        }

        @Override
        public BlockState getBlockState() {
            return this.getBlockState(0);
        }

        public BlockState getBlockState(int paletteId) {
            return this.getBlockState(this.parent.getPalettes().get(paletteId));
        }

        public BlockState getBlockState(BlockPalette palette) {
            return palette.get(this.getState());
        }

        @Override
        public NBTCompound getBlockEntity() {
            return this.parent.getBlockEntities().get(this.getPos());
        }

        public int getState() {
            return this.parent.getBlockIDs().get(this.getPos());
        }

        @Override
        public void setBlockEntity(NBTCompound blockEntity) {
            if(blockEntity == null)this.parent.getBlockEntities().remove(this.getPos());
            else this.parent.getBlockEntities().put(this.getPos(), blockEntity);
        }

        public Tile copy(int paletteId) {
            return new Tile(this.getPos(), this.getBlockState(paletteId), this.getBlockEntity());
        }

        public Tile copy(BlockPalette palette) {
            return new Tile(this.getPos(), this.getBlockState(palette), this.getBlockEntity());
        }
    }
    
}
