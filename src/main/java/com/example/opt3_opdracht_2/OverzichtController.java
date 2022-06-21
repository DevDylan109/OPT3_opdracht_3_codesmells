package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OverzichtController {
    @FXML
    private Label MedewerkersLabel;

    @FXML
    private TableView<Product> ProductenList;
    @FXML
    private TableColumn<Product, String> SoortColumn;
    @FXML
    private TableColumn<Product, String> BeschrijvingColumn;
    @FXML
    private TableColumn<Product, String> StatusColumn;

    @FXML
    protected void initialize(){
        //test
    }

    private void initRepository(){

    }
    private void initProductList(){

    }

}
