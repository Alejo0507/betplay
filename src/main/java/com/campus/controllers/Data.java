package com.campus.controllers;

import java.util.ArrayList;

import com.campus.models.Match;
import com.campus.models.Team;
import com.campus.utilities.HandleInput;
import com.campus.utilities.MergeSort;

public class Data {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Match> matches = new ArrayList<Match>();


    public static void printData(){
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
        return null;
    }



    public static void sortList(String key) {
        Team team = MergeSort.mergeSort(teams, key).get(teams.size() - 1);
        System.err.println(team.toString());
        HandleInput.pause();
    }

    public static void totalGoals() {
        HandleInput.pause();
    }

    public static void meanGoals() {
        HandleInput.pause();
    }


}
