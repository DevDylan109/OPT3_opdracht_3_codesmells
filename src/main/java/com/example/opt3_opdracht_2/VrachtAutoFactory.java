package com.example.opt3_opdracht_2;

public class VrachtAutoFactory extends ProductFactory {

    public VrachtAutoFactory(){
        super.setFactoryName("VrachtAutos");
    }
    public Product createProduct() {
        return new VrachtAuto("Vrachtauto", "Vrachtauto voor productVervoer");
    }

}
