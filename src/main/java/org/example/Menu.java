package org.example;

import java.util.HashMap;

public class Menu {


    public void show(){
        HashMap<Integer,String> menu = new HashMap<>();
        menu.put(1," Shop Setting \n");
        menu.put(2,"Manage Shop Items\n");
        menu.put(3, "Create New Invoice\n");
        menu.put(4,"Report: Statistics\n");
        menu.put(5,"Report: All Invoices\n");
        menu.put(6,"Search (1) Invoice\n");
        menu.put(7,"Program Statistics\n");
        menu.put(8, "Exit");

        System.out.println(menu.toString().replace("{"," ").replace(",","").replace("}",""));
    }

}
