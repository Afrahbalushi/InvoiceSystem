package org.example;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

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

                    

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Goodbye..Thank you!!");
                    loop = false;

                    break;

           }

        } while (loop);

    }
}