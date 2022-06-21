package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void initialize(){
        System.out.println("HelloController.initialize()");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        doSomething();
    }

    private void doSomething() {

    }
}