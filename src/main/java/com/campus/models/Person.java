package com.campus.models;

public class Person {
    int id;
    String name;
    String surName;
    int age; 
    String dateInit;
    String nationality;
    String rol;
    int idTeam;
    /**
     * Player
     */
    public class Player extends Person {
        int Ga;

        
    }


    /**
     * Technical
     */
    public class Technical extends Person {
        String idFederation;

        
    }

    /**
     * Medic
     */
    public class Medic extends Person {
        int yearsExperience;

        
    }


}
