package agh.ics.oop;

import java.util.Objects;
import java.util.ArrayList;
public class Animal{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;

    private IWorldMap map;

    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
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
            positionChanged(position,new Vector2d(newPosition.x, newPosition.y));
            this.position = new Vector2d(newPosition.x, newPosition.y);
            }


    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);

    }
    private void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        for(IPositionChangeObserver observer: observers)
        {
            observer.positionChanged(oldPosition,newPosition);
        }
    }




}
