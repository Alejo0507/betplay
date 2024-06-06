package com.campus.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import com.campus.models.Team;

public class Header {

    public static JMenuBar loadHeader(){
        //header options
        JMenuBar mb = new JMenuBar();
        mb.add(inicio());
        mb.add(equipos());
        mb.add(partidos());
        mb.add(reportes());
        return mb;
    }

    private static JMenu inicio(){
        JMenu option = new JMenu("Inicio");
        return option;
    }

    private static JMenu equipos(){
        JMenu option = new JMenu("Equipos");

        JMenuItem subOption_1 = new JMenuItem("Nuevo Equipo");
        JMenuItem subOption_2 = new JMenuItem("Actualizar Equipo");
        // Crear el ActionListener para manejar el evento de clic
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va el código que deseas ejecutar cuando se hace clic en el JMenuItem
                if (e.getSource() == subOption_1) {
                    // Código para el JMenuItem "Nuevo Equipo"
                    // Por ejemplo, abrir un diálogo para agregar un nuevo equipo
                    Team.addTeam();
                } else if (e.getSource() == subOption_2) {
                    // Código para el JMenuItem "Actualizar Equipo"
                    // Por ejemplo, actualizar la lista de equipos
                    //Dialogs.updateTeam();
                }
            }
        };

        subOption_1.addActionListener(listener);
        subOption_2.addActionListener(listener);

        option.add(subOption_1);
        option.add(subOption_2);

        return option;
    }

    private static JMenu partidos(){
        JMenu option = new JMenu("Partidos");

        JMenuItem subOption_1 = new JMenuItem("Nuevo Partido");
        // Crear el ActionListener para manejar el evento de clic
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va el código que deseas ejecutar cuando se hace clic en el JMenuItem
                if (e.getSource() == subOption_1) {
                    // Código para el JMenuItem "Nuevo Equipo"
                    // Por ejemplo, abrir un diálogo para agregar un nuevo equipo
                    Dialogs.addMatch();
                }
            }
        };

        subOption_1.addActionListener(listener);

        option.add(subOption_1);


        return option;
    }

    private static JMenu reportes(){
        JMenu option = new JMenu("Reportes");

    
        JMenuItem subOption_A = new JMenuItem("Nombre del equipo que más goles anotó");
        JMenuItem subOption_B = new JMenuItem("Nombre del equipo que más puntos tiene");
        JMenuItem subOption_C = new JMenuItem("Nombre del equipo que más partidos ganó");
        JMenuItem subOption_D = new JMenuItem("Total de goles anotados por todos los equipos");
        JMenuItem subOption_E = new JMenuItem("Promedio de goles anotados en el torneo de la Federación Colombiana de Fútbol");

        // ActionListener común para todos los submenús
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == subOption_A) {
                    // Lógica para el submenú A
                } else if (e.getSource() == subOption_B) {
                    // Lógica para el submenú B
                } else if (e.getSource() == subOption_C) {
                    // Lógica para el submenú C
                } else if (e.getSource() == subOption_D) {
                    // Lógica para el submenú D
                } else if (e.getSource() == subOption_E) {
                    // Lógica para el submenú E
                }
            }
        };

        subOption_A.addActionListener(listener);
        subOption_B.addActionListener(listener);
        subOption_C.addActionListener(listener);
        subOption_D.addActionListener(listener);
        subOption_E.addActionListener(listener);


        option.addSeparator(); // Agregar separador entre Nuevo Partido y los demás submenús
        option.add(subOption_A);
        option.add(subOption_B);
        option.add(subOption_C);
        option.add(subOption_D);
        option.add(subOption_E);

        return option;
    }

}
