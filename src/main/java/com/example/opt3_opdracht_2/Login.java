package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Login {

    private ArrayList<Medewerker> MedewerkersList;
    private ArrayList<Medewerker> IngelogdeMedewerkers;

    private boolean isAlreadyLoggedIn;

    public Login(){
        Repository repository = new Repository();
        this.IngelogdeMedewerkers = new ArrayList<>();
        this.MedewerkersList = repository.getMedewerkers();
    }

    private void IsAlIngelogd(String GEBRUIKERSNAAM){
        for(Medewerker IngelogdeMedewerker : IngelogdeMedewerkers){
            if(IngelogdeMedewerker.getGebruikersnaam().equals(GEBRUIKERSNAAM)){
                setAlreadyLoggedIn(true);
                break;
            }
            else{
                setAlreadyLoggedIn(false);
            }
        }
    }

    public Medewerker Autoriseer(String GEBRUIKERSNAAM, String WACHTWOORD){
        IsAlIngelogd(GEBRUIKERSNAAM);
        Medewerker AutoriserendeMedewerker = null;

        if(!isAlreadyLoggedIn){ //Bij True, return een Medewerker, Bij false return null
            for(Medewerker Medewerker : MedewerkersList){
                String Gebruiker = Medewerker.getGebruikersnaam();
                String Wachtwoord = Medewerker.getWachtwoord();
                boolean EqualsNaam = Gebruiker.equals(GEBRUIKERSNAAM);
                boolean EqualsWW = Wachtwoord.equals(WACHTWOORD);
                if(EqualsNaam && EqualsWW){
                    AutoriserendeMedewerker = Medewerker;
                    IngelogdeMedewerkers.add(Medewerker);
                }
            }
        }
        return AutoriserendeMedewerker;
    }
    
    private void setAlreadyLoggedIn(boolean beslissing){
        isAlreadyLoggedIn = beslissing;
    }


    public void LogUit(Medewerker medewerker) {
        setAlreadyLoggedIn(false);
        IngelogdeMedewerkers.remove(medewerker);
    }
}

