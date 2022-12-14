package agh.ics.oop;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{



    protected HashMap<Vector2d,Animal> animals = new HashMap<>();



    public abstract Vector2d[] getMapBounds();

    public String showMap(Vector2d lowerLeft, Vector2d upperRight) {
        MapVisualizer vis = new MapVisualizer(this);
        return vis.draw(lowerLeft, upperRight);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;

    }

    @Override
    public Map<Vector2d, Animal> getAnimals() {
        return Collections.unmodifiableMap(animals);



    }

    @Override
    public Object objectAt(Vector2d position) {

        return (animals.get(position));



    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,animal);
    }

    @Override
    public String toString()
    {

        Vector2d[] mapCoordinates = getMapBounds();
        return showMap(mapCoordinates[0],mapCoordinates[1]);

    }

}
