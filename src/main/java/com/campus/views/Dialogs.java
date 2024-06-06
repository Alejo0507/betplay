package com.campus.views;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialogs {


    public static void addTeam(){
        
    }

    public static void addMatch(){
        JDialog dialog = new JDialog();
        dialog.setTitle("Agregar Nuevo Partido");
        dialog.setSize(400, 300);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));


        // Campo de entrada para el nombre del equipo local
        JTextField localTeamField = new JTextField(20);
        JPanel localTeamPanel = new JPanel();
        localTeamPanel.add(new JLabel("Equipo Local: "));
        localTeamPanel.add(localTeamField);
        dialog.add(localTeamPanel);

        // Campo de entrada para el nombre del equipo visitante
        JTextField visitorTeamField = new JTextField(20);
        JPanel visitorTeamPanel = new JPanel();
        visitorTeamPanel.add(new JLabel("Equipo Visitante: "));
        visitorTeamPanel.add(visitorTeamField);
        dialog.add(visitorTeamPanel);

        // Campo de entrada para el número de goles del equipo local
        JTextField localGoalsField = new JTextField(5);
        JPanel localGoalsPanel = new JPanel();
        localGoalsPanel.add(new JLabel("Goles del Equipo Local: "));
        localGoalsPanel.add(localGoalsField);
        dialog.add(localGoalsPanel);

        // Campo de entrada para el número de goles del equipo visitante
        JTextField visitorGoalsField = new JTextField(5);
        JPanel visitorGoalsPanel = new JPanel();
        visitorGoalsPanel.add(new JLabel("Goles del Equipo Visitante: "));
        visitorGoalsPanel.add(visitorGoalsField);
        dialog.add(visitorGoalsPanel);

        // Botón para agregar el partido
        JButton addButton = new JButton("Agregar Partido");
        dialog.add(addButton);

        dialog.setVisible(true);
    }


}
