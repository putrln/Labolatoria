package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    @Test
    void System()
    {
        String [] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        Animal animal = (Animal) map.objectAt(new Vector2d(2,0));
        assertEquals(MapDirection.SOUTH,animal.getOrientation());
        assertTrue(map.isOccupied(new Vector2d(3,5)));
        animal = (Animal)  map.objectAt(new Vector2d(3,5));
        assertEquals(MapDirection.NORTH,animal.getOrientation());

        //-------------------------------------------------------------------------------------
        String [] args2 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(10, 5);
        Vector2d[] positions2 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,1) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();
        assertTrue(map2.isOccupied(new Vector2d(2, 5)));
        animal = (Animal) map2.objectAt(new Vector2d(2,5));
        assertEquals(MapDirection.NORTH,animal.getOrientation());
        assertTrue(map2.isOccupied(new Vector2d(5,4)));
        animal = (Animal)  map2.objectAt(new Vector2d(5,4));
        assertEquals(MapDirection.EAST,animal.getOrientation());
        assertTrue(map2.isOccupied(new Vector2d(9,1)));
        animal = (Animal)  map2.objectAt(new Vector2d(9,1));
        assertEquals(MapDirection.EAST,animal.getOrientation());


    }
}
