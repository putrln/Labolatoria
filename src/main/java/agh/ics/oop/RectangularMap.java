package agh.ics.oop;


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
        animals.put(animal.getPosition(),animal);
        return true;

    }
    @Override
    public Vector2d[] getMapBounds() {
        return new Vector2d[]{new Vector2d(0,0),new Vector2d(width,height)};
    }

}
