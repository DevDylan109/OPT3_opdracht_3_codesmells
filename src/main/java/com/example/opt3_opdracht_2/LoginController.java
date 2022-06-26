package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    private Login login;
    private Medewerker medewerker;
//    private SceneSwitcher switcher;
    private ProductList productlist;
    @FXML
    private TextField Gebruikersnaam;
    @FXML
    private TextField Wachtwoord;



    @FXML
    protected void initialize(){
        login = new Login();
        //switcher = new SceneSwitcher();
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
        SceneSwitcher switcher = new NewSceneSwitcher();
        Data data = new Data(medewerker, productlist);
        data.setLogin(login);
        switcher.PrepareScene("hoofdmenu-view.fxml", Wachtwoord);

        //acces the controller and call a method
        HoofdmenuController controller = switcher.getLoader().getController();
        controller.initialize(data);
        //controller.initLogin(login);

        switcher.SwitchToScene();


    }
}