package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Platform;
import javafx.scene.Scene;
import java.util.concurrent.ExecutorService;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moves;
    private IWorldMap map;
    private App app;
    private Executor service = Executors.newCachedThreadPool();
    public SimulationEngine(MoveDirection[] moves,IWorldMap map, Vector2d [] positions,App app)
    {

        this.moves = moves;
        this.map = map;
        this.app = app;

        for(Vector2d x : positions )
        {
            Animal animal =  new Animal(map,x);
            map.place(animal);
            animal.addObserver(map);

        }
    }
    @Override
    public void run() {
        ExecutorService executor =Executors.newSingleThreadExecutor();

       IWorldMap map  = this.map;
        int j = map.getAnimals().size();
        System.out.println(map);
        List <Animal> animals = map.getAnimals().values().stream().toList();
        for(int i=0;i<moves.length;i++)
        {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    animals.get(finalI % j).move(moves[finalI]);
                    System.out.println(map);
                }
            });

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    app.positionChanged(new Vector2d(3,3),new Vector2d(4,4));
                }
            });


        }
    }
}
