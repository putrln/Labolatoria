package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {
    public static void run(Direction[] array)
    {


        for(int i=0;i<array.length;i++)
        {
            switch (array[i])
            {
                case FOWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case IGNORE:
                    break;
            }

        }

    }
    public static Direction[] stringToEnum(String[] args)
    {

        Direction [] array = new Direction[args.length];

        for(int i=0; i<args.length;i++) {
            array[i] = switch (args[i]) {
                case "f" -> Direction.FOWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.IGNORE;

            };
        }
        return array;


    }
    public static void main(String[] args) {


        try {


            Application.launch(App.class, args);


        }
        catch (IllegalArgumentException iea)
        {
            System.out.println(iea.getMessage());
        }




    }


}
