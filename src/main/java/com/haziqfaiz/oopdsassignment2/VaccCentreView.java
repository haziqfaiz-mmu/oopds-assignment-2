package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VaccCentreView {
    private VaccCentreController controller = new VaccCentreController();
    public Scene vcMainScene(){
        AnchorPane anchorPane = new AnchorPane();

        Text title = new Text("MMUSejahtera");
        title.setLayoutX(350);
        title.setLayoutY(100);
        title.setFont(new Font("Verdana",40));
        title.setUnderline(true);
        title.setStrokeWidth(10);

        Button viewAllRecipientButton = new Button("View All Recipient Data");
        viewAllRecipientButton.setFont(new Font("Verdana",20));
        viewAllRecipientButton.setLayoutX(150);
        viewAllRecipientButton.setLayoutY(250);
        viewAllRecipientButton.setPrefWidth(700);

        Button setAppointmentButton = new Button("Set Appointment Date");
        setAppointmentButton.setFont(new Font("Verdana",20));
        setAppointmentButton.setLayoutX(150);
        setAppointmentButton.setLayoutY(300);
        setAppointmentButton.setPrefWidth(700);

        Button viewStatisticsButton = new Button("View Statistics");
        viewStatisticsButton.setFont(new Font("Verdana",20));
        viewStatisticsButton.setLayoutX(150);
        viewStatisticsButton.setLayoutY(350);
        viewStatisticsButton.setPrefWidth(700);

        Button simulationButton = new Button("VC Hall Simulation");
        simulationButton.setFont(new Font("Verdana",20));
        simulationButton.setLayoutX(150);
        simulationButton.setLayoutY(400);
        simulationButton.setPrefWidth(700);

        Button logOutButton = new Button("Log Out");
        logOutButton.setFont(new Font("Vedana",20));
        logOutButton.setLayoutX(370);
        logOutButton.setLayoutY(500);
        logOutButton.setOnAction(evt -> controller.logOutButtonAction());

        ObservableList listPane = anchorPane.getChildren();

        listPane.addAll(title,viewAllRecipientButton,setAppointmentButton,viewStatisticsButton,simulationButton,logOutButton);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        return scene;
    }
}
