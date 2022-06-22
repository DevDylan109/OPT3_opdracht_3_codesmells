package com.example.opt3_opdracht_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ProductList extends Observable{

    private ObservableList<Product> ProductList = FXCollections.observableArrayList();
    private Repository Repo;

    public ProductList(){
        Repo = new Repository();
        setAllProducts(Repo.getProducts());
    }

    public void setAllProducts(ArrayList<Product> productList) {
        ProductList.setAll(productList);
        //notifyObservers();
    }

    public ObservableList<Product> getAllProducts() {
        return ProductList;
    }

    public void setProduct(Product product){
        ProductList.remove(product);
        ProductList.add(product);
        System.out.println(product.getStatus());
        notifyObservers();
    }

    public void addProduct(Product product) {
        ProductList.add(product);
        notifyObservers();
    }

    public void removeProduct(Product product) {
        ProductList.remove(product);
        notifyObservers();
    }


}
