package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public MoveDirection[] parse(String [] args)
    {

          MoveDirection[] map = Arrays.stream(args)
                .map(x -> switch (x)
                        {
                            case "f","foward" -> MoveDirection.FOWARD;
                            case "b","backward" -> MoveDirection.BACKWARD;
                            case "l","left" -> MoveDirection.LEFT;
                            case "r","right" -> MoveDirection.RIGHT;
                            default -> null;

                        })
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);

        return map;

    }
}
