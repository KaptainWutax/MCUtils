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
		tile.setPos(tile.getPos().transform(mirror,rotation,pivot));
		return tile;
	}

}
