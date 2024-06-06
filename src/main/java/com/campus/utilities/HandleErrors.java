package com.campus.utilities;


import javax.swing.JOptionPane;


public class HandleErrors {


    public static void showError(String error, String errorM) {
        JOptionPane.showMessageDialog(null,errorM , error , JOptionPane.ERROR_MESSAGE);
    }

    public static void showSuccessful(String information, String informationM) {
        JOptionPane.showMessageDialog(null,informationM , information , JOptionPane.INFORMATION_MESSAGE);
    }
  

}
