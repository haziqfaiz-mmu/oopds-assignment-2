package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class RegisterView {

    public RegisterController controller = new RegisterController();

    public Scene registerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Text title = new Text("MMUSejahtera");
        title.setLayoutX(350);
        title.setLayoutY(100);
        title.setFont(new Font("Verdana",40));
        title.setUnderline(true);
        title.setStrokeWidth(10);

        Label idLabel = new Label("IC/Passport: ");
        idLabel.setFont(new Font("Verdana",20));
        idLabel.setLayoutX(150);
        idLabel.setLayoutY(250);

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(new Font("Verdana",20));
        passwordLabel.setLayoutX(150);
        passwordLabel.setLayoutY(300);

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(new Font("Verdana",20));
        nameLabel.setLayoutX(150);
        nameLabel.setLayoutY(350);

        Label phoneLabel = new Label("Phone: ");
        phoneLabel.setFont(new Font("Verdana",20));
        phoneLabel.setLayoutX(150);
        phoneLabel.setLayoutY(400);

        Label ageLabel = new Label("Age: ");
        ageLabel.setFont(new Font("Verdana",20));
        ageLabel.setLayoutX(150);
        ageLabel.setLayoutY(450);

        /*DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Please choose Date of Birth");
        datePicker.setLayoutX(300);
        datePicker.setLayoutY(450);
        datePicker.setPrefWidth(400);*/

        TextField idField = new TextField();
        idField.setPromptText("Please enter your IC/Passport Number");
        idField.setLayoutX(300);
        idField.setLayoutY(250);
        idField.setPrefWidth(300);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Please enter your password");
        passwordField.setLayoutX(300);
        passwordField.setLayoutY(300);
        passwordField.setPrefWidth(300);

        TextField nameField = new TextField();
        nameField.setPromptText("Please enter your name");
        nameField.setLayoutX(300);
        nameField.setLayoutY(350);
        nameField.setPrefWidth(300);

        TextField phoneField = new TextField();
        phoneField.setPromptText("Please enter your IC/Passport Number");
        phoneField.setLayoutX(300);
        phoneField.setLayoutY(400);
        phoneField.setPrefWidth(300);

        TextField ageField = new TextField();
        ageField.setPromptText("Please enter your age");
        ageField.setLayoutX(300);
        ageField.setLayoutY(450);
        ageField.setPrefWidth(300);


        Button registerButton = new Button("Register");
        registerButton.setFont(new Font("Vedana",20));
        registerButton.setLayoutX(400);
        registerButton.setLayoutY(500);
        registerButton.setOnAction(evt -> {
            String id = idField.getText();
            String password = passwordField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();
            String age = ageField.getText();

            try {
                controller.registerButtonAction(id,password,name,phone,age);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        Button backButton = new Button("Back to log in");
        backButton.setFont(new Font("Vedana",20));
        backButton.setLayoutX(370);
        backButton.setLayoutY(550);
        backButton.setOnAction(evt -> controller.backButtonAction());

        ObservableList listPane = anchorPane.getChildren();

        listPane.addAll(title,idLabel,passwordLabel,nameLabel,phoneLabel,idField,passwordField,nameField,phoneField,registerButton,backButton,ageField,ageLabel);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        return scene;
    }
}
