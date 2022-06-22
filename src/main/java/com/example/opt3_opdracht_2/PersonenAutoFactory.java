package com.example.opt3_opdracht_2;

public class PersonenAutoFactory extends ProductFactory {

    public PersonenAutoFactory(){
        setFactoryName("PersonenAutos");
    }
    public Product createProduct() {
        return new PersonenAuto("Personenauto", "Auto voor personen");
    }
}
