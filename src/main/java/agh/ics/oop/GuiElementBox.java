package agh.ics.oop;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileInputStream;
public class GuiElementBox {

    private Image image;
    private ImageView imageView;
    private IMapElement element;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        this.element = element;
        this.image = new Image(new FileInputStream(element.getResources()));
        this.imageView = new ImageView(image);





    }

    public VBox getImageView() throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getResources()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(imageView);
        //switch
        if (element instanceof Animal) {
            Label label = new Label("Z" + element.getPosition());
            vbox.getChildren().add(label);
            vbox.setCenterShape(true);
        }
        else{
            Label label = new Label("T" + element.getPosition());
            vbox.getChildren().add(label);
            vbox.setCenterShape(true);

        }

        return vbox;
    }
}
