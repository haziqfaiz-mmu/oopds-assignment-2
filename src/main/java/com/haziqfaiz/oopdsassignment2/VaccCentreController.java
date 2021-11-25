package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VaccCentreController {

    public void logOutButtonAction(){
        LogInView logInView = new LogInView();
        Scene newScene = logInView.logInScene();
        Main.getStage().setTitle("Log In Page");
        Main.getStage().setScene(newScene);
    }

    public void simulationButtonAction(){

    }
}
