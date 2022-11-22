package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    //nie pakuj trawy i zwierzat do jednej listy

    protected List<Animal> animals = new ArrayList<>();

    public abstract Vector2d[] setMap();

    public String showMap(Vector2d lowerLeft, Vector2d upperRight) {
        MapVisualizer vis = new MapVisualizer(this);
        return vis.draw(lowerLeft,upperRight);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;

    }

    @Override
    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal x: animals)
        {
            if (x.isAt(position)){
                return x;
            }
        }
        return null;
    }
    @Override
    public String toString()
    {

        Vector2d[] mapCoordinates = setMap();
        return showMap(mapCoordinates[0],mapCoordinates[1]);

    }

}
