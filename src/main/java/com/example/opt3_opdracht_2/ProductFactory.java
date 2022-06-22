package com.example.opt3_opdracht_2;

public abstract class ProductFactory {
    private String FactoryName;
    public abstract Product createProduct();

    public void setFactoryName(String factoryName) {
        FactoryName = factoryName;
    }

    public String getFactoryName() {
        return FactoryName;
    }
}
