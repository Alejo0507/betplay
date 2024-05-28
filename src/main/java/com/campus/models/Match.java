package com.campus.models;

public class Match {

    String dateMarch;
    Team localTeam;
    Team visitTeam;
    int localTeamGoals;
    int visitTeamGoals;


    public Match(Team localTeam, Team visitTeam, int localTeamGoals, int visitTeamGoals) {
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.localTeamGoals = localTeamGoals;
        this.visitTeamGoals = visitTeamGoals;
    
      
        if (this.localTeamGoals > this.visitTeamGoals) {
            this.localTeam.setPj(1);
            this.localTeam.setPg(1);
            this.visitTeam.setPj(1);
            this.visitTeam.setPp(1);
            this.localTeam.setGf(localTeam.getGf() + localTeamGoals);
            this.localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            this.visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            this.visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            this.localTeam.setTp(localTeam.getTp() + 3);
        } else if (this.localTeamGoals < this.visitTeamGoals) {
            this.localTeam.setPj(1);
            this.localTeam.setPp(1);
            this.visitTeam.setPj(1);
            this.visitTeam.setPg(1);
            this.localTeam.setGf(localTeam.getGf() + localTeamGoals);
            this.localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            this.visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            this.visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            this.visitTeam.setTp(visitTeam.getTp() + 3);
        } else {
            this.localTeam.setPj(1);
            this.visitTeam.setPj(1);
            this.localTeam.setPe(1);
            this.visitTeam.setPe(1);
            this.localTeam.setGf(localTeam.getGf() + localTeamGoals);
            this.localTeam.setGc(localTeam.getGc() + visitTeamGoals);
            this.visitTeam.setGf(visitTeam.getGf() + visitTeamGoals);
            this.visitTeam.setGc(visitTeam.getGc() + localTeamGoals);
            this.localTeam.setTp(localTeam.getTp() + 1);
            this.visitTeam.setTp(visitTeam.getTp() + 1);
        }

    }
    
}