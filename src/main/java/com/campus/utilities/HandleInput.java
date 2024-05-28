package com.campus.utilities;

import java.util.Scanner;

public class HandleInput {

     public static String getString(String message){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String data = sc.nextLine();
        return data;
    }

    public static int getInt(String message){
        while (true) {
            try {
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in);
                System.out.println(message);
                int data = sc.nextInt();
                if(data >= 0){
                    return data;
                }
                System.out.println("Ingresa Valores Positivos");
            } catch (Exception e) {
                System.out.println("Error al ingresar el Dato");
            }
        }
    }

    public static Boolean yesOrNot(String message){
        do {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            System.out.println(message + " Si(s) o No(n)");
            String data = sc.nextLine().toLowerCase();
            switch (data) {
                case "s":
                    return true;

                case "n":
                    return false;
            
                default:
                    System.out.println("Opción no Valida ");
                    break;
            }
            
        } while (true);
    }

    public static void pause(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Presione Enter Para Continuar.....");
        sc.nextLine();
    }

}
