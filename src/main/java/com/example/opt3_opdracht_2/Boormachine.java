package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Boormachine extends Product {
    private String merk;
    private String type;

    public Boormachine(String naam, String beschrijving) {
        super(naam, beschrijving);
    }

    @Override
    public void drawInputScreen() {
        AnchorPane rootPane = new AnchorPane();
        Scene scene = new Scene(rootPane, 320, 240);
        Stage stage = new Stage();

        VBox vBox = new VBox();
        rootPane.getChildren().add(vBox);

        vBox.getChildren().add(new TextField("Merk"));
        vBox.getChildren().add(new TextField("Type"));

        Button button = new Button ("setText");
        button.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                merk = ((TextField) vBox.getChildren().get(0)).getText();
                type = ((TextField) vBox.getChildren().get(1)).getText();
            }
        });
        vBox.getChildren().add(button);
        stage.setTitle("OPT3");
        stage.setScene(scene);
        stage.show();
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void berekenHuurprijs() {
        int prijs = getHuurgegevens().getDagen() * 5;
        setPrijs(prijs);
    }

    @Override
    public void berekenVerzekering() {
        int prijs = getHuurgegevens().getDagen() * 1;
        setPrijs(getPrijs() + prijs);
    }

    @Override
    public String printDetails() {
        return "Naam: " + getNaam() + "\nMerk: " + merk + "\nType: " + type + "\nBeschrijving: " + getBeschrijving() +
                "\nPrijs: " + getPrijs() + getHuurgegevens().printinfo();
    }
}
