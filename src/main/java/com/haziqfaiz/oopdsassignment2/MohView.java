package com.haziqfaiz.oopdsassignment2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MohView {

    private MohController controller = new MohController();
    public Scene mohMainScene(){
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

        Button distributeVaccineButton = new Button("Distribute Vaccine");
        distributeVaccineButton.setFont(new Font("Verdana",20));
        distributeVaccineButton.setLayoutX(150);
        distributeVaccineButton.setLayoutY(300);
        distributeVaccineButton.setPrefWidth(700);

        Button distributeRecipientButton = new Button("Distribute Recipient");
        distributeRecipientButton.setFont(new Font("Verdana",20));
        distributeRecipientButton.setLayoutX(150);
        distributeRecipientButton.setLayoutY(350);
        distributeRecipientButton.setPrefWidth(700);

        Button viewStatisticsButton = new Button("View Statistics");
        viewStatisticsButton.setFont(new Font("Verdana",20));
        viewStatisticsButton.setLayoutX(150);
        viewStatisticsButton.setLayoutY(400);
        viewStatisticsButton.setPrefWidth(700);

        Button createVCButton = new Button("Add Vaccination Center");
        createVCButton.setFont(new Font("Verdana",20));
        createVCButton.setLayoutX(150);
        createVCButton.setLayoutY(450);
        createVCButton.setPrefWidth(700);

        Button logOutButton = new Button("Log Out");
        logOutButton.setFont(new Font("Vedana",20));
        logOutButton.setLayoutX(450);
        logOutButton.setLayoutY(500);
        logOutButton.setOnAction(evt -> controller.logOutButtonAction());

        ObservableList listPane = anchorPane.getChildren();

        listPane.addAll(title,viewAllRecipientButton,distributeVaccineButton,viewStatisticsButton,logOutButton,createVCButton,distributeRecipientButton);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        return scene;
    }
}
