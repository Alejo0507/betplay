package com.campus.utilities;

import java.util.Scanner;


public class HandleErrors {


    public static void showError(String error, String errorM) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        if (error == "option") {
            errorM = """

            Opción No Reconocida..... """;
        }
        System.out.println("""
                
        %s

        """.formatted(errorM));
      
        System.out.println("""
        Enter Para Continuar...""");
        sc.nextLine();

    }

  

}
