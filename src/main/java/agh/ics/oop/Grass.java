package agh.ics.oop;

import java.util.ArrayList;

public class Grass implements IMapElement {

    private Vector2d position;

    private GuiElementBox toDisplay;
    public Grass(Vector2d position)
    {
        this.position = position;
        this.toDisplay = loadImg();

    }
    public Vector2d getPosition()
    {
        return this.position;
    }

    @Override
    public String getResources() {
        return "src/main/resources/grass.png";
    }

    @Override
    public GuiElementBox getToDisplay() {
        return toDisplay;
    }


    @Override
    public String toString() {
        return "*";
    }
}
