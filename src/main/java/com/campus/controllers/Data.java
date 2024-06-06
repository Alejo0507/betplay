package com.campus.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.campus.models.Match;
import com.campus.models.Person;
import com.campus.models.Team;
import com.campus.utilities.HandleInput;
import com.campus.utilities.MergeSort;


public class Data {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Match> matches = new ArrayList<Match>();
    public static ArrayList<Person> players = new ArrayList<Person>();

    public static Team findTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    public static void findMax(String key){
        Team maxTeam = Collections.max(Data.teams, Comparator.comparingInt(team -> team.getKeyValue(key)));
        int max = maxTeam.getKeyValue(key);
        List<Team> maxTeams = Data.teams.stream()
            .filter(team -> team.getKeyValue(key) == max)
            .collect(Collectors.toList());

        maxTeams.forEach(System.out::println);
        HandleInput.pause();
    }

    public static int getTotals(String key){
        int total = teams.stream()
         .collect(Collectors.summingInt(team -> team.getKeyValue(key)));
        return total;
    }

    public static Boolean checkEqualsPJ(){
        int pj = teams.get(0).getPj();
        for(Team team: teams){
            if (pj != team.getPj()) {
                return true;
            }
            pj = team.getPj();
        }
        return false;
    }

    public static void testData(){
        Team team = new Team("bucaramanga", 6, 2, 2, 2, 4, 3, 8);
        Data.teams.add(team);
        team = new Team("millonarios", 6, 2, 2, 2, 6, 5, 8);
        Data.teams.add(team);
        team = new Team("deportivo Pereira", 6, 2, 2, 2, 7, 8, 8);
        Data.teams.add(team);
        team = new Team("junior", 6, 2, 2, 2, 5, 6, 8);
        Data.teams.add(team);
        
    }

    public static void sortList() {
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team equipo1, Team equipo2) {
                // Comparamos por puntos
                if (equipo1.getTp() != equipo2.getTp()) {
                    return equipo2.getTp() - equipo1.getTp();
                }
                // Si hay empate en puntos, comparamos por goles en contra
                else {
                    return equipo1.getGc() - equipo2.getGc();
                }
            }
        });
    }
    
    // public static void printData(){
    //     for (Team team : teams) {
    //         System.err.println(team.toString());
    //     }
    //     HandleInput.pause();
    // }

}
