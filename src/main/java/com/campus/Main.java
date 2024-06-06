package com.campus;

import com.campus.controllers.Data;
import com.campus.views.Home;


public class Main {
    public static void main(String[] args) {
        Data.testData();
        //Menu.loadMainMenu();
        Home.showMenu();
        
    }
}