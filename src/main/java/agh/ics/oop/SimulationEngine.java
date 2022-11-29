package agh.ics.oop;
import java.util.List;
public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    private IWorldMap map;
    public SimulationEngine(MoveDirection[] moves,IWorldMap map, Vector2d [] positions)
    {
        this.moves = moves;
        this.map = map;

        for(Vector2d x : positions )
        {
            Animal animal =  new Animal(map,x);
            map.place(animal);
            animal.addObserver((IPositionChangeObserver) map);
        }
    }
    @Override
    public void run() {
       IWorldMap map  = this.map;
        int j = map.getAnimals().size();
        System.out.println(map);
        List <Animal> animals = map.getAnimals().values().stream().toList();
        for(int i=0;i<moves.length;i++)
        {
            animals.get(i % j).move(moves[i]);
            System.out.println(map);
        }
    }
}
