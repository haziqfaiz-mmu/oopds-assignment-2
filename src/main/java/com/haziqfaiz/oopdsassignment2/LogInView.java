package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class LogInView {

    public Scene logInScene(){
        Label label = new Label("Hello World, JavaFX !");
        AnchorPane anchorPane  = new AnchorPane();
        label.setLayoutX(100);
        anchorPane.getChildren().add(label);
        Scene scene = new Scene(anchorPane,600, 200);
        return scene;
    }
}
