package kaptainwutax.mcutils.gen;

import kaptainwutax.mcutils.util.math.Vec3i;
import kaptainwutax.seedutils.lcg.rand.JRand;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Direction {
    
    DOWN("down", Axis.Y, new Vec3i(0, -1, 0)),
    UP("up", Axis.Y, new Vec3i(0, 1, 0)),
    NORTH("north", Axis.Z, new Vec3i(0, 0, -1)),
    SOUTH("south", Axis.Z, new Vec3i(0, 0, 1)),
    WEST("west", Axis.X, new Vec3i(-1, 0, 0)),
    EAST("east", Axis.X, new Vec3i(1, 0, 0));

    private static Direction[] HORIZONTALS = {NORTH, EAST, SOUTH, WEST};
    private static Map<String, Direction> STRING_TO_DIRECTION = Arrays.stream(values())
            .collect(Collectors.toMap(Direction::toString, o -> o));

    private final String name;
    private Direction.Axis axis;
    private Vec3i vec;

    Direction(String name, Direction.Axis axis, Vec3i vec) {
        this.name = name;
        this.axis = axis;
        this.vec = vec;
    }

    public static Direction fromString(String name) {
        return STRING_TO_DIRECTION.get(name.toLowerCase());
    }

    public Direction.Axis getAxis() {
        return this.axis;
    }

    public Vec3i getVector() {
        return this.vec;
    }

    public Direction opposite() {
        return this.ordinal() % 2 == 0 ? values()[this.ordinal() + 1] : values()[this.ordinal() - 1];
    }

    public static Direction randomHorizontal(JRand rand) {
        return HORIZONTALS[rand.nextInt(HORIZONTALS.length)];
    }

    @Override
    public String toString() {
        return this.name;
    }

    public enum Axis {
        X, Y, Z
    }

}
