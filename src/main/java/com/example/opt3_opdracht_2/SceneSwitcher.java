package com.example.opt3_opdracht_2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    private FXMLLoader loader;
    private Node node;
    private Stage stage;
    private Scene scene;


    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void PrepareStage() throws IOException {
        Parent root = loader.load();
        scene = new Scene(root);
        stage = (Stage) node.getScene().getWindow();
    }

    public void PrepareNewStage() throws IOException {
        PrepareStage();
        stage = new Stage();
    }

    public void CallStage(){
        //switch scenes
        stage.setScene(scene);
        stage.show();
    }
}
