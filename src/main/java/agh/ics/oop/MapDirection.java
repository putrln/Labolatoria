package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;


    public MapDirection next()
    {
        MapDirection map = switch (this) {
            case NORTH ->  EAST;
            case SOUTH ->  WEST;
            case EAST ->   SOUTH;
            case WEST ->   NORTH;

        };
    return map;
    }
    public MapDirection previous()
    {
        MapDirection map = switch (this) {
            case NORTH ->  WEST;
            case SOUTH ->  EAST;
            case EAST ->   NORTH;
            case WEST ->   SOUTH;

        };
        return map;
    }
    public Vector2d toUnitVector()
    {
        Vector2d newVector = switch (this) {
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);


        };
        return newVector;

    }
    @Override
    public String toString() {
        String ret = switch (this) {

            case NORTH ->  "Północ";
            case SOUTH ->  "Południe";
            case EAST ->   "Wschód";
            case WEST ->   "Zachód";

        };

        return ret;
    }
}
