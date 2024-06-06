package com.campus.models;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.campus.controllers.Data;
import com.campus.utilities.HandleErrors;
import com.campus.utilities.HandleInput;
import com.campus.views.Dialogs;
import com.campus.views.Home;

public class Match {
    String date;
    String dateMarch;
    Team localTeam;
    Team visitTeam;
    int localTeamGoals;
    int visitTeamGoals;


    public Match(Team localTeam, Team visitTeam, int localTeamGoals, int visitTeamGoals) {
        //SQL DATETIME FORMAT
        this.date = LocalDateTime.now().format((DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss")));
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.localTeamGoals = localTeamGoals;
        this.visitTeamGoals = visitTeamGoals;
    }

    /*public static void loadScore(Team localTeam, Team visitTeam, int localTeamGoals, int visitTeamGoals){
        if (localTeamGoals > visitTeamGoals) {
            localTeam.setPj(1);
            localTeam.setPg(1);
            visitTeam.setPj(1);
            visitTeam.setPp(1);
            localTeam.setGf(localTeam.getGf() + localTeamGoals);
            localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            localTeam.setTp(localTeam.getTp() + 3);
        } else if (localTeamGoals < visitTeamGoals) {
            localTeam.setPj(1);
            localTeam.setPp(1);
            visitTeam.setPj(1);
            visitTeam.setPg(1);
            localTeam.setGf(localTeam.getGf() + localTeamGoals);
            localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            visitTeam.setTp(visitTeam.getTp() + 3);
        } else {
            localTeam.setPj(1);
            visitTeam.setPj(1);
            localTeam.setPe(1);
            visitTeam.setPe(1);
            localTeam.setGf(localTeam.getGf() + localTeamGoals);
            localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            localTeam.setTp(localTeam.getTp() + 1);
            visitTeam.setTp(visitTeam.getTp() + 1);
        }
        return;
    }
    */ 

    /* 
    public static void newMatch(){
        if (Data.teams.size() < 2) {
            HandleErrors.showError("teams min size", "Registra mas equipos");
        } else {
            String message = "Desea Intentarlo de Nuevo";
            do {
                Team localTeam = Data.findTeamByName(HandleInput.getString("Ingresa el Nombre del Equipo Local"));
                if (localTeam != null) {
                    Team visitTeam = Data.findTeamByName(HandleInput.getString("Ingresa el Nombre del Equipo Visitante"));
                    if (visitTeam != null && !visitTeam.getName().equals(localTeam.getName())) {
                        int localTeamGoals = HandleInput.getInt("Ingresa goles del Equipo Local "+ localTeam.getName());
                        int visitTeamGoals = HandleInput.getInt("Ingresa goles del Equipo Visitante "+ visitTeam.getName());
                        Data.matches.add(new Match(localTeam, visitTeam, localTeamGoals, visitTeamGoals));
                        //loadScore(localTeam, visitTeam, localTeamGoals, visitTeamGoals);
                        localTeam.uploadStatistics(localTeamGoals, visitTeamGoals);
                        visitTeam.uploadStatistics(visitTeamGoals, localTeamGoals);
                        message = "Desea Ingresar otro Resultado de un Partido?";
                    } else {
                        HandleErrors.showError("not found", "Equipo Visitante no encontrado");
                    }
                } else {
                    HandleErrors.showError("not found", "Equipo Local no encontrado");
                }

            } while (HandleInput.yesOrNot(message));
        }  
    }
    */

    public static void newMatch(String localGoals, String visitGoals){
        Team localTeam = Dialogs.localTeam;
        Team visitTeam = Dialogs.visitTeam;
        if (localTeam != null) {
            if (!visitTeam.getName().equals(localTeam.getName())) {
                try {
                    int localTeamGoals = Integer.parseInt(localGoals);
                    int visitTeamGoals = Integer.parseInt(visitGoals);
                    Data.matches.add(new Match(localTeam, visitTeam, localTeamGoals, visitTeamGoals));
                    //loadScore(localTeam, visitTeam, localTeamGoals, visitTeamGoals);
                    localTeam.uploadStatistics(localTeamGoals, visitTeamGoals);
                    visitTeam.uploadStatistics(visitTeamGoals, localTeamGoals);
                    Dialogs.dialog.setVisible(false);
                    HandleErrors.showSuccessful("Team Update", "Se Guardo correctamente");
                    Data.sortList();
                    Home.showMenu();
                } catch (Exception e) {
                    HandleErrors.showError("input", e.getMessage());
                }
               
            }else{
                HandleErrors.showError("equals name", "El "+ localTeam.getName() + " No Puede Jugar contra el " + visitTeam.getName());
            }
        } else {
            HandleErrors.showError("not found", "Equipo Local no encontrado");
        }
    }
    
}