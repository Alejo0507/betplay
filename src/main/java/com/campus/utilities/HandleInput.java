package com.campus.utilities;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class HandleInput {

     public static String getString(String message){
        String data = JOptionPane.showInputDialog(message);
        return data == null ? data : data.toLowerCase();
    }

    public static int getInt(String message) {
        while (true) {
            String inputData = JOptionPane.showInputDialog(message);
            try {
                // Convertir la entrada de String a int
                int data = Integer.parseInt(inputData);
                if (data >= 0) {
                    return data;
                } else {
                    HandleErrors.showError("Invalid Entry", data + " is a negative number");
                }
            } catch (NumberFormatException e) {
                HandleErrors.showError("Invalid Entry", inputData + " is not a number");
            }
        }
    }

    public static Boolean yesOrNot(String message){
        int n = JOptionPane.showConfirmDialog(
        null,
        message,
        "-----", JOptionPane.YES_NO_OPTION);
        return n == 0 ? true : false;
    }

    public static void pause(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("""
            Presione Enter Para Continuar.....
                """);
        sc.nextLine();
    }

}
