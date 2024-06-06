package com.campus.views;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.campus.controllers.Data;
import com.campus.models.Team;

public class PositionsTable {

    public static JTable loadPositionTable(){
        

        // Definir los nombres de las columnas
        String[] columnNames = {"NOMBRE DEL EQUIPO", "PJ", "PG", "PP", "PE", "GF", "GC", "TP"};

        // Datos de ejemplo para la tabla
        Object[][] data = new Object[Data.teams.size()][8];
        for (int i = 0; i < Data.teams.size(); i++) {
            Team team = Data.teams.get(i);
            data[i][0] = team.getName();
            data[i][1] = team.getPj();
            data[i][2] = team.getPg();
            data[i][3] = team.getPp();
            data[i][4] = team.getPe();
            data[i][5] = team.getGf();
            data[i][6] = team.getGc();
            data[i][7] = team.getTp();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setBorder(new EmptyBorder(100, 10, 10, 10));
        return table;
    }

}
