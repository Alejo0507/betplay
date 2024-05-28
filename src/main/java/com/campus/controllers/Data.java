package com.campus.controllers;

import java.util.ArrayList;

import com.campus.models.Team;
import com.campus.utilities.HandleInput;

public class Data {

    public static ArrayList<Team> teams = new ArrayList<Team>();


    public static void showTeams(){
        for (Team team : teams) {
            System.err.println(team.toString());
        }
        HandleInput.pause();
    }


    public static Team findTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null; // Si no se encuentra ningún equipo con el nombre dado
    }


}
