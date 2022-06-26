package com.example.opt3_opdracht_2;

import javafx.event.ActionEvent;
import javafx.event.Event;
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

//    @Override
//    public void drawInputScreen() {
//        AnchorPane rootPane = new AnchorPane();
//        Scene scene = new Scene(rootPane, 320, 240);
//        Stage stage = new Stage();
//
//        VBox vBox = new VBox();
//        rootPane.getChildren().add(vBox);
//
//        TextField MerkField = new TextField();
//        MerkField.setPromptText("Merk");
//
//        TextField GewichtField = new TextField();
//        GewichtField.setPromptText("Gewicht");
//
//        TextField BeschrijvingField = new TextField();
//        BeschrijvingField.setPromptText("Beschrijving");
//
//        vBox.getChildren().add(MerkField);
//        vBox.getChildren().add(GewichtField);
//        vBox.getChildren().add(BeschrijvingField);
//
//        Button button = new Button ("setText");
//        button.setOnAction (new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                merk = ((TextField) vBox.getChildren().get(0)).getText();
//                gewicht = Integer.parseInt(((TextField) vBox.getChildren().get(1)).getText());
//                setBeschrijving(((TextField) vBox.getChildren().get(2)).getText());
//                stage.close();
//            }
//        });
//        vBox.getChildren().add(button);
//        stage.setTitle("OPT3");
//        stage.setScene(scene);
//        stage.show();


//    }

    @Override
    public void drawInputScreen() {
        setInputScreen();
        setScreenAction();
        getInputScreen().showStage();
    }

    private void setInputScreen(){
        getInputScreen().createRootPane();
        getInputScreen().createButton("Voer PersonenAuto in");
        addTextField("merk");
        addTextField("gewicht");
        addTextField("beschrijving");
    }

    private void setScreenAction(){
        Button b = getInputScreen().getButton("Voer PersonenAuto in");
        b.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                String txt1 = getInputScreen().getTextField("merk").getText();
                String txt2 = getInputScreen().getTextField("gewicht").getText();
                String txt3 = getInputScreen().getTextField("beschrijving").getText();
                merk = txt1;
                gewicht = Integer.parseInt((txt2));
                setBeschrijving((txt3));
                getInputScreen().getStage().close();
            }
        });
    }

    private void addTextField(String text){
        getInputScreen().createTextField(text);
    }

    @Override
    public void berekenHuurprijs() {
        double prijs = 50;
        setPrijsPerDag(prijs);
    }

    @Override
    public void berekenVerzekering() {
        double prijs = 1 * (0.01 * gewicht);
        setPrijsPerDag(getPrijsPerDag() + prijs);
    }

    @Override
    public String toString() {
        return "Naam: " + getNaam() + "\nMerk: " + merk + "\nGewicht: " + gewicht + " KG" + "\nBeschrijving: " + getBeschrijving() +
                "\nPrijs per dag: " + getPrijsPerDag() + " €" + "\nStatus: " + getStatus();
    }
}
