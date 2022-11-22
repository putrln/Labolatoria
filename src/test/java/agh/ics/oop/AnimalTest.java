package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AnimalTest {


    @Test
    void Orientation()
    {
        RectangularMap map = new RectangularMap(4,4);

        Animal dog = new Animal(map,new Vector2d(2,2));
        map.place(dog);
        OptionsParser op = new OptionsParser();
        String [] moves = {"r","r","b","r","f","r","l"};
        MoveDirection[] move_dir = op.parse(moves);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertEquals(MapDirection.WEST,dog.getOrientation());
        //------------------------------------------------------
        RectangularMap map2 = new RectangularMap(4,4);
        map2.place(dog);
        dog = new Animal(map2,new Vector2d(2,2));
        op = new OptionsParser();
        String [] moves2 = {"l","r","r","l","l","l","b","b"};
        move_dir = op.parse(moves2);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertEquals(MapDirection.SOUTH,dog.getOrientation());
    }
    @Test
    void Position()
    {
        String [] moves = {"f","f","l","f","f"};
        String [] moves2 = {"b","b","r","f","f","l","f","f","f","f"};
        RectangularMap map = new RectangularMap(4,4);
        Animal dog = new Animal(map,new Vector2d(2,2));
        map.place(dog);
        OptionsParser op = new OptionsParser();
        MoveDirection[] move_dir = op.parse(moves);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(0,4)));
        //------------------------------------------------------
        RectangularMap map2 = new RectangularMap(4,4);
        dog = new Animal(map2,new Vector2d(2,2));
        map2.place(dog);
        op = new OptionsParser();
        move_dir = op.parse(moves2);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(4,4)));


    }
    @Test
    void OutOfMap()
    {
        String [] moves = {"f","f","f","f","f","f","f","f","f"};
        String [] moves2 = {"b","b","b","b","b","b","b","b","b"};
        String [] moves3 = {"r","f","f","f","f","f","f","f","f"};
        String [] moves4 = {"l","f","f","f","f","f","f","f","f"};
        RectangularMap map1 = new RectangularMap(4,4);
        RectangularMap map2 = new RectangularMap(4,4);
        RectangularMap map3 = new RectangularMap(4,4);
        RectangularMap map4 = new RectangularMap(4,4);

        Animal dog = new Animal(map1,new Vector2d(2,2));
        map1.place(dog);
        OptionsParser op = new OptionsParser();
        MoveDirection[] move_dir = op.parse(moves);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(2,4)));

        //---------------------------------------
        dog = new Animal(map2,new Vector2d(2,2));
        map2.place(dog);
        op = new OptionsParser();
        move_dir = op.parse(moves2);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(2,0)));
        //---------------------------------------
        dog = new Animal(map3,new Vector2d(2,2));
        map3.place(dog);
        op = new OptionsParser();
        move_dir = op.parse(moves3);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(4,2)));
        //---------------------------------------
        dog = new Animal(map4,new Vector2d(2,2));
        map4.place(dog);
        op = new OptionsParser();
        move_dir = op.parse(moves4);
        for (MoveDirection move: move_dir)
            dog.move(move);
        assertTrue(dog.isAt(new Vector2d(0,2)));

    }
    @Test
    void Parser()
    {
        String [] moves = {"b","dfdfs","b","f","dfsdfsdf"};
        MoveDirection[] move = {MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.FOWARD};
        OptionsParser op = new OptionsParser();
        MoveDirection[] movesToCompare = op.parse(moves);

        for(int i=0;i<move.length;i++)
        {
            assertEquals(move[i],movesToCompare[i]);
        }


    }
}
