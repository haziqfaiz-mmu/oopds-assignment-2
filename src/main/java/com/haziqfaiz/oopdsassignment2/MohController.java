package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;

public class MohController {

    public void logOutButtonAction(){
        LogInView logInView = new LogInView();
        Scene newScene = logInView.logInScene();
        Main.getStage().setTitle("Log In Page");
        Main.getStage().setScene(newScene);
    }
}
