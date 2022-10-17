package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Vector2dTest {

    @Test
    void testEquals()
    {
        Vector2d vec = new Vector2d(2,2);
        Vector2d vec2 = new Vector2d(2,2);
        assertEquals(true,vec.equals(vec2));


    }
    @Test
    void testToString()
    {
        Vector2d vec = new Vector2d(2,3);

        assertEquals("(2,3)",vec.toString());


    }
    @Test
    void testprecedes()
    {
        Vector2d vec = new Vector2d(4,6);
        Vector2d vec2 = new Vector2d(6,9 );
        assertEquals(true,vec.precedes(vec2));


    }
    @Test
    void testfollows()
    {
        Vector2d vec = new Vector2d(10,12);
        Vector2d vec2 = new Vector2d(6,9 );
        assertEquals(true,vec.follows(vec2));


    }
    @Test
    void testUpperRight()
    {
        Vector2d vec = new Vector2d(10,7);
        Vector2d vec2 = new Vector2d(6,9 );
        Vector2d vec3 = vec.upperRight(vec2);

        assertEquals(true,vec3.equals(new Vector2d(10,9)));

    }
    @Test
    void testLowerLeft()
    {
        Vector2d vec = new Vector2d(3,12);
        Vector2d vec2 = new Vector2d(6,9 );
        Vector2d vec3 = vec.lowerLeft(vec2);
        assertEquals(true,vec3.equals(new Vector2d(3,9)));


    }
    @Test
    void testAdd()
    {
        Vector2d vec = new Vector2d(3,12);
        Vector2d vec2 = new Vector2d(6,9 );
        Vector2d vec3 = vec.add(vec2);
        assertEquals(true,vec3.equals(new Vector2d(9,21)));


    }
    @Test
    void testSubtract()
    {
        Vector2d vec = new Vector2d(10,12);
        Vector2d vec2 = new Vector2d(6,9 );
        Vector2d vec3 = vec.subtract(vec2);
        assertEquals(true,vec3.equals(new Vector2d(4,3)));


    }
    @Test
    void testOpposite()
    {
        Vector2d vec = new Vector2d(10,12);
        vec = vec.opposite();
        assertEquals(true,vec.equals(new Vector2d(-10,-12)));


    }










}
