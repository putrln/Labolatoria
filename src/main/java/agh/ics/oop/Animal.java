package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;

    private IWorldMap map;

    public Animal(IWorldMap map,Vector2d initialPosition)
    {
        this.map = map;
        this.position = new Vector2d(initialPosition.x, initialPosition.y);

    }


    @Override
    public String toString() {
        return switch (orientation)
                {
                    case NORTH -> "N";
                    case SOUTH -> "S";
                    case WEST -> "W";
                    case EAST -> "E";
                };
    }


    public Boolean isAt(Vector2d position) {
        return Objects.equals(this.position, position);

    }

    public MapDirection getOrientation() {
        return orientation;
    }
    public Vector2d getPosition() { return position; }
    public void move(MoveDirection direction)
    {
        Vector2d newPosition = new Vector2d(position.x, position.y);

        switch(direction)
        {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FOWARD -> newPosition = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.orientation.toUnitVector());

        }
            if (map.canMoveTo(newPosition)) {
            this.position = new Vector2d(newPosition.x, newPosition.y);
            }


    }




}
