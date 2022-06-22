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

    //Probleem met javaFX: Wanneer het meegegeven product zich in de index van de tableview bevindt, en dit vervolgens product op dezelfde index wordt vervangen
    // Doormiddel van remove en add, dan wilt de tableview zich niet updaten.
    // Doormiddel van set, in dit geval, wilt de tableview zich wel updaten.
    public void setProduct(Product product){
        ProductList.remove(product); //als de product zich in index 0 bevindt en delete
        ProductList.add(0, product); //en het weer op dezelfde index 0 wordt toegevoegd, update de tableview niet.
        ProductList.set(0, product); //tableview updated succesvol.
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
