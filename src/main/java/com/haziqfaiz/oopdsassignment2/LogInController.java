package com.haziqfaiz.oopdsassignment2;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogInController {

    private Stage stage = new Stage();
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void loginButtonAction(){

    }

    public void registerLinkAction(){
        RegisterView registerView = new RegisterView();
        Scene newScene = registerView.registerScene();
        Main.getStage().setTitle("Registration Page");
        Main.getStage().setScene(newScene);
    }
}
