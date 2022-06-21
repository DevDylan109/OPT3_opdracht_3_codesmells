package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Login {

    private ArrayList<Medewerker> MedewerkersList;
    private Medewerker currentlyLoggedIn;

    public Login(Repository repository){
        this.MedewerkersList = repository.getMedewerkers();
    }

    public boolean CheckAlreadyLoggedIn(String GEBRUIKERSNAAM){
        if(currentlyLoggedIn == null){
            return false;
        }
        else if(currentlyLoggedIn.getGebruikersnaam().equals(GEBRUIKERSNAAM)){
            return true;
        }
        else{
            return false;
        }
    }

    public Medewerker LogUserIn(String GEBRUIKERSNAAM, String WACHTWOORD, boolean AlreadyLoggedIn){
        String VerwachteGebruikersnaam;
        String VerwachteWachtwoord;
        Medewerker HuidigeMedewerker = null;

        if(!AlreadyLoggedIn){
            for(Medewerker Medewerker : MedewerkersList){
                VerwachteGebruikersnaam = Medewerker.getGebruikersnaam();
                VerwachteWachtwoord = Medewerker.getWachtwoord();

                if(VerwachteGebruikersnaam.equals(GEBRUIKERSNAAM) && VerwachteWachtwoord.equals(WACHTWOORD)){
                    HuidigeMedewerker = Medewerker;
                    currentlyLoggedIn = Medewerker;
                }
            }
        }
        return HuidigeMedewerker; //Bij True, return een Medewerker, Bij false return null
    }

    public Medewerker getCurrentlyLoggedIn() {
        return currentlyLoggedIn;
    }

    public void clearCurrentlyLoggedIn() {
        this.currentlyLoggedIn = null;
    }
}

