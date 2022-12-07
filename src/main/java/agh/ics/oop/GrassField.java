package agh.ics.oop;

import java.util.Map;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {


    private Map<Vector2d, Grass> grassOnMap = new HashMap<>();

    public GrassField(int numOfGrass) {
        addGrass(numOfGrass);
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
        }
        else {
            grassOnMap.put(newPosition, new Grass(newPosition));
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
            return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object standardObjects = super.objectAt(position);
        if (!(standardObjects == null)) {
            return standardObjects;
        }
        return grassOnMap.get(position);

    }
        @Override
        public Vector2d[] getMapBounds () {
            List<Vector2d> animalPosition = animals.keySet().stream().toList();
            List<Vector2d>  grassPosition = grassOnMap.keySet().stream().toList();
            Vector2d topRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
            Vector2d downLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
            for (Vector2d x : animalPosition) {
                topRight = x.upperRight(topRight);
                downLeft = x.lowerLeft(downLeft);
            }
            for (Vector2d x : grassPosition) {
                topRight = x.upperRight(topRight);
                downLeft = x.lowerLeft(downLeft);
            }
            return new Vector2d[]{downLeft, topRight};

        }
    }


