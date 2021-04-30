package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.mcutils.block.Tile;
import kaptainwutax.mcutils.util.data.Identifier;
import kaptainwutax.mcutils.util.math.Vec3i;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.seedutils.rand.JRand;

import java.util.List;
import java.util.stream.Collectors;

public class StructurePiece {

	private final PieceInfo info;
	private BPos position;
	private StructurePlacement placement;

	public StructurePiece(PieceInfo info) {
		this.info = info;
	}

	public PieceInfo getInfo() {
		return this.info;
	}

	public void generate(JRand rand) {
		List<Tile> jigsaws = this.getJigsaws(rand);

		for (Tile jigsaw : jigsaws) {
			Vec3i facing = JigsawHelper.getFacing(jigsaw.getBlockState()).getVector();
			BPos nextPieceStart = jigsaw.getPos().add(facing.getX(), facing.getY(), facing.getZ());

			Identifier pool = new Identifier(jigsaw.getBlockEntity().getString("pool"));

			boolean thisContainsNext = this.placement.box.contains(nextPieceStart);
		}
	}

	public List<Tile> getJigsaws(JRand rand) {
		int paletteId = rand.nextInt(this.info.getPalettes().size());

		List<Tile> tiles = this.info.getTiles().stream().sorted(PieceInfo.TILE_SORTER)
				.filter(tile -> tile.getBlockState(paletteId).getBlock().getId() == Blocks.JIGSAW.getId())
				.map(tile -> tile.copy(paletteId)).map(this.placement::transformAndSet)
				.peek(tile -> tile.setPos(tile.getPos().add(this.position)))
				.filter(tile -> this.placement.box.contains(tile.getPos()))
				.peek(tile -> JigsawHelper.rotate(tile.getBlockState(), this.placement.rotation))
				.collect(Collectors.toList());

		rand.shuffle(tiles);

		return tiles;
	}

}
