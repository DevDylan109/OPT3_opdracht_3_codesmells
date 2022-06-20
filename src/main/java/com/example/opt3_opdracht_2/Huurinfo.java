package com.example.opt3_opdracht_2;

public class Huurinfo { // class Huurinfo
    private Medewerker medewerker;
    private Klant klant;
    private int dagen;
    private String status;

    public Huurinfo() { // constructor Huurinfo
        this.status = "op voorraad";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String printinfo() {
        return "Huurinfo: " + "Verhuurd door medewerker: " + medewerker.getNaam() + " Klant: " + klant.getNaam() + " Dagen: " + dagen + " Status: " + status;
    }
}
