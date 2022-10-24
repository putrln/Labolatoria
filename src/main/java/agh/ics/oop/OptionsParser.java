package agh.ics.oop;

import java.util.Objects;

public class OptionsParser {
    public MoveDirection[] parse(String [] args)
    {

        int dir_len = 0;
        for (int i=0;i<args.length;i++) {
            if (Objects.equals(args[i], "f") || Objects.equals(args[i], "foward") || Objects.equals(args[i], "b") || Objects.equals(args[i], "backward") || Objects.equals(args[i], "l") || Objects.equals(args[i], "left") || Objects.equals(args[i], "r") || Objects.equals(args[i], "right"))
                dir_len += 1;
            else
                args[i] = "";
        }
        MoveDirection[] direction = new MoveDirection[dir_len];
        int index= 0;

        for(String arg : args)
        {
            if (!arg.isEmpty()){

                direction[index] = switch (arg){
                  case "f","foward" -> MoveDirection.FOWARD;
                  case "b","backward" -> MoveDirection.BACKWARD;
                  case "l","left" -> MoveDirection.LEFT;
                  case "r","right" -> MoveDirection.RIGHT;
                  default -> null;

                };
                index+=1;

            }


        }

        return direction;


    }
}
