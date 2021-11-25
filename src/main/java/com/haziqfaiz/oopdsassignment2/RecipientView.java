package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RecipientView {

    private RecipientController controller = new RecipientController();
    public Scene recipientMainScene(){
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

        Label birthLabel = new Label("Date of Birth: ");
        birthLabel.setFont(new Font("Verdana",20));
        birthLabel.setLayoutX(150);
        birthLabel.setLayoutY(450);

        Label firstDoseStatusLabel = new Label("1st status");
        firstDoseStatusLabel.setFont(new Font("Verdana",20));
        firstDoseStatusLabel.setLayoutX(150);
        firstDoseStatusLabel.setLayoutY(500);

        Label  firstDoseDateLabel= new Label("1st date");
        firstDoseDateLabel.setFont(new Font("Verdana",20));
        firstDoseDateLabel.setLayoutX(150);
        firstDoseDateLabel.setLayoutY(550);

        Label firstDoseBatchLabel = new Label("1st batch");
        firstDoseBatchLabel.setFont(new Font("Verdana",20));
        firstDoseBatchLabel.setLayoutX(150);
        firstDoseBatchLabel.setLayoutY(600);

        Label secondDoseStatusLabel = new Label("2nd status");
        secondDoseStatusLabel.setFont(new Font("Verdana",20));
        secondDoseStatusLabel.setLayoutX(150);
        secondDoseStatusLabel.setLayoutY(650);

        Label  secondDoseDateLabel= new Label("2nd date");
        secondDoseDateLabel.setFont(new Font("Verdana",20));
        secondDoseDateLabel.setLayoutX(150);
        secondDoseDateLabel.setLayoutY(700);

        Label secondDoseBatchLabel = new Label("2nd batch");
        secondDoseBatchLabel.setFont(new Font("Verdana",20));
        secondDoseBatchLabel.setLayoutX(150);
        secondDoseBatchLabel.setLayoutY(750);

        Button logOutButton = new Button("Log Out");
        logOutButton.setFont(new Font("Vedana",20));
        logOutButton.setLayoutX(370);
        logOutButton.setLayoutY(800);
        logOutButton.setOnAction(evt -> controller.logOutButtonAction());

        ObservableList listPane = anchorPane.getChildren();

        listPane.addAll(title,idLabel,passwordLabel,nameLabel,phoneLabel,birthLabel,firstDoseStatusLabel,firstDoseDateLabel,firstDoseBatchLabel,
                secondDoseStatusLabel,secondDoseDateLabel,secondDoseBatchLabel,logOutButton);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        return scene;
    }
}
