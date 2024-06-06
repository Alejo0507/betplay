package com.campus.models;


import com.campus.controllers.Data;
import com.campus.utilities.HandleErrors;
import com.campus.utilities.HandleInput;
import com.campus.views.Home;

public class Team {
    int id;
    String name;
    int pj;
    int pg;
    int pp;
    int pe;
    int gf;
    int gc;
    int tp;

    public Team(String name){
        this.id = Data.teams.size() + 1;
        this.name = name;
    }
    
    

    public Team(String name, int pj, int pg, int pe, int pp,  int gf, int gc, int tp) {
        this.id = Data.teams.size() + 1;
        this.name = name;
        this.pj = pj;
        this.pg = pg;
        this.pp = pp;
        this.pe = pe;
        this.gf = gf;
        this.gc = gc;
        this.tp = tp;
    }



    public String getName() {
        return name;
    }



    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", pj=" + pj + ", pg=" + pg + ", pp=" + pp
                + ", pe=" + pe + ", gf=" + gf + ", gc=" + gc + ", tp=" + tp + "]";
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getPj() {
        return pj;
    }

    public int getPg() {
        return pg;
    }

    public int getPp() {
        return pp;
    }

    public int getPe() {
        return pe;
    }

    public int getGf() {
        return gf;
    }

    public int getGc() {
        return gc;
    }

    public int getTp() {
        return tp;
    }

    public int getKeyValue(String key){
        switch (key) {
            case "gf":
                return gf;
            case "tp":
                return tp;

            case "pg":
                return pg;
        
            default:
                return gc;
        }
    }

    public static void addTeam(){
        String name = HandleInput.getString("Nombre del Equipo");
        if (name != null) {
            if (Data.findTeamByName(name) == null) {
                Team team = new Team(name);
                Data.teams.add(team);
                Home.showMenu();
                return;
            }else{
                HandleErrors.showError("Duplicate entry", name + " Exist");
            }
        } 
    }

    public void uploadStatistics(int gf, int gc) {
        this.pj++;
        this.gf += gf;
        this.gc += gc ;

        if (gf > gc) {
            this.pg++;
            this.tp += 3;
        } else if (gf < gc) {
            this.pp++;
        } else {
            this.pe++;
            this.tp++;
        }
    }


}

