package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;
import javafx.scene.control.Label;

public class LogInView {

    public Scene logInScene(){
        Label label = new Label("Hello World, JavaFX !");
        Scene scene = new Scene(label, 600, 200);
        return scene;
    }
}
