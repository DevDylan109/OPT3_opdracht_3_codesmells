package com.example.opt3_opdracht_2;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InputScreen {

    private VBox vBox;
    private Scene scene;
    private Stage stage;
    private ArrayList<TextField> textfields = new ArrayList<>();
    private ArrayList<Button> buttons = new ArrayList<>();

    //create rootpane
    public void createRootPane() {
        AnchorPane rootPane = new AnchorPane();
        scene = new Scene(rootPane, 320, 240);
        stage = new Stage();
        vBox = new VBox();
        rootPane.getChildren().add(vBox);
    }


    //create textfield and set text based on parameter, and add to vBox
    public TextField createTextField(String text) {
        TextField textField = new TextField();
        textField.setPromptText(text);
        textField.setId(text);
        vBox.getChildren().add(textField);
        textfields.add(textField);
        return textField;
    }


    //create button and set text based on parameter, and add to vBox
    public Button createButton(String text) {
        Button button = new Button(text);
        button.setId(text);
        vBox.getChildren().add(button);
        buttons.add(button);
        return button;
    }


    public Node getNode(String Id){
        Node node = null;
        for(Node element : vBox.getChildren()){
            element.getId().equals(Id);
            node = element;
        }
        return node;
    }


    public TextField getTextField(String Id){
        TextField textField = null;
        for(TextField textfield : textfields){
            if(textfield.getId().equals(Id)){
                textField = textfield;
            }
        }
        return textField;
    }


    public Button getButton(String Id){
        Button button = null;
        for(Button Btn : buttons){
            if(Btn.getId().equals(Id)){
                button = Btn;
            }
        }
        return button;
    }


    public void showStage() {
        //show stage
        stage.setTitle("InputScreen");
        stage.setScene(scene);
        stage.show();
    }


    public Stage getStage(){
        return stage;
    }
}
