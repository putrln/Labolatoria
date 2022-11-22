package agh.ics.oop;


import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class GrassField extends AbstractWorldMap {

    private int numOfGrass;
    //dziedziczenie abstract word map interfejst do abstract of map wszystkie wspolne rzeczy
    private List<Grass> grassOnMap = new ArrayList<>();
    public GrassField(int numOfGrass)
    {
        this.numOfGrass = numOfGrass;
        addGrass();
    }
    public void objectCollision(Vector2d position)
    {
        Grass grassToRemove = grassOnMap.stream().filter(grass -> (grass.getPosition().equals(position))).findFirst().orElse(null);
        if (grassToRemove != null) {
            addSingleGrass();
            grassOnMap.remove(grassToRemove);
        }
    }
    public void addSingleGrass()
    {
        List<Vector2d>Combinations = new ArrayList<>();
        for(int x=0;x<(int) Math.sqrt(numOfGrass * 10);x++)
        {
            for(int y=0;y<(int) Math.sqrt(numOfGrass * 10);y++)
            {
                Combinations.add(new Vector2d(x,y));
            }
        }
        Collections.shuffle(Combinations);
        List<Vector2d> oldPosition = new ArrayList<>();
        for (Grass grass : grassOnMap) {
            oldPosition.add(grass.getPosition());
        }
        for (Animal animal : animals) {
            oldPosition.add(animal.getPosition());
        }
        Vector2d newPosition = Combinations.stream().filter(x ->{
            return !oldPosition.contains(x);
        }).findFirst().orElse(null);
        grassOnMap.add(new Grass(newPosition));

    }
    public void addGrass()
    {
        Random rand = new Random();
        List<Vector2d>Combinations = new ArrayList<>();
        for(int x=0;x<(int) Math.sqrt(numOfGrass * 10);x++)
        {
            for(int y=0;y<(int) Math.sqrt(numOfGrass * 10);y++)
            {
                Combinations.add(new Vector2d(x,y));
            }
        }
        Collections.shuffle(Combinations);
        for(int i=0;i<numOfGrass;i++)
        {
            grassOnMap.add(new Grass(Combinations.get(i)));
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!(objectAt(position) instanceof Animal)) {
            objectCollision(position);
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition()))
        {
            animals.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object standardObjects = super.objectAt(position);
        if (!(standardObjects == null))
        {
            return standardObjects;
        }
        for(Grass x: grassOnMap)
        {
            if (x.getPosition().equals(position))
            {
                return x;
            }
        }
        return null;
        }
    @Override
    public Vector2d[] setMap() {
        List<Vector2d> animalPosition = animals.stream()
                .map(x -> new Vector2d(x.getPosition().x, x.getPosition().y)).toList();
        List<Vector2d> grassPosition = grassOnMap.stream()
                .map(x -> new Vector2d(x.getPosition().x, x.getPosition().y)).toList();
        Vector2d topRight = animalPosition.get(0);
        Vector2d downLeft = animalPosition.get(0);
        for (Vector2d x: animalPosition)
        {
             topRight = x.upperRight(topRight);
             downLeft = x.lowerLeft(downLeft);
        }
        for(Vector2d x: grassPosition)
        {
            topRight = x.upperRight(topRight);
            downLeft = x.lowerLeft(downLeft);
        }
        return new Vector2d[]{downLeft,topRight};

    }
}


