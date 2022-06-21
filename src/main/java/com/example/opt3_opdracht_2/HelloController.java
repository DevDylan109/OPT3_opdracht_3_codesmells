package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    private Login login;
    private Medewerker medewerker;
    @FXML
    private TextField Gebruikersnaam;
    @FXML
    private TextField Wachtwoord;


    @FXML
    protected void initialize(){
        System.out.println("test");
        login = new Login();
    }

    @FXML
    protected void onLoginButtonClick() {
        LogGebruikerIn();
    }

    private void LogGebruikerIn() {
        String Gebruikersnaam = this.Gebruikersnaam.getText();
        String Wachtwoord = this.Wachtwoord.getText();
        medewerker = login.Autoriseer(Gebruikersnaam, Wachtwoord);
        if(medewerker != null){
            System.out.println("Gebruiker is ingelogd");
        }
        else{
            System.out.println("Gebruiker is niet ingelogd");
//            switchToScene2();
        }


    }
}