package com.example.opt3_opdracht_2;

public class PersonenAutoFactory extends ProductFactory {
    public Product createProduct() {
        return new PersonenAuto("Personenauto");
    }
}
