package kaptainwutax.mcutils.gen;

public enum BlockRotation {
    NONE, CLOCKWISE_90, CLOCKWISE_180, COUNTERCLOCKWISE_90;

    public Direction transform(Direction direction) {
        if(direction.getAxis() == Direction.Axis.Y || this == NONE) {
            return direction;
        } else if(this == CLOCKWISE_180) {
            return direction.opposite();
        } else if(this == CLOCKWISE_90) {
            if(direction == Direction.NORTH)return Direction.EAST;
            else if(direction == Direction.EAST)return Direction.SOUTH;
            else if(direction == Direction.SOUTH)return Direction.WEST;
            else if(direction == Direction.WEST)return Direction.NORTH;
        } else if(this == COUNTERCLOCKWISE_90) {
            if(direction == Direction.NORTH)return Direction.WEST;
            else if(direction == Direction.WEST)return Direction.SOUTH;
            else if(direction == Direction.SOUTH)return Direction.EAST;
            else if(direction == Direction.EAST)return Direction.NORTH;
        }

        return direction;
    }

}
