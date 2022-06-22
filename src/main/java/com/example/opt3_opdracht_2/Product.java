package com.example.opt3_opdracht_2;

import javafx.stage.Stage;

public abstract class Product {
    private String naam;
    private String beschrijving;
    private String status;
    private boolean isVerzekerd;
    private double prijs;

    private Huurinfo huurinformatie;

    public Product(String naam, String beschrijving) {
        this.naam = naam;
        this.status = "op voorraad";
        this.beschrijving = beschrijving;
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

    public void setVerzekerd(boolean verzekerd) {
        isVerzekerd = verzekerd;
    }

    public Huurinfo getHuurgegevens() {
        return huurinformatie;
    }

    public String getStatus() {
        return status;
    }

    public void setHuurgegevens(Huurinfo huurcontract) {
        this.huurinformatie = huurcontract;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //template method
    public void berekenPrijs(){
        berekenHuurprijs();
        if(isVerzekerd){
            berekenVerzekering();
        }
    }

    public abstract void berekenHuurprijs();
    public abstract void berekenVerzekering();

    public abstract String printDetails();
}
