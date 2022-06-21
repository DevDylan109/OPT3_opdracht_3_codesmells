package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HoofdmenuController {

    private Medewerker medewerker;

    @FXML
    private Label MedewerkersLabel;

    @FXML
    private Button OverzichtButton;

    @FXML
    private Button BeheerButton;

    @FXML
    private Button LoguitButton;



    public void initMedewerker(Medewerker medewerker){
        this.medewerker = medewerker;
        initLabel();
    }

    private void initLabel(){
        MedewerkersLabel.setText("Welcome: " + medewerker.getNaam());
    }



}
