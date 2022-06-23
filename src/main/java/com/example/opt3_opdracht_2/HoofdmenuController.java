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
    private ProductList productlist;
    private Login loginInstance;

    @FXML
    private Label MedewerkersLabel;



    public void initialize(Medewerker medewerker, ProductList productlist){
        SceneSwitch = new SceneSwitcher();
        this.medewerker = medewerker;
        this.productlist = productlist;
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
        OverzichtController controller = loader.getController();
        controller.initialize(medewerker, productlist);
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void NaarBeheer() throws IOException {
        setSceneSwitch("beheer-view.fxml");
        BeheerController controller = loader.getController();
        controller.initialize(medewerker, productlist);
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void setSceneSwitch(String fxmlPath) throws IOException {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        SceneSwitch.setLoader(loader);
        SceneSwitch.setNode(MedewerkersLabel);
        SceneSwitch.PrepareStage();
    }

    private void SwitchScenes(){
        SceneSwitch.CallStage();
    }


}
