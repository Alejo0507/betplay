package com.campus.models;


import com.campus.controllers.Data;

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


}

