package com.example.opt3_opdracht_2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneSwitcher {
    private FXMLLoader loader;
    private Node node;
    private Stage stage;
    private Scene scene;



    public void PrepareScene(String fxmlpath, Node node) throws IOException {
        setLoader(fxmlpath);
        setNode(node);
        setScene();
        prepareStage();
    }
    private void setLoader(String fxmlpath) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlpath));
    }

    private void setNode(Node node) {
        this.node = node;
    }

    private void setScene() throws IOException {
        Parent root = loader.load();
        scene = new Scene(root);
    }


    public abstract void prepareStage() throws IOException;

    public void SwitchToScene(){
        stage.setScene(scene);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Node getNode() {
        return node;
    }

    public FXMLLoader getLoader() {
        return loader;
    }
}
