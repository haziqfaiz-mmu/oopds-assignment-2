package com.haziqfaiz.oopdsassignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }
    @Override
    public void start(Stage stage) throws IOException {

        guiStage = stage;
        stage.setTitle("Log In Page");
        LogInView logInView = new LogInView();
        RecipientView recipientView = new RecipientView();
        MohView mohView = new MohView();
        VaccCentreView vcView = new VaccCentreView();

        Scene scene = logInView.logInScene();
        //Scene scene = recipientView.recipientMainScene();
        //Scene scene = mohView.mohMainScene();
        //Scene scene = vcView.vcMainScene();
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}