package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class LoginController {

    private Login login;
    private Medewerker medewerker;
    private SceneSwitcher switcher;
    private FXMLLoader loader;
    private ProductList productlist;
    @FXML
    private TextField Gebruikersnaam;
    @FXML
    private TextField Wachtwoord;



    @FXML
    protected void initialize(){
        login = new Login();
        switcher = new SceneSwitcher();
        productlist = new ProductList();

    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        LogGebruikerIn();
    }


    private void LogGebruikerIn() throws IOException {
        String Gebruikersnaam = this.Gebruikersnaam.getText();
        String Wachtwoord = this.Wachtwoord.getText();

        medewerker = login.Autoriseer(Gebruikersnaam, Wachtwoord);

        if(medewerker != null){
            System.out.println("Gebruiker is ingelogd");
            switchToScene2();
        }
        else{
            System.out.println("Gebruiker is niet ingelogd");
        }
    }


    private void switchToScene2() throws IOException {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hoofdmenu-view.fxml"));

        switcher.setLoader(loader);
        switcher.setNode(Gebruikersnaam);
        switcher.PrepareNewStage();

        //acces the controller and call a method
        HoofdmenuController controller = loader.getController();
        controller.initialize(medewerker, productlist);
        controller.initLogin(login);

        switcher.CallStage();


    }
}