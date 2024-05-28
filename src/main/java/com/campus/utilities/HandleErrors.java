package com.campus.utilities;

import java.util.Scanner;

public class HandleErrors {


    public static void showError(String type, String error) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        switch (type) {
            case "option":
                System.out.println("""


                Opción No Reconocida..... 
                Enter Para Continuar""");
                break;
        
            default:
                System.out.println(error);
                break;
        }
        sc.nextLine();

    }

}
