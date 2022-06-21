package com.example.opt3_opdracht_2;

import java.util.ArrayList;

public class Repository {
    ArrayList<Medewerker> Medewerkers = new ArrayList<>();

    public Repository(){
        initalizeMedewerkers();
    }

    private void initalizeMedewerkers (){
        Medewerker john = new Medewerker("John", "John123", "password");
        Medewerker Kyle = new Medewerker("Kyle", "Kyle123", "password");
        Medewerkers.add(john);
        Medewerkers.add(Kyle);
    }


    public ArrayList<Medewerker> getMedewerkers(){
        return this.Medewerkers;
    }
}

