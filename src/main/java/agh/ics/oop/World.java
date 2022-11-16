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
        //jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu:
        //Można stworzyć statyczne pole które będzie zawierało pozycje stworzonych już zwierząt
        //i przed ruchem za kaźdym razem sprawdzać czy nie wchodzimy na czyjeś pole
        OptionsParser op = new OptionsParser();
        MoveDirection[] MoveTab = op.parse(args);
        Animal dog = new Animal();

        for(MoveDirection mov : MoveTab)
        {
            System.out.println(mov);
            dog.move(mov);

        }

        System.out.println(dog);
    }


}
