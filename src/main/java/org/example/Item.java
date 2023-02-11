package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    int itemId;
    String itemName;
    double unitPrice;
    int quantity;
    double qtyAmount;

     ArrayList itemList = new ArrayList();

}
