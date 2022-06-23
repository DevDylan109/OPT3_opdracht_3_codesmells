package com.example.opt3_opdracht_2;

public class Medewerker {
    private String naam;
    private String gebruikersnaam;
    private String wachtwoord;

    public Medewerker(String naam, String gebruikersnaam, String wachtwoord) {
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
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
