package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OverzichtController implements Observer {

    private Medewerker medewerker;
    private ProductList productlist;
    @FXML
    private Label MedewerkersLabel;

    @FXML
    private TableView<Product> ProductView;
    @FXML
    private TableColumn<Product, String> SoortColumn;
    @FXML
    private TableColumn<Product, String> BeschrijvingColumn;
    @FXML
    private TableColumn<Product, String> StatusColumn;


    protected void initialize(Medewerker medewerker, ProductList productlist){
        this.medewerker = medewerker;
        this.productlist = productlist;
        productlist.addObserver(this);
        setMedewerkersLabel();
        initProductView();
        setColumns();
    }

    private void setMedewerkersLabel(){
        String Text = medewerker.getNaam();
        this.MedewerkersLabel.setText(Text);
    }


    private void initProductView(){
        ProductView.setItems(productlist.getAllProducts());
    }

    private void setColumns(){
        SoortColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        BeschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("beschrijving"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @Override
    public void update() {
        initProductView();
    }

    @FXML
    protected void OnDeleteBtnClick(){
        Product Selected;
        Selected = ProductView.getSelectionModel().getSelectedItem();
        productlist.removeProduct(Selected);
    }


}
