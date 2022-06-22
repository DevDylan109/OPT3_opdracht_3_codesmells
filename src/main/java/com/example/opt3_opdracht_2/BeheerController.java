package com.example.opt3_opdracht_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BeheerController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;

    @FXML
    private Button createProductBtn;
    @FXML
    private Label MedewerkersLabel;
    @FXML
    private TableView<ProductFactory> FactoryView;
    @FXML
    private TableColumn<ProductFactory, String> Soort;

    protected void initialize(Medewerker medewerker, ProductList productList){
        this.medewerker = medewerker;
        this.productList = productList;
        setLabel();
        doSomething();
    }

    private void setLabel(){
        MedewerkersLabel.setText("Beheerder: " + medewerker.getNaam());
    }

    private void doSomething(){
        Factories factories = new Factories();
        ObservableList<ProductFactory> factoryList = FXCollections.observableArrayList();
        factoryList.setAll(factories.getFactoryList());
        FactoryView.setItems(factoryList);

        Soort.setCellValueFactory(new PropertyValueFactory<>("FactoryName"));


    }

    @FXML
    protected void OnCreateBtnClick(){
        ProductFactory factory;
        factory = FactoryView.getSelectionModel().getSelectedItem();
        product = factory.createProduct();
        product.drawInputScreen();
        productList.addProduct(product);

    }

    @FXML
    protected void OnPrintBtnClick(){
        System.out.println(product.printDetails());
    }
}
