package com.campus.models;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.campus.controllers.Data;
import com.campus.utilities.HandleErrors;
import com.campus.utilities.HandleInput;

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

    public static void loadScore(Team localTeam, Team visitTeam, int localTeamGoals, int visitTeamGoals){
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

    public static void newMatch(){
        if (Data.teams.size() < 2) {
            HandleErrors.showError("teams min size", "Registra mas equipos");
        } else {
            String message = "Desea Intentarlo de Nuevo";
            do {
                Team localTeam = Data.findTeamByName(HandleInput.getString("Ingresa el Nombre del Equipo Local"));
                if (localTeam != null) {
                    Team visitTeam = Data.findTeamByName(HandleInput.getString("Ingresa el Nombre del Equipo Visitante"));
                    if (visitTeam != null) {
                        int localTeamGoals = HandleInput.getInt("Ingresa goles de "+ localTeam.getName());
                        int visitTeamGoals = HandleInput.getInt("Ingresa goles de "+ visitTeam.getName());
                        Data.matches.add(new Match(localTeam, visitTeam, localTeamGoals, visitTeamGoals));
                        loadScore(localTeam, visitTeam, localTeamGoals, visitTeamGoals);
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
    
}