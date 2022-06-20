package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Product product;

    @FXML
    protected void initialize(){
        System.out.println("HelloController.initialize()");
        ProductFactory boormachineFactory = new BoormachineFactory();
        this.product = boormachineFactory.createProduct();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        doSomething();
    }

    private void doSomething() {
//        ProductFactory boormachineFactory = new BoormachineFactory();
//        Product boormachine = boormachineFactory.createProduct();
//        Stage stage = (Stage) welcomeText.getScene().getWindow();
        product.drawInputScreen();

    }
}