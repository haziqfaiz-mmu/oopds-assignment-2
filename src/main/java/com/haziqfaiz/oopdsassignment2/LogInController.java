package com.haziqfaiz.oopdsassignment2;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    private Stage stage = new Stage();
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void loginButtonAction(String id, String password) throws IOException {
        System.out.println(id);
        System.out.println(password);

        if(id.isEmpty()||password.isEmpty()) System.out.println("Empty");

        Recipient activeRecipient= Recipient.login(id,password);
        if (activeRecipient!=null){
            RecipientView recipientView = new RecipientView();
            recipientView.setActiveRecipient(activeRecipient);
            Scene newScene = recipientView.recipientMainScene();
            Main.getStage().setTitle("Recipient View");
            Main.getStage().setScene(newScene);
        }
    }

    public void registerLinkAction(){
        RegisterView registerView = new RegisterView();
        Scene newScene = registerView.registerScene();
        Main.getStage().setTitle("Registration Page");
        Main.getStage().setScene(newScene);
    }

    public void vc1LinkAction() throws IOException {

        VaccCentreView vaccCentreView = new VaccCentreView();
        vaccCentreView.setActiveVC(VaccCentre.getVaccCentreByIndex(0));
        Scene newScene = vaccCentreView.vcMainScene();
        Main.getStage().setTitle("Vaccination Centre View");
        Main.getStage().setScene(newScene);
    }

    public void vc2LinkAction() throws IOException {
        VaccCentreView vaccCentreView = new VaccCentreView();
        vaccCentreView.setActiveVC(VaccCentre.getVaccCentreByIndex(1));
        Scene newScene = vaccCentreView.vcMainScene();
        Main.getStage().setTitle("Vaccination Centre View");
        Main.getStage().setScene(newScene);
    }

    public void mohLinkAction(){
        MohView mohView = new MohView();
        Scene newScene = mohView.mohMainScene();
        Main.getStage().setTitle("MOH Page");
        Main.getStage().setScene(newScene);
    }
}
