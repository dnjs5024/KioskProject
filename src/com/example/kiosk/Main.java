package com.example.kiosk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        Scanner scanner = new Scanner(System.in);
        kiosk.selectMenu(scanner.nextInt());
    }
}