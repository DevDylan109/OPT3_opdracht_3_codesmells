package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hoofdmenu-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        //acces the controller and call a method
        HoofdmenuController controller = loader.getController();
        controller.initMedewerker(medewerker);

        //switch scenes
        stage.setScene(scene);
        stage.show();
    }
}