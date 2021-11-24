package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LogInView {

    public Scene logInScene(){
        Text mmmuSejahtera = new Text("Welcome to MMUSejahtera");
        mmmuSejahtera.setFont(new Font("Verdana",100));
        Label label = new Label("Hello World, JavaFX !");
        AnchorPane anchorPane  = new AnchorPane();
        label.setLayoutX(100);
        mmmuSejahtera.setLayoutY(100);
        mmmuSejahtera.setLayoutX(200);
        label.setFont(new Font("Verdana",50));
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(mmmuSejahtera);
        Scene scene = new Scene(anchorPane,600, 200);
        return scene;
    }
}
