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
            if(IngelogdeMedewerker == null){
                setAlreadyLoggedIn(false);
            }
            else if(IngelogdeMedewerker.getGebruikersnaam().equals(GEBRUIKERSNAAM)){
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
        String VerwachteGebruikersnaam;
        String VerwachteWachtwoord;
        Medewerker AutoriserendeMedewerker = null;

        if(!isAlreadyLoggedIn){ //Bij True, return een Medewerker, Bij false return null
            for(Medewerker Medewerker : MedewerkersList){
                VerwachteGebruikersnaam = Medewerker.getGebruikersnaam();
                VerwachteWachtwoord = Medewerker.getWachtwoord();

                if(VerwachteGebruikersnaam.equals(GEBRUIKERSNAAM) && VerwachteWachtwoord.equals(WACHTWOORD)){
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
//    public Medewerker getHuidigeMedewerker() {
//        return HuidigeMedewerker;
//    }

    public void LogUit(Medewerker medewerker) {
        setAlreadyLoggedIn(false);
        IngelogdeMedewerkers.remove(medewerker);
    }
}

