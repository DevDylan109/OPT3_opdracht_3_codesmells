package com.example.opt3_opdracht_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OverzichtController {

    private Medewerker medewerker;
    private Repository repository;
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


    protected void initialize(Medewerker medewerker){
        this.medewerker = medewerker;
        this.repository = new Repository();
        setMedewerkersLabel();
        initProductList();
        initProductView();
    }

    private void setMedewerkersLabel(){
        String Text = medewerker.getNaam();
        this.MedewerkersLabel.setText(Text);
    }

    private void initProductList(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.setAll(repository.getProducts());
        ProductenList.setItems(products);
    }

    private void initProductView(){
        ProductenList = new TableView<>();
        SoortColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        BeschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("beschrijving"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

}
