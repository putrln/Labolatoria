package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MapDirectionTest {

    @Test
    void testNorthNext()
    {
        MapDirection map = MapDirection.NORTH;
        assertEquals(MapDirection.EAST,map.next());

    }
    @Test
    void testEastNext()
    {
        MapDirection map = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH,map.next());

    }
    @Test
    void testSouthNext()
    {
        MapDirection map = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST,map.next());

    }
    @Test
    void testWestNext()
    {
        MapDirection map = MapDirection.WEST;
        assertEquals(MapDirection.NORTH,map.next());

    }
    @Test
    void testNorthPrevious()
    {
        MapDirection map = MapDirection.NORTH;
        assertEquals(MapDirection.WEST,map.previous());

    }

    @Test
    void testWestPrevious()
    {
        MapDirection map = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH,map.previous());

    }
    @Test
    void testEastPrevious()
    {
        MapDirection map = MapDirection.EAST;
        assertEquals(MapDirection.NORTH,map.previous());

    }
    @Test
    void testSouthPrevious()
    {
        MapDirection map = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST,map.previous());

    }


}
