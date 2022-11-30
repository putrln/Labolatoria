package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    private IWorldMap map;
    public SimulationEngine(MoveDirection[] moves,IWorldMap map, Vector2d [] positions)
    {
        this.moves = moves;
        this.map = map;
        for(Vector2d x : positions )
        {
            map.place(new Animal(map,x));
        }
    }
    @Override
    public void run() {
       IWorldMap map  = this.map;
        int j = map.getAnimals().size();
        System.out.println(map);
        for(int i=0;i<moves.length;i++)
        {
            map.getAnimals().get(i % j).move(moves[i]);
            System.out.println(map);
        }
    }
}
