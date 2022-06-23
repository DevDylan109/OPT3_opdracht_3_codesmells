package com.example.opt3_opdracht_2;

public class Huurinfo { // class Huurinfo
    private Medewerker medewerker;
    private Klant klant;
    private int dagen;

    public Huurinfo() { // constructor Huurinfo
    }

    public Medewerker getMedewerker() {
        return medewerker;
    }

    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public int getDagen() {
        return dagen;
    }

    public void setDagen(int dagen) {
        this.dagen = dagen;
    }

    public void resetInfo(){
        this.medewerker = null;
        this.dagen = 0;
        this.klant = null;
    }


@Override
    public String toString() {
        return "Huurinfo: " + "\nVerhuurd door medewerker: " + medewerker.getNaam() +
                "\nKlant: " + klant.getNaam() + " " + klant.getAchternaam() + "\nDagen: " + dagen;
    }
}
