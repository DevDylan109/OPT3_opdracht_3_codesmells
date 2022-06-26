package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
    private InputScreen inputScreen;


    public VrachtAuto(String naam, String beschrijving) {
        super(naam, beschrijving);
    }

    @Override
    public void drawInputScreen() {
        inputScreen = new InputScreen();
        setInputScreen();
        setScreenAction();
        inputScreen.showStage();
    }

    private void setInputScreen(){
        inputScreen.createRootPane();
        inputScreen.createTextField("gewicht");
        inputScreen.createTextField("laadvermogen");
        inputScreen.createTextField("beschrijving");
        inputScreen.createButton("Voer VrachtAuto in");
    }

    private void setScreenAction(){
        Button b = inputScreen.getButton("Voer VrachtAuto in");
        b.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                String txt1 = inputScreen.getTextField("gewicht").getText();
                String txt2 = inputScreen.getTextField("laadvermogen").getText();
                String txt3 = inputScreen.getTextField("beschrijving").getText();
                gewicht = Integer.parseInt((txt1));
                laadvermogen = Integer.parseInt((txt2));
                setBeschrijving((txt3));
                inputScreen.getStage().close();
            }
        });
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
