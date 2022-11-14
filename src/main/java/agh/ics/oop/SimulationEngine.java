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
            if (!map.isOccupied(x))
            {
                map.place(new Animal(map,x));
            }
        }
    }
    @Override
    public void run() {
       RectangularMap map  = (RectangularMap) this.map;
       map.moveAnimals(moves);
    }
}
