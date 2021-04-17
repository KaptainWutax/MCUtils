package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.Tile;
import kaptainwutax.mcutils.util.block.BlockBox;
import kaptainwutax.mcutils.util.block.BlockMirror;
import kaptainwutax.mcutils.util.block.BlockRotation;
import kaptainwutax.mcutils.util.pos.BPos;

public class StructurePlacement {

    public BlockBox box;
    public BlockMirror mirror;
    public BlockRotation rotation;
    public BPos pivot;

    public StructurePlacement() {
        this.box = BlockBox.empty();
        this.mirror = BlockMirror.NONE;
        this.rotation = BlockRotation.NONE;
        this.pivot = BPos.ORIGIN;
    }

    public Tile transform(Tile tile) {
        return this.transformAndSet(tile.copy());
    }

    public Tile transformAndSet(Tile tile) {
        int x = tile.getPos().getX();
        int y = tile.getPos().getY();
        int z = tile.getPos().getZ();

        if(this.mirror == BlockMirror.FRONT_BACK) {
            x *= -1;
        } else if(this.mirror == BlockMirror.LEFT_RIGHT) {
            z *= -1;
        }

        if(this.rotation == BlockRotation.CLOCKWISE_90) {
            x = this.pivot.getX() + this.pivot.getZ() - z;
            z = this.pivot.getZ() - this.pivot.getX() + x;
        } else if(this.rotation == BlockRotation.CLOCKWISE_180) {
            x = this.pivot.getX() + this.pivot.getX() - x;
            z = this.pivot.getZ() + this.pivot.getZ() - z;
        } else if(this.rotation == BlockRotation.COUNTERCLOCKWISE_90) {
            x = this.pivot.getX() - this.pivot.getZ() + z;
            z = this.pivot.getZ() + this.pivot.getX() - x;
        }

        if(this.mirror != BlockMirror.NONE || this.rotation != BlockRotation.NONE) {
            tile.setPos(new BPos(x, y, z));
        }

        return tile;
    }

}
