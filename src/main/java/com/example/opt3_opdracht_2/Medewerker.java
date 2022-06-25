package com.example.opt3_opdracht_2;

public class Medewerker {
    private String naam;
    private String gebruikersnaam;
    private String wachtwoord;

    public Medewerker(String naam) {
        this.naam = naam;
    }


    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getNaam() {
        return naam;
    }


    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }




}
