package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Repository {
    ArrayList<Medewerker> Medewerkers = new ArrayList<>();
    ArrayList<Product> Products = new ArrayList<>();
    Factories Productfactories = new Factories();

    public Repository(){
        initalizeMedewerkers();
        initializeProducts();
    }

    private void initalizeMedewerkers (){
        Medewerker john = new Medewerker("John", "John123", "password");
        Medewerker Kyle = new Medewerker("Kyle", "Kyle123", "password");
        Medewerker Dylan = new Medewerker("Dylan", "Dylan123", "password");
        Medewerkers.add(john);
        Medewerkers.add(Kyle);
        Medewerkers.add(Dylan);
    }

    private void initializeProducts(){

        ArrayList<ProductFactory> FactoryList;
        FactoryList = Productfactories.getFactoryList();

        for(ProductFactory factory: FactoryList){
            Products.add(factory.createProduct());
            Products.add(factory.createProduct());
        }
    }


    public ArrayList<Medewerker> getMedewerkers(){
        return this.Medewerkers;
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }
}

