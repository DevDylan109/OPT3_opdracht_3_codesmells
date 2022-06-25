package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Repository {
    ArrayList<Medewerker> Medewerkers = new ArrayList<>();
    ArrayList<Product> Products = new ArrayList<>();
   // FactoryList productfactories = new FactoryList();

    public Repository(){
        initalizeMedewerkers();
        initializeProducts();
    }

    private void initalizeMedewerkers (){
        Medewerker john = new Medewerker("John");
        john.setGebruikersnaam("John123");
        john.setWachtwoord("password");

        Medewerker Kyle = new Medewerker("Kyle");
        Kyle.setGebruikersnaam("Kyle123");
        Kyle.setWachtwoord("password");

        Medewerkers.add(john);
        Medewerkers.add(Kyle);
    }

    private void initializeProducts(){
        FactoryList productfactories = new FactoryList();

        ArrayList<ProductFactory> FactoryList;
        FactoryList = productfactories.getFactoryList();

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

