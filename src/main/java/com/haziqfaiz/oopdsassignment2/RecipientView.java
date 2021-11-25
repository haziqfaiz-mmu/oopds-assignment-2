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
    private Recipient activeRecipient = new Recipient();
    public void setActiveRecipient(Recipient recipient){
        this.activeRecipient = recipient;
    }
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

        Text idText = new Text(activeRecipient.getID());
        idText.setFont(new Font("Verdana",20));
        idText.setLayoutX(350);
        idText.setLayoutY(270);

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(new Font("Verdana",20));
        nameLabel.setLayoutX(150);
        nameLabel.setLayoutY(300);

        Text nameText = new Text(activeRecipient.getName());
        nameText.setFont(new Font("Verdana",20));
        nameText.setLayoutX(350);
        nameText.setLayoutY(320);

        Label phoneLabel = new Label("Phone: ");
        phoneLabel.setFont(new Font("Verdana",20));
        phoneLabel.setLayoutX(150);
        phoneLabel.setLayoutY(350);

        Text phoneText = new Text(activeRecipient.getPhone());
        phoneText.setFont(new Font("Verdana",20));
        phoneText.setLayoutX(350);
        phoneText.setLayoutY(370);

        Label statusLabel = new Label("Status: ");
        statusLabel.setFont(new Font("Verdana",20));
        statusLabel.setLayoutX(150);
        statusLabel.setLayoutY(400);

        Text statusText = new Text(activeRecipient.getStatus());
        statusText.setFont(new Font("Verdana",20));
        statusText.setLayoutX(350);
        statusText.setLayoutY(420);

        Label vcIDLabel = new Label("Vaccine Center:P ");
        vcIDLabel.setFont(new Font("Verdana",20));
        vcIDLabel.setLayoutX(150);
        vcIDLabel.setLayoutY(450);

        Text vcIDText = new Text(activeRecipient.getVaccCentrePlacement());
        vcIDText.setFont(new Font("Verdana",20));
        vcIDText.setLayoutX(350);
        vcIDText.setLayoutY(470);

        Label appointmentLabel = new Label("Appointment: ");
        appointmentLabel.setFont(new Font("Verdana",20));
        appointmentLabel.setLayoutX(150);
        appointmentLabel.setLayoutY(500);

        Text appointmentText = new Text(activeRecipient.getAppointmentDate());
        appointmentText.setFont(new Font("Verdana",20));
        appointmentText.setLayoutX(350);
        appointmentText.setLayoutY(520);

        Label firstDoseStatusLabel = new Label("1st status");
        firstDoseStatusLabel.setFont(new Font("Verdana",20));
        firstDoseStatusLabel.setLayoutX(150);
        firstDoseStatusLabel.setLayoutY(550);

        Text firstDoseText = new Text(activeRecipient.getFirstDoseDone());
        firstDoseText.setFont(new Font("Verdana",20));
        firstDoseText.setLayoutX(350);
        firstDoseText.setLayoutY(570);

        Label secondDoseStatusLabel = new Label("2nd status: ");
        secondDoseStatusLabel.setFont(new Font("Verdana",20));
        secondDoseStatusLabel.setLayoutX(150);
        secondDoseStatusLabel.setLayoutY(600);

        Text secondDoseText = new Text(activeRecipient.getSecondDoseDone());
        secondDoseText.setFont(new Font("Verdana",20));
        secondDoseText.setLayoutX(350);
        secondDoseText.setLayoutY(620);

        Label ageLabel = new Label("Age: ");
        ageLabel.setFont(new Font("Verdana",20));
        ageLabel.setLayoutX(150);
        ageLabel.setLayoutY(650);

        Text ageText = new Text(activeRecipient.getAge());
        ageText.setFont(new Font("Verdana",20));
        ageText.setLayoutX(350);
        ageText.setLayoutY(670);

        Label batchLabel = new Label("Vaccine Batch: ");
        batchLabel.setFont(new Font("Verdana",20));
        batchLabel.setLayoutX(150);
        batchLabel.setLayoutY(700);

        Text batchText = new Text(activeRecipient.getBatchNumber());
        batchText.setFont(new Font("Verdana",20));
        batchText.setLayoutX(350);
        batchText.setLayoutY(720);

        Button logOutButton = new Button("Log Out");
        logOutButton.setFont(new Font("Vedana",20));
        logOutButton.setLayoutX(370);
        logOutButton.setLayoutY(800);
        logOutButton.setOnAction(evt -> controller.logOutButtonAction());

        ObservableList listPane = anchorPane.getChildren();

        listPane.addAll(title,idLabel,idText,nameLabel,nameText,phoneLabel,phoneText,statusLabel,statusText,vcIDLabel,vcIDText,
                appointmentLabel,appointmentText,firstDoseText,firstDoseStatusLabel,secondDoseText,secondDoseStatusLabel,ageLabel,ageText,
                batchLabel,batchText,logOutButton);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        return scene;
    }
}
