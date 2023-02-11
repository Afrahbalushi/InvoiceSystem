package org.example;

import java.util.HashMap;

public class SubMenu {

    HashMap<Integer,String> subMenu1 = new HashMap<>();
    HashMap<Integer,String> subMenu2 = new HashMap<>();

    public void showSubMenu1(){
        subMenu1.put(1,"Load Data\n");
        subMenu1.put(2,"Set Shop Name\n");
        subMenu1.put(3,"Set Invoice Header\n");
        subMenu1.put(4,"Go Back\n");

        System.out.println(subMenu1.toString().replace("{"," ").replace(",","").replace("}",""));

    }

    public void showSubMenu2(){

        subMenu2.put(1,"Add Items\n");
        subMenu2.put(2,"Delete Items\n");
        subMenu2.put(3,"Change Item Price\n");
        subMenu2.put(4,"Report All Items\n");
        subMenu2.put(5,"Go Back\n");

        System.out.println(subMenu2.toString().replace("{"," ").replace(",","").replace("}",""));
    }

}
