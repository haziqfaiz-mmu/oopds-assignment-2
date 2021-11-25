package com.haziqfaiz.oopdsassignment2;

import javafx.scene.Scene;

import java.io.IOException;

public class RegisterController {

    public void backButtonAction() {
        LogInView logInView = new LogInView();
        Scene newScene = logInView.logInScene();
        Main.getStage().setTitle("Log In Page");
        Main.getStage().setScene(newScene);
    }

    public void registerButtonAction(String id, String password, String name, String phone, String age) throws IOException {
        Recipient newRecipient = new Recipient(id, password, name, phone, age);

        Recipient.register(id, password, name, phone, age);
    }
}