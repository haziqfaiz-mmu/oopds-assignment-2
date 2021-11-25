package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;

public class RegisterController {

    public void backButtonAction(){
        LogInView logInView = new LogInView();
        Scene newScene = logInView.logInScene();
        Main.getStage().setTitle("Log In Page");
        Main.getStage().setScene(newScene);
    }

    public void registerButtonAction(){}
}
