package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VrachtAuto extends Product {
    private int gewicht;
    private int laadvermogen;

    public VrachtAuto(String naam) {
        super(naam);

    }

    @Override
    public void drawInputScreen() {
        AnchorPane rootPane = new AnchorPane();
        Scene scene = new Scene(rootPane, 320, 240);
        Stage stage = new Stage();

        VBox vBox = new VBox();
        rootPane.getChildren().add(vBox);

        vBox.getChildren().add(new TextField("gewicht"));
        vBox.getChildren().add(new TextField("laadvermogen"));

        Button button = new Button ("setText");
        button.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gewicht = Integer.parseInt(((TextField) vBox.getChildren().get(0)).getText());
                laadvermogen = Integer.parseInt(((TextField) vBox.getChildren().get(1)).getText());
            }
        });
        vBox.getChildren().add(button);
        stage.setTitle("OPT3");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void berekenHuurprijs() {
        double prijs = getHuurgegevens().getDagen() * (0.10 * laadvermogen);
        setPrijs(prijs);
    }

    @Override
    public void berekenVerzekering() {
        double prijs = getHuurgegevens().getDagen() * (0.01 * gewicht);
        setPrijs(getPrijs() + prijs);
    }

    @Override
    public String printDetails() {
        return "Naam: " + getNaam() + "\nLaadvermogen: " + laadvermogen + "\nGewicht: " + gewicht + "\nBeschrijving: " + getBeschrijving() +
                "\nPrijs: " + getPrijs() + getHuurgegevens().printinfo();
    }
}
