package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application
{
    AbstractWorldMap map;
    Vector2d[] positions;

    @Override
    public void init() throws Exception {

            map = new GrassField(4);
            System.out.println(map);
            positions = new Vector2d[]{new Vector2d(-3, 2), new Vector2d(3, 4)};
            Animal kot = new Animal(map,new Vector2d(3,4));
            map.place(kot);
            kot.addObserver(map);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        System.out.println(map);
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Vector2d[] vec= map.getMapBounds();
        int height = Math.abs(vec[0].y - vec[1].y) + 1;
        int width = Math.abs(vec[0].x - vec[1].x) + 1;
        int tmpVecPositionX = vec[0].x;
        int tmpVecPositionY = vec[1].y;
        int relVecPositionX = vec[0].x;
        int relVecPositionY = vec[1].y + 1;
        for (int i = 0; i <= height; i++) {
            relVecPositionX = vec[0].x;
            for (int j = 0; j <= width; j++) {

                if (i ==0 && j==0)
                {
                    Label label = new Label("y/x");
                    gridPane.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                else if(j == 0) {
                    Label label = new Label(tmpVecPositionY+"");
                    gridPane.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    tmpVecPositionY-=1;

                }
                else if(i == 0) {
                    Label label = new Label(tmpVecPositionX + "");
                    gridPane.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    tmpVecPositionX += 1;
                }
                else if (map.isOccupied(new Vector2d(relVecPositionX,relVecPositionY))) {
                    Object object = map.objectAt(new Vector2d(relVecPositionX,relVecPositionY));
                    if (object instanceof Grass) {
                        Label label = new Label("*");
                        gridPane.add(label, j, i);
                        GridPane.setHalignment(label, HPos.CENTER);

                    }
                    else if (object instanceof Animal) {
                        Label label = new Label(object.toString());
                        gridPane.add(label, j, i);
                        GridPane.setHalignment(label, HPos.CENTER);
                    }
                    relVecPositionX += 1;

                }
                else {

                    Label label = new Label("    ");
                    gridPane.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    relVecPositionX+=1;

                }
            }
            relVecPositionY-=1;
        }


        Scene scene = new Scene(gridPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
