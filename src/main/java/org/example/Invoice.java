package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {

    String costumerName;
    int phone;
    String date;
    int numberOfItems;
    double totalAmount;
    double paidAmount;
    double balance ;

   ArrayList invoiceList = new ArrayList();

}
