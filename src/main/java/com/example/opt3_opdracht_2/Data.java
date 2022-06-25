package com.example.opt3_opdracht_2;

public class Data {

    private Medewerker medewerker;
    private ProductList productList;

    private Product product;

    public Data(Medewerker medewerker, ProductList productList) {
        this.medewerker = medewerker;
        this.productList = productList;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public Medewerker getMedewerker() {
        return medewerker;
    }

    public ProductList getProductList() {
        return productList;
    }
}
