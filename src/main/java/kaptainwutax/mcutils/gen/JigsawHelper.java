package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.block.BlockState;

import java.util.regex.Pattern;

public class JigsawHelper {

    public static void rotate(BlockState blockState, BlockRotation rotation) {
        String newOrientation = rotation.transform(getFacing(blockState)) + "_" + rotation.transform(getRotation(blockState));
        blockState.getProperties().putString("orientation", newOrientation);
    }

    public static Direction getFacing(BlockState blockState) {
        return Direction.fromString(blockState.getProperties().getString("orientation").split(Pattern.quote("_"))[0]);
    }

    public static Direction getRotation(BlockState blockState) {
        return Direction.fromString(blockState.getProperties().getString("orientation").split(Pattern.quote("_"))[1]);
    }

}
