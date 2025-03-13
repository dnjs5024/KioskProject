package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface KioskFunction {

    public void viewShoppingCart();
    public void choiceMenuInsertShoppingCart(Scanner scanner,MenuItem choiceMenuItem);
    public void choiceMenuDeleteShoppingCart();
    public void choiceMenuSelectShoppingCart(Scanner scanner);
    public void doPaymentShoppingCart(Scanner scanner,int totalPrice);
}
