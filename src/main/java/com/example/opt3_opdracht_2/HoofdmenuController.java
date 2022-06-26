package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HoofdmenuController {

    private Medewerker medewerker;
    //private FXMLLoader loader;
    private SceneSwitcher SceneSwitch;
    private ProductList productlist;
    private Login loginInstance;

    @FXML
    private Label MedewerkersLabel;



    public void initialize(Data data){
        SceneSwitch = new currentSceneSwitcher();
        this.medewerker = data.getMedewerker();
        this.productlist = data.getProductList();
        initLabel();
    }



    private void initLabel(){
        MedewerkersLabel.setText("Welcome: " + medewerker.getNaam());
    }

    public void initLogin(Login login){
        this.loginInstance = login;
    }

    private void updateLoginInstance(){
        //Verwijder de ingelogde user uit de login instance.
        loginInstance.LogUit(medewerker);
    }

    @FXML
    protected void onOverzichtBtnClick() throws IOException {
        NaarOverzicht();
    }
    @FXML
    protected void onBeheerBtnClick() throws IOException {
        NaarBeheer();
    }
    @FXML
    protected void onUitloggenBtnClick(){
        updateLoginInstance();
        Stage stage = (Stage) MedewerkersLabel.getScene().getWindow();
        stage.close();
    }


    private void NaarOverzicht() throws IOException {
        setSceneSwitch("overzicht-view.fxml");
        OverzichtController controller = SceneSwitch.getLoader().getController();
        controller.initialize(new Data(medewerker, productlist));
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void NaarBeheer() throws IOException {
        setSceneSwitch("beheer-view.fxml");
        BeheerController controller = SceneSwitch.getLoader().getController();
        controller.initialize(new Data(medewerker, productlist));
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void setSceneSwitch(String fxmlPath) throws IOException {
        SceneSwitch.PrepareScene(fxmlPath, MedewerkersLabel);
    }

    private void SwitchScenes(){
        SceneSwitch.SwitchToScene();
    }


}
