package com.example.opt3_opdracht_2;

import javafx.stage.Stage;

public abstract class Product {
    private String naam;
    private String beschrijving;
    private double prijs;

    private Huurinfo huurinformatie;

    public Product(String naam, String beschrijving) {
        this.naam = naam;
        huurinformatie = new Huurinfo();
    }

    public abstract void drawInputScreen();

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Huurinfo getHuurgegevens() {
        return huurinformatie;
    }

    public void setHuurgegevens(Huurinfo huurcontract) {
        this.huurinformatie = huurcontract;
    }

    //method template
    public void berekenPrijs(){
        berekenHuurprijs();
        berekenVerzekering();
    }

    public abstract void berekenHuurprijs();
    public abstract void berekenVerzekering();

    public abstract String printDetails();
}
