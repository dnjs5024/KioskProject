package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface KioskFunction {
    //장바구니 구현
    List<MenuItem> orderMenuList = new ArrayList<>();
    public void viewShoppingCart();
    public void choiceMenuInsertShoppingCart(Scanner scanner,MenuItem choiceMenuItem);
    public void choiceMenuDeleteShoppingCart();
    public void choiceMenuSelectShoppingCart(Scanner scanner);
    public void doPaymentShoppingCart(Scanner scanner,int totalPrice);
}
