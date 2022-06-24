package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class FactoryList {
    private ArrayList<ProductFactory> FactoryList = new ArrayList<>();

    public FactoryList(){
        initializeFactoryList();
    }

    public void initializeFactoryList(){
        FactoryList.add(new BoormachineFactory());
        FactoryList.add(new PersonenAutoFactory());
        FactoryList.add(new VrachtAutoFactory());
    }

    public ArrayList<ProductFactory> getFactoryList() {
        return FactoryList;
    }
}
