package com.campus.views;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;



public class Home {

    private static JFrame frame;
    private static JPanel mainPanel;
    private static JScrollPane scrollPane;


    public static void createFrame(){
        frame = new JFrame("BetPlay");
        mainPanel = new JPanel(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        //ADD HEADER
        frame.getContentPane().add(BorderLayout.NORTH, Header.loadHeader());
        scrollPane = new JScrollPane(PositionsTable.loadPositionTable());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
      
        frame.add(mainPanel);

    }

 

    public static void showMenu() {
        if (frame != null) {
            frame.setVisible(false);
            
            createFrame();
            frame.setVisible(true);

        } else {
            createFrame();
            // Hacer visible el marco
            frame.setVisible(true);
        }
 
    }

}
