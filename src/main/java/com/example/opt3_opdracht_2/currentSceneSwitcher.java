package com.example.opt3_opdracht_2;

import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class currentSceneSwitcher extends SceneSwitcher{
    @Override
    public void prepareStage() throws IOException {
        Node node = getNode();
        Stage stage = (Stage) node.getScene().getWindow();
        setStage(stage);
    }
}
