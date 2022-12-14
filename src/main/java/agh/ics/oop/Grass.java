package agh.ics.oop;

import java.util.ArrayList;

public class Grass {

    private Vector2d position;
    public Grass(Vector2d position)
    {
        this.position = position;

    }
    public Vector2d getPosition()
    {
        return this.position;
    }



    @Override
    public String toString() {
        return "*";
    }
}
