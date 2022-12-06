package agh.ics.oop;
import java.util.*;

public class MapBoundary implements  IPositionChangeObserver {

    private TreeSet<Vector2d> objectPositionX = new TreeSet<>((a,b) ->
    {
        if (a.x < b.x)  return -1;
        if (a.x > b.x) return 1;
        return a.equals(b) ? 0:1;
    });
    private TreeSet<Vector2d> objectPositionY = new TreeSet<>((a,b) ->
    {
        if (a.y < b.y) return -1;
        if (a.y > b.y) return 1;
        return a.equals(b) ? 0 : 1;
    });

    public void addElements(Set<Vector2d> positions) {

        for (Vector2d position : positions) {
            objectPositionX.add(position);
            objectPositionY.add(position);
        }

    }

    public void addElement(Vector2d position)
    {

        objectPositionX.add(position);
        objectPositionY.add(position);

    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objectPositionX.remove(oldPosition);
        objectPositionY.remove(oldPosition);
        objectPositionX.add(newPosition);
        objectPositionY.add(newPosition);

    }

    public Vector2d[] getMapBounds()
    {

        Vector2d topRight = objectPositionX.last().upperRight(objectPositionY.last());
        Vector2d lowLeft = objectPositionX.first().lowerLeft(objectPositionY.first());

        return new Vector2d[]{lowLeft,topRight};

    }





    }

