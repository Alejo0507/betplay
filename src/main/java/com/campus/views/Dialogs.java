package com.campus.views;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.campus.controllers.Data;
import com.campus.models.Match;
import com.campus.models.Team;
import com.campus.views.components.Select;

public class Dialogs {

    public static JDialog dialog = new JDialog();
    public static Team localTeam;
    public static Team visitTeam;

    public static void addTeam(){
        
    }

    public static void addMatch(){
        
        dialog = new JDialog();
        dialog.setTitle("Agregar Nuevo Partido");
        dialog.setSize(400, 300);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

        JComboBox<String> localSelect = Select.newSelect("teams", "localTeam");
       
        JPanel localTeamPanel = new JPanel();
        localTeamPanel.add(new JLabel("Equipo Local: "));
        localTeamPanel.add(localSelect);
        dialog.add(localTeamPanel);

        // Campo de entrada para el nombre del equipo visitante
        JComboBox<String> visitorTeamSelect = Select.newSelect("teams", "visitTeam");
        JPanel visitorTeamPanel = new JPanel();
        visitorTeamPanel.add(new JLabel("Equipo Visitante: "));
        visitorTeamPanel.add(visitorTeamSelect);
        dialog.add(visitorTeamPanel);

        // Campo de entrada para el número de goles del equipo local
        JTextField localGoalsField = new JTextField(5);
        localGoalsField.setText("0");
        JPanel localGoalsPanel = new JPanel();
        localGoalsPanel.add(new JLabel("Goles del Equipo Local: "));
        localGoalsPanel.add(localGoalsField);
        dialog.add(localGoalsPanel);

        // Campo de entrada para el número de goles del equipo visitante
        JTextField visitorGoalsField = new JTextField(5);
        visitorGoalsField.setText("0");
        JPanel visitorGoalsPanel = new JPanel();
        visitorGoalsPanel.add(new JLabel("Goles del Equipo Visitante: "));
        visitorGoalsPanel.add(visitorGoalsField);
        dialog.add(visitorGoalsPanel);

        // Botón para agregar el partido
        JButton addButton = new JButton("Agregar Partido");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Match.newMatch(localGoalsField.getText(), visitorGoalsField.getText());
            }
        });
        dialog.add(addButton);

        dialog.setVisible(true);
    }


}
