package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width,int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)){
            return (position.precedes(new Vector2d(width,height)) && position.follows(new Vector2d(0,0)));
        }
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        if (animals.size() >= width*height || !this.canMoveTo(animal.getPosition()))
        {
            return false;
        }
        animals.add(animal);
        return true;

    }
    @Override
    public Vector2d[] setMap() {
        return new Vector2d[]{new Vector2d(0,0),new Vector2d(width,height)};
    }

}
