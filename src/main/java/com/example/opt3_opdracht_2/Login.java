package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Login {

    private ArrayList<Medewerker> MedewerkersList;
    private Medewerker HuidigeMedewerker;

    private boolean isAlreadyLoggedIn;

    public Login(){
        Repository repository = new Repository();
        this.MedewerkersList = repository.getMedewerkers();
    }

    private void IsAlIngelogd(String GEBRUIKERSNAAM){
        if(HuidigeMedewerker == null){
            isAlreadyLoggedIn = false;
        }
        else if(HuidigeMedewerker.getGebruikersnaam().equals(GEBRUIKERSNAAM)){
            isAlreadyLoggedIn = true;
        }
        else{
            isAlreadyLoggedIn = false;
        }
    }

    public Medewerker Autoriseer(String GEBRUIKERSNAAM, String WACHTWOORD){
        IsAlIngelogd(GEBRUIKERSNAAM);
        String VerwachteGebruikersnaam;
        String VerwachteWachtwoord;
        Medewerker AutoriserendeMedewerker = null;

        if(!isAlreadyLoggedIn){ //Bij True, return een Medewerker, Bij false return null
            for(Medewerker Medewerker : MedewerkersList){
                VerwachteGebruikersnaam = Medewerker.getGebruikersnaam();
                VerwachteWachtwoord = Medewerker.getWachtwoord();

                if(VerwachteGebruikersnaam.equals(GEBRUIKERSNAAM) && VerwachteWachtwoord.equals(WACHTWOORD)){
                    AutoriserendeMedewerker = Medewerker;
                    HuidigeMedewerker = Medewerker;
                }
            }
        }
        return AutoriserendeMedewerker;
    }

    public Medewerker getHuidigeMedewerker() {
        return HuidigeMedewerker;
    }

    public void clearHuidigeMedewerker() {
        this.HuidigeMedewerker = null;
    }
}

