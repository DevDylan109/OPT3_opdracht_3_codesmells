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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }


    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }


}
