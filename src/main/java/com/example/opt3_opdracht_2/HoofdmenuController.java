package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HoofdmenuController {

    private Medewerker medewerker;

    @FXML
    private Label MedewerkersLabel;




    public void initMedewerker(Medewerker medewerker){
        this.medewerker = medewerker;
        initLabel();
    }

    private void initLabel(){
        MedewerkersLabel.setText("Welcome: " + medewerker.getNaam());
    }

    @FXML
    protected void onOverzichtBtnClick() throws IOException {
        String Overzichtfxml = "overzicht-view.fxml";
        NextScene(Overzichtfxml);
    }
    @FXML
    protected void onBeheerBtnClick(){
        //open new scene
    }
    @FXML
    protected void onUitloggenBtnClick(){
        Stage stage = (Stage) MedewerkersLabel.getScene().getWindow();
        stage.close();
    }


    private void NextScene(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) MedewerkersLabel.getScene().getWindow();

//        //acces the controller and call a method
//        HoofdmenuController controller = loader.getController();
//        controller.initMedewerker(medewerker);

        //switch scenes
        stage.setScene(scene);
        stage.show();
    }

}
