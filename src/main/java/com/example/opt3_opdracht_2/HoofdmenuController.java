package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HoofdmenuController {

    private Medewerker medewerker;
    private FXMLLoader loader;
    private SceneSwitcher SceneSwitch;

    @FXML
    private Label MedewerkersLabel;



    public void initialize(Medewerker medewerker){
        SceneSwitch = new SceneSwitcher();
        this.medewerker = medewerker;
        initLabel();
    }



    private void initLabel(){
        MedewerkersLabel.setText("Welcome: " + medewerker.getNaam());
    }

    @FXML
    protected void onOverzichtBtnClick() throws IOException {
        setLoader("overzicht-view.fxml");
        NaarOverzicht();
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


    private void setLoader(String fxmlPath){
        loader.setLocation(getClass().getResource(fxmlPath));
    }

    private void NaarOverzicht() throws IOException {
        setSceneSwitch();
        OverzichtController controller = loader.getController();
        controller.initialize();
        SwitchScenes();
    }


    private void NaarBeheer() throws IOException {
        setSceneSwitch();
        OverzichtController controller = loader.getController();
        controller.initialize();
        SwitchScenes();
    }


    private void setSceneSwitch() throws IOException {
        loader = new FXMLLoader();
        SceneSwitch.setLoader(loader);
        SceneSwitch.setNode(MedewerkersLabel);
        SceneSwitch.PrepareStage();
    }

    private void SwitchScenes(){
        SceneSwitch.CallStage();
    }


}
