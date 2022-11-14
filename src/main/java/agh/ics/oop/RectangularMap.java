package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private List<Animal> animals = new ArrayList<>();
    public RectangularMap(int width,int height) {
        this.width = width;
        this.height = height;
    }
    public List<Animal> getAnimals()
    {
        return animals;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)){
            if (position.x <= width && position.y <= height && position.x >= 0 && position.y >=0)
            {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (animals.size() >= width*height)
        {
            return false;
        }
        animals.add(animal);
        return true;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal x: animals )
        {
            if (x.isAt(position)){
                return true;
            }
        }
        return false;
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
    public void moveAnimals(MoveDirection[] moves)
    {
        int j =0;
        for(int i=0;i<moves.length;i++)
        {
            if (j == animals.size())
            {
                j = 0;
            }
            animals.get(j).move(moves[i]);
            j+=1;


        }
    }

    @Override
    public String toString() {
        MapVisualizer vis = new MapVisualizer(this);
        return vis.draw(new Vector2d(0,0),new Vector2d(width,height));

    }

}
