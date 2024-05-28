package com.campus.views;


import com.campus.controllers.Data;
import com.campus.models.Team;
import com.campus.utilities.HandleErrors;
import com.campus.utilities.HandleInput;



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
                        Team team = new Team(name);
                        Data.teams.add(team);
                    } while (HandleInput.yesOrNot("Desea Ingresar otro Equipo?"));
                   
                    break;
                case 2:
                    
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
        String option;
        do{
            option = HandleInput.getString(subMenuReport);
            switch (option) {
                case "a":
                    Data.showTeams();
                    break;
                case "b":
                    System.out.println("2");
                    break;

                case "c":
                    System.out.println("2");
                    break;

                case "d":
                    break;

                case "e":
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
