package com.campus.views;

import com.campus.controllers.Data;
import com.campus.models.Team;
import com.campus.utilities.HandleErrors;
import com.campus.utilities.HandleInput;
import com.campus.models.Match;


public class Menu {

    static String mainMenu = """


    Bienvenido a BetPlay

    1.Registrar Equipo
    2.Registrar Marcador
    3.Reportes
    4.Salir


    """;
    static String subMenuReport = """


    Generar Reportes

        A. NOMBRE DEL EQUIPO QUE MAS GOLES ANOTO
        B. NOMBRE DEL EQUIPO QUE MAS PUNTOS TIENE
        C. NOMBRE DEL EQUIPO QUE MAS PARTIDOS GANO
        D. TOTAL DE GOLES ANOTADOS POR TODOS LOS EQUIPOS
        E. PROMEDIO DE GOLES ANOTADOS EN EL TORNEO LA FEDERACIÓN COLOMBIANA DE FUTBOL .
        F. Regresar

    """;

    public static void loadMainMenu() {
        int option;
        do {
            option = HandleInput.getInt(mainMenu);
            switch (option) {
                case 1:
                    do {
                        String name = HandleInput.getString("Ingresa el Nombre del Equipo");
                        if (Data.findTeamByName(name) == null) {
                            Team team = new Team(name);
                            Data.teams.add(team);
                        } else {
                            HandleErrors.showError("duplicate key", "El Nombre del equipo ya esta registrado");
                        }
                        
                    } while (HandleInput.yesOrNot("Desea Ingresar otro Equipo?"));
                   
                    break;
                case 2:
                    //Match.newMatch();
                    break;

                case 3:
                    subMenuReports();
                    break;

                case 4:
                    return;

                default:
                    HandleErrors.showError("option", "");
                    break;
            }
        } while (option != 4);
    }

    public static void subMenuReports(){
        if (Data.teams.size() < 1) {
            HandleErrors.showError("teams min size", "Registra mas equipos");
        } else {
            if(Data.checkEqualsPJ()){
                HandleErrors.showError("match not equals", "Los Equipos no tienen el mismo Numero de Partidos Jugados");
            }
            String option;
            do{
                option = HandleInput.getString(subMenuReport);
                switch (option) {
                    case "a":
                        Data.findMax("gf");
                        break;
                    case "b":
                        Data.findMax("tp");
                        break;
    
                    case "c":
                        Data.findMax("pg");
                        break;
    
                    case "d":
                        System.err.println("Total Goles: " + Data.getTotals("gf"));
                        HandleInput.pause();
                        break;
    
                    case "e":
                        System.err.println("Total Goles: " + (Data.getTotals("gf")/Data.teams.size()));
                        HandleInput.pause();
                        break;
    
                    case "f":
                        return;
                    
                    default:
                        HandleErrors.showError("option", "");
                        break;
                }
            }while(option != "f");
        }
       
    }
}
