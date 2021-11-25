package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class LogInView {

   public LogInController controller =  new LogInController();
    public Scene logInScene(){
        AnchorPane root = new AnchorPane();

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

        Button logInButton = new Button("Log In");
        logInButton.setFont(new Font("Vedana",20));
        logInButton.setLayoutX(400);
        logInButton.setLayoutY(350);
        logInButton.setLayoutY(350);

        logInButton.setOnAction(evt -> controller.loginButtonAction());

        Text text1 = new Text("Not Registered? Register");
        text1.setFont(new Font("Verdana", 20));
        Hyperlink registerLink = new Hyperlink("Now");
        registerLink.setFont(new Font("Verdana", 20));
        registerLink.setOnAction(evt -> controller.registerLinkAction());
        TextFlow registerText = new TextFlow();
        ObservableList listTextFlow = registerText.getChildren();
        listTextFlow.addAll(text1, registerLink);
        registerText.setLayoutX(300);
        registerText.setLayoutY(400);

        ObservableList listPane = root.getChildren();

        listPane.addAll(title,idLabel,passwordLabel,idField,passwordField,logInButton,registerText);
        Scene scene = new Scene(root, 1000, 1000);
        return scene;
    }
}
