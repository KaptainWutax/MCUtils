package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.BlockState;
import kaptainwutax.mcutils.util.block.BlockDirection;
import kaptainwutax.mcutils.util.block.BlockRotation;

import java.util.regex.Pattern;

public class JigsawHelper {

	public static void rotate(BlockState blockState, BlockRotation rotation) {
		// we store it as north_south but when unpacked we capitalize it back and apply it as (NORTH, SOUTH)
		String newOrientation = rotation.rotate(getFacing(blockState)).name().toLowerCase() + "_" + rotation.rotate(getRotation(blockState)).name().toLowerCase();
		blockState.getProperties().putString("orientation", newOrientation);
	}

	public static BlockDirection getFacing(BlockState blockState) {
		return BlockDirection.fromString(blockState.getProperties().getString("orientation").split(Pattern.quote("_"))[0]);
	}

	public static BlockDirection getRotation(BlockState blockState) {
		return BlockDirection.fromString(blockState.getProperties().getString("orientation").split(Pattern.quote("_"))[1]);
	}

}
