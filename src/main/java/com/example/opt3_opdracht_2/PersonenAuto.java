package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonenAuto extends Product {
    private String merk;
    private int gewicht;

    public PersonenAuto(String naam, String beschrijving) {
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
        vBox.getChildren().add(new TextField("Gewicht"));
        vBox.getChildren().add(new TextField("Beschrijving"));

        Button button = new Button ("setText");
        button.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                merk = ((TextField) vBox.getChildren().get(0)).getText();
                gewicht = Integer.parseInt(((TextField) vBox.getChildren().get(1)).getText());
                setBeschrijving(((TextField) vBox.getChildren().get(2)).getText());
                stage.close();
            }
        });
        vBox.getChildren().add(button);
        stage.setTitle("OPT3");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void berekenHuurprijs() {
        double prijs = getHuurgegevens().getDagen() * 50;
        setPrijs(prijs);
    }

    @Override
    public void berekenVerzekering() {
        double prijs = getHuurgegevens().getDagen() * (0.01 * gewicht);
        setPrijs(getPrijs() + prijs);
    }

    @Override
    public String printDetails() {
        return "Naam: " + getNaam() + "\nMerk: " + merk + "\nGewicht: " + gewicht + "\nBeschrijving: " + getBeschrijving() +
                "\nPrijs: " + getPrijs() + "\nStatus: " + getStatus();
    }
}
