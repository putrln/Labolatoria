package agh.ics.oop;

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
        System.out.println("system wystartował");
        run(stringToEnum(args));
        System.out.println("system zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

    }


}
