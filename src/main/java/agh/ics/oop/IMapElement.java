package agh.ics.oop;

import java.io.FileNotFoundException;

public interface IMapElement {

    public Vector2d getPosition();

    public String getResources();

    public GuiElementBox getToDisplay();

    default GuiElementBox loadImg()
    {
        try {
            return  new GuiElementBox(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}



