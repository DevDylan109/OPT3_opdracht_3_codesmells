package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VrachtAuto extends Product {
    private int gewicht;
    private int laadvermogen;


    public VrachtAuto(String naam, String beschrijving) {
        super(naam, beschrijving);
    }

    @Override
    public void drawInputScreen() {
        AnchorPane rootPane = new AnchorPane();
        Scene scene = new Scene(rootPane, 320, 240);
        Stage stage = new Stage();

        VBox vBox = new VBox();
        rootPane.getChildren().add(vBox);

        TextField gewichtField = new TextField();
        gewichtField.setPromptText("gewicht");

        TextField laadvermogenField = new TextField();
        laadvermogenField.setPromptText("laadvermogen");

        TextField beschrijvingField = new TextField();
        beschrijvingField.setPromptText("beschrijving");

        vBox.getChildren().add(gewichtField);
        vBox.getChildren().add(laadvermogenField);
        vBox.getChildren().add(beschrijvingField);

        Button button = new Button ("setText");
        button.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gewicht = Integer.parseInt(((TextField) vBox.getChildren().get(0)).getText());
                laadvermogen = Integer.parseInt(((TextField) vBox.getChildren().get(1)).getText());
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
        double prijs = 1 * (0.10 * laadvermogen);
        setPrijsPerDag(prijs);
    }

    @Override
    public void berekenVerzekering() {
        double prijs = 1 * (0.01 * gewicht);
        setPrijsPerDag(getPrijsPerDag() + prijs);
    }



    @Override
    public String toString() {
        return "Naam: " + getNaam() + "\nLaadvermogen: " + laadvermogen + " KG" + "\nGewicht: " + gewicht + " KG" +"\nBeschrijving: " + getBeschrijving() +
                "\nPrijs per dag: " + getPrijsPerDag() + " €" + "\nStatus: " + getStatus();
    }
}
