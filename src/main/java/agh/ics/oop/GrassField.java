package agh.ics.oop;

import java.util.Map;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {


    private Map<Vector2d, Grass> grassOnMap = new HashMap<>();

    protected MapBoundary mapBoundary = new MapBoundary();


    public GrassField(int numOfGrass) {

        addGrass(numOfGrass);
        mapBoundary.addElements(grassOnMap.keySet());

    }

    public void objectCollision(Vector2d position) {

        Grass grassToRemove = grassOnMap.get(position);
        if (grassToRemove != null) {
            addSingleGrass(position);
            grassOnMap.remove(grassToRemove.getPosition());
        }
    }

    public void addSingleGrass(Vector2d oldAnimalPosition) {
        List<Vector2d> Combinations = new ArrayList<>();
        for (int x = 0; x < (int) Math.sqrt(grassOnMap.size() * 10); x++) {
            for (int y = 0; y < (int) Math.sqrt(grassOnMap.size() * 10); y++) {
                Combinations.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(Combinations);
        List<Vector2d> oldPosition = new ArrayList<>();
        for (Grass grass : grassOnMap.values()) {
            oldPosition.add(grass.getPosition());
        }
        for (Animal animal : animals.values()) {
            oldPosition.add(animal.getPosition());
        }
        Vector2d newPosition = Combinations.stream().filter(x -> {
            return !oldPosition.contains(x);
        }).findFirst().orElse(null);
        if (newPosition == null){
            grassOnMap.put(oldAnimalPosition,new Grass(oldAnimalPosition));
            mapBoundary.addElement(oldAnimalPosition);
        }
        else {
            grassOnMap.put(newPosition, new Grass(newPosition));
            mapBoundary.addElement(newPosition);
        }


    }

    public void addGrass(int numOfGrass) {
        Random rand = new Random();
        List<Vector2d> Combinations = new ArrayList<>();
        for (int x = 0; x < (int) Math.sqrt(numOfGrass * 10); x++) {
            for (int y = 0; y < (int) Math.sqrt(numOfGrass * 10); y++) {
                Combinations.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(Combinations);

        for (int i = 0; i < numOfGrass; i++) {


            grassOnMap.put(Combinations.get(i),new Grass(Combinations.get(i)));
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
        if (this.canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(mapBoundary);
            mapBoundary.addElement(animal.getPosition());

            return true;
        }
        throw new IllegalArgumentException(animal.getPosition() + " is not valid position");
    }




    @Override
    public IMapElement objectAt(Vector2d position) {
        IMapElement standardObjects = super.objectAt(position);
        if (!(standardObjects == null)) {
            return standardObjects;
        }
        return grassOnMap.get(position);

    }
    @Override
    public Vector2d[] getMapBounds() {
        return mapBoundary.getMapBounds();
    }

    }


