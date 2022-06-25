package com.example.opt3_opdracht_2;

import javafx.stage.Stage;

import java.io.IOException;

public class NewSceneSwitcher extends SceneSwitcher{
    @Override
    public void prepareStage() throws IOException {
        setStage(new Stage());
    }
}
