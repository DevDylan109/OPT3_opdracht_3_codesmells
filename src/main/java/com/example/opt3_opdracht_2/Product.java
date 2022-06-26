package com.example.opt3_opdracht_2;

public abstract class Product {
    private String naam;
    private String beschrijving;
    private String status;
    private double prijsPerDag;

    private Huurinfo huurinformatie;
    private InputScreen inputScreen;

    public Product(String naam, String beschrijving) {
        this.naam = naam;
        this.status = "op voorraad";
        this.beschrijving = beschrijving;
        huurinformatie = new Huurinfo();
        inputScreen = new InputScreen();
    }

    public abstract void drawInputScreen();

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijsPerDag(double prijsPerDag){
        this.prijsPerDag = prijsPerDag;
    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    public Huurinfo getHuurgegevens() {
        return huurinformatie;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public InputScreen getInputScreen() {
        return inputScreen;
    }

    //template method
    public void berekenPrijzen(boolean isVerzekerd) {
        berekenHuurprijs();
        if(isVerzekerd){
            berekenVerzekering();
        }
    }

    public abstract void berekenHuurprijs();
    public abstract void berekenVerzekering();


}
