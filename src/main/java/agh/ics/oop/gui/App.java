package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.concurrent.TransferQueue;

public class App extends Application implements IPositionChangeObserver {
    private AbstractWorldMap map;
    private MoveDirection[] directions;
    private Vector2d[] positions;
    private GridPane grid = null;
    int i = 3;
    @Override
    public void init() throws Exception {

        this.directions = new OptionsParser().parse(getParameters().getRaw().toArray(String[]::new));
        this.map = new GrassField(6);
        this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
        this.grid = new GridPane();


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IEngine engine = new SimulationEngine(directions, map, positions, this);
        engine.run();
        System.out.println(map);
        Scene scene = new Scene(grid);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        grid.setGridLinesVisible(true);

    }


    public void setMap() throws FileNotFoundException {




        Vector2d[] vec = map.getMapBounds();
        int height = Math.abs(vec[0].y - vec[1].y) + 1;
        int width = Math.abs(vec[0].x - vec[1].x) + 1;
        int tmpVecPositionX = vec[0].x;
        int tmpVecPositionY = vec[1].y;
        int relVecPositionX = vec[0].x;
        int sizeHeightColumn = 40;
        int sizeWidthColumn = 40;
        int relVecPositionY = vec[1].y + 1;


        for (int i = 0; i <= height; i++) {
            relVecPositionX = vec[0].x;
            for (int j = 0; j <= width; j++) {

                if (i == 0 && j == 0) {
                    Label label = new Label("y/x");
                    label.setPrefWidth(sizeWidthColumn);
                    label.setPrefHeight(sizeHeightColumn);
                    grid.add(label, j, i);

                    GridPane.setHalignment(label, HPos.CENTER);
                } else if (j == 0) {
                    Label label = new Label(tmpVecPositionY + "");
                    label.setPrefWidth(sizeWidthColumn);
                    label.setPrefHeight(sizeHeightColumn);
                    grid.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    tmpVecPositionY -= 1;

                } else if (i == 0) {
                    Label label = new Label(tmpVecPositionX + "");
                    label.setPrefWidth(sizeWidthColumn);
                    label.setPrefHeight(sizeHeightColumn);
                    grid.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    tmpVecPositionX += 1;
                } else if (map.isOccupied(new Vector2d(relVecPositionX, relVecPositionY))) {
                    IMapElement object = map.objectAt(new Vector2d(relVecPositionX, relVecPositionY));
                    if (object instanceof Grass) {
                        Label label = new Label("");
                        label.setGraphic(object.getToDisplay().getImageView());
                        label.setPrefWidth(sizeWidthColumn);
                        label.setPrefHeight(sizeHeightColumn);
                        grid.add(label, j, i);
                        GridPane.setHalignment(label, HPos.CENTER);


                    } else if (object instanceof Animal) {
                        Label label = new Label("");
                        label.setGraphic(object.getToDisplay().getImageView());
                        label.setPrefWidth(sizeWidthColumn);
                        label.setPrefHeight(sizeHeightColumn);
                        grid.add(label, j, i);
                        GridPane.setHalignment(label, HPos.CENTER);
                    }
                    relVecPositionX += 1;

                } else {


                    Label label = new Label("");
                    label.setPrefWidth(sizeWidthColumn);
                    label.setPrefHeight(sizeHeightColumn);
                    grid.add(label, j, i);
                    GridPane.setHalignment(label, HPos.CENTER);
                    relVecPositionX += 1;

                }
            }
            relVecPositionY -= 1;
        }


    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    grid.requestLayout();
                    grid.getChildren().retainAll(grid.getChildren().get(0));
                    setMap();

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}