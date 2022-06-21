package com.example.opt3_opdracht_2;

public class BoormachineFactory extends ProductFactory {
    public Product createProduct() {
        return new Boormachine("Boormachine", "Met dit gereedschap kan je boren");
    }
}

