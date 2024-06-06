package com.campus.views;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;



public class Home {

    private static JFrame frame = new JFrame("BetPlay");

    public static void showMenu() {
        // Crear el marco principal
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

  
      

        //ADD HEADER
        frame.getContentPane().add(BorderLayout.NORTH, Header.loadHeader());

        // ADD TABLE
        JScrollPane scrollPane = new JScrollPane(PositionsTable.loadPositionTable());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
     
        //

        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);

        
        // Agregar el panel principal al marco
        frame.add(mainPanel);
        // Hacer visible el marco
        frame.setVisible(true);
    }

}
