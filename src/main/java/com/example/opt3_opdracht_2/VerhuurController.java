package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class VerhuurController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;

    @FXML
    private TextArea textArea;
    public void initialize(Medewerker medewerker, ProductList productlist, Product product) {
        this.medewerker = medewerker;
        this.productList = productlist;
        this.product = product;
        setTextArea();
    }

    private void setTextArea(){
        textArea.setText(product.printDetails());
    }


}
