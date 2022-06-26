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
        //create rootpane
        AnchorPane rootPane = new AnchorPane();
        //create scene
        scene = new Scene(rootPane, 320, 240);
        //create stage
        stage = new Stage();
        //create vbox
        vBox = new VBox();
        rootPane.getChildren().add(vBox);
    }

    //create textfield and set text based on parameter, and add to vBox
    public TextField createTextField(String text) {
        //create textfield
        TextField textField = new TextField();
        //set text
        textField.setPromptText(text);
        //set an Id for the textfield
        textField.setId(text);
        //add textfield to vBox
        vBox.getChildren().add(textField);
        //add textfield to textfields
        textfields.add(textField);
        //return textField object
        return textField;
    }

    //create button and set text based on parameter, and add to vBox
    public Button createButton(String text) {
        //create button
        Button button = new Button(text);
        button.setId(text);
        //add button to vBox
        vBox.getChildren().add(button);
        //add button to buttons
        buttons.add(button);
        //return button object
        return button;
    }

//    private void printIndex(Node node){
//        System.out.println(vBox.getChildren().indexOf(node));
//    }

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
