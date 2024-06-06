package com.campus.utilities;


import javax.swing.JOptionPane;


public class HandleErrors {


    public static void showError(String error, String errorM) {
        JOptionPane.showMessageDialog(null,errorM , error , JOptionPane.ERROR_MESSAGE);
    }

  

}
