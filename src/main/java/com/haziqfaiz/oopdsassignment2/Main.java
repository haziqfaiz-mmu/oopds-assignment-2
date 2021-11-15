package com.haziqfaiz.oopdsassignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Log In Page");
        LogInView logInView = new LogInView();

        Scene scene = logInView.logInScene();
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}