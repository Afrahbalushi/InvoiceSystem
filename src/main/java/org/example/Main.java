package org.example;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        SubMenu subMenu = new SubMenu();
        Invoice invoices = new Invoice();
        Item items = new Item();
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;

       do{

            menu.show();

            System.out.println("Select an option");
            int option = scanner.nextInt();

            switch(option){

                case 1:
                    Boolean loop1 = true;
                    do {
                        subMenu.showSubMenu1();
                        System.out.println("Select an option");
                        int option1 = scanner.nextInt();

                        switch (option1){
                            case 1:
                                System.out.println("INVOICE DETAILS");
                                System.out.println("__________________\n");

                                Boolean inv = true;
                                while (inv) {
                                    System.out.println("Enter Invoice NO.: ");
                                    invoices.invNO = scanner.nextInt();

                                    System.out.println("Enter Name:");
                                    invoices.costumerName = scanner.next();


                                    System.out.println("Enter Phone Number:");
                                    invoices.phone = scanner.nextInt();


                                    System.out.println("Enter Invoice Date:");
                                    invoices.date = scanner.next();

                                    System.out.println("Enter Number of Items:");
                                    invoices.numberOfItems = scanner.nextInt();

                                    System.out.println("Enter Total Amount:");
                                    invoices.totalAmount = scanner.nextDouble();

                                    System.out.println("Enter Paid Amount:");
                                    invoices.paidAmount = scanner.nextDouble();

                                    invoices.balance = invoices.totalAmount - invoices.paidAmount;
                                    System.out.println("The Balance is: " + invoices.balance);

                                    System.out.println("Do you want to add more invoices? y/n");
                                    String ans = scanner.next();
                                    if (ans.equals("y") || ans.equals("Y")) {
                                        inv = true;
                                    } else {
                                        inv = false;
                                    }
                                   invoices.invoiceList.add(invoices);
                                }

                                Boolean itm = true;
                            while (itm) {
                                System.out.println("\nITEM DETAILS");
                                System.out.println("__________________\n");

                                System.out.println("Enter Item ID:");
                                items.itemId = scanner.nextInt();

                                System.out.println("Enter Item Name:");
                                items.itemName = scanner.next();

                                System.out.println("Enter Unit Price:");
                                items.unitPrice = scanner.nextDouble();

                                System.out.println("Enter Quantity:");
                                items.quantity = scanner.nextInt();

                                items.qtyAmount = items.unitPrice * items.quantity;
                                System.out.println("The QTY Price is: " + items.qtyAmount);


                                System.out.println("Do you want to add more items? y/n");
                                String ans1 = scanner.next();
                                if (ans1.equals("y") || ans1.equals("Y")) {
                                    itm = true;
                                } else {
                                    itm = false;
                                }
                                items.itemList.add(items);
                            }
                                break;
                            case 2:

                                System.out.println("Enter Shop Name:");
                                shop.shopName = scanner.next();

                                    FileWriter file = new FileWriter("invoice.txt", true);
                                    file.write("Shop Name is " + shop.shopName + "\n");
                                    file.close();
                                    System.out.println("Shop name has been set successfully");


                                break;
                            case 3:


                                System.out.println("Enter Tel Number:");
                                shop.tel = scanner.nextInt();

                                System.out.println("Enter Fax:");
                                shop.fax = scanner.nextInt();

                                System.out.println("Enter Email:");
                                shop.email = scanner.next();

                                System.out.println("Enter Website:");
                                shop.website = scanner.next();

                                FileWriter file1 = new FileWriter("invoice.txt", true);
                                file1.write("Tel: " + shop.tel + "\n");
                                file1.write("Fax: " + shop.fax + "\n");
                                file1.write("Email: " + shop.email + "\n");
                                file1.write("Website: " + shop.website + "\n\n");
                                file1.write("-------------------\n");

                                file1.close();
                                System.out.println("Details has been set successfully");


                                break;
                            case 4:
                                loop1 = false;
                                break;

                        }
                    }while (loop1);

                    break;

                case 2:
                    Boolean loop2 = true;
                    do {
                        subMenu.showSubMenu2();
                        System.out.println("Select an option");
                        int option2 = scanner.nextInt();

                        switch (option2){
                            case 1:
                                Boolean itm = true;
                                while (itm) {
                                    System.out.println("\nITEM DETAILS");
                                    System.out.println("__________________\n");

                                    System.out.println("Enter Item ID:");
                                    items.itemId = scanner.nextInt();

                                    System.out.println("Enter Item Name:");
                                    items.itemName = scanner.next();

                                    System.out.println("Enter Unit Price:");
                                    items.unitPrice = scanner.nextDouble();

                                    System.out.println("Enter Quantity:");
                                    items.quantity = scanner.nextInt();

                                    items.qtyAmount = items.unitPrice * items.quantity;
                                    System.out.println("The QTY Price is: " + items.qtyAmount);


                                    System.out.println("Do you want to add more items? y/n");
                                    String ans1 = scanner.next();
                                    if (ans1.equals("y") || ans1.equals("Y")) {
                                        itm = true;
                                    } else {
                                        try{
                                            FileOutputStream file = new FileOutputStream("invoice.txt", true);
                                            ObjectOutputStream out = new ObjectOutputStream(file);
                                            out.writeObject(items);
                                            out.close();
                                            file.close();
                                            System.out.println("serialized and saved");

                                        }catch (Exception e){
                                            e.printStackTrace();

                                        }
                                        itm = false;
                                    }
                                    items.itemList.add(items);
                                }

                                break;
                            case 2:

                                for(int i=0 ; i <items.itemList.size();i++) {
                                    String remove = items.itemList.remove(i).toString();
                                    System.out.println(remove);
                                }
                                break;
                            case 3:

                                System.out.println("Enter item name:");
                                items.itemName = scanner.next();

                                if(items.itemName.equals(items.itemName)){
                                    System.out.println("Enter item price");
                                    items.unitPrice = scanner.nextDouble();
                                    items.itemList.add(items);

                                }else{
                                    System.out.println("Item not found");
                                }

                                break;
                            case 4:

                                for(int i=0; i < items.itemList.size();i++){
                                    System.out.println("Item Name: " + items.itemName);
                                    System.out.println("Item ID: " + items.itemId);
                                    System.out.println("Item Price: " + items.unitPrice);
                                    System.out.println("Item Quantity: " + items.quantity);
                                    System.out.println("Item Quantity Amount: " + items.qtyAmount);
                                }

                                break;
                            case 5:
                                loop2 = false;
                                break;

                        }
                    }while (loop2);

                    break;
                case 3:

                    Boolean inv = true;
                    while (inv) {

                        System.out.println("Enter Invoice NO.: ");
                        invoices.invNO = scanner.nextInt();

                        System.out.println("Enter Name:");
                        invoices.costumerName = scanner.next();


                        System.out.println("Enter Phone Number:");
                        invoices.phone = scanner.nextInt();


                        System.out.println("Enter Invoice Date:");
                        invoices.date = scanner.next();

                        System.out.println("Enter Number of Items:");
                        invoices.numberOfItems = scanner.nextInt();

                        System.out.println("Enter Total Amount:");
                        invoices.totalAmount = scanner.nextDouble();

                        System.out.println("Enter Paid Amount:");
                        invoices.paidAmount = scanner.nextDouble();

                        invoices.balance = invoices.totalAmount - invoices.paidAmount;
                        System.out.println("The Balance is: " + invoices.balance);

                        System.out.println("Do you want to add more invoices? y/n");
                        String ans = scanner.next();
                        if (ans.equals("y") || ans.equals("Y")) {
                            inv = true;
                        } else {
                            try{
                                FileOutputStream file = new FileOutputStream("invoice.txt", true);
                                ObjectOutputStream out = new ObjectOutputStream(file);
                                out.writeObject(invoices);
                                out.close();
                                file.close();
                                System.out.println("serialized and saved");

                            }catch (Exception e){
                                e.printStackTrace();

                            }
                            inv = false;
                        }
                        invoices.invoiceList.add(invoices);
                    }

                    break;
                case 4:

                    System.out.println("Statistics:");
                    System.out.println("Number of Items: " + items.itemList.size());
                    System.out.println("Number of Invoices: " + invoices.invoiceList.size());
                    int sum = IntStream.of((int) items.unitPrice).sum();
                    System.out.println("Total Sales: "+ sum);

                    break;
                case 5:

                    for(int i=0; i < invoices.invoiceList.size();i++){
                        System.out.println("Invoice NO.: " + invoices.invNO);
                        System.out.println("Customer Name: "+ invoices.costumerName);
                        System.out.println("Customer Pone: "+ invoices.phone);
                        System.out.println("Invoice Date: "+ invoices.date);
                        System.out.println("Balance: "+ invoices.balance);


                    }

                    break;
                case 6:

                    System.out.println("Enter Invoice NO to search");
                    int invoNO = scanner.nextInt();

                    if(invoNO == invoices.invNO){
                        System.out.println("Invoice NO.: " + invoices.invNO);
                        System.out.println("Customer Name: "+ invoices.costumerName);
                        System.out.println("Customer Pone: "+ invoices.phone);
                        System.out.println("Invoice Date: "+ invoices.date);
                        System.out.println("Balance: "+ invoices.balance);
                        System.out.println("Item Name: " + items.itemName);
                        System.out.println("Item ID: " + items.itemId);
                        System.out.println("Item Price: " + items.unitPrice);
                        System.out.println("Item Quantity: " + items.quantity);
                        System.out.println("Item Quantity Amount: " + items.qtyAmount);
                    }

                    break;
                case 7:



                    break;
                case 8:
                    System.out.println("Are you sure you want to exit? If yes, program ends? y/n");
                    String select = scanner.next();
                    if(select.equals("y") || select.equals("Y")){
                        System.out.println("Goodbye..Thank you!!");
                        loop = false;
                    }else{
                        loop = true;
                    }


                    break;

           }

        } while (loop);

    }
}