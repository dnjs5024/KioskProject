package com.example.kiosk7.kiosk6;

public class Main {

    private Kiosk kiosk = null;

    Main() {
        Menu menu = new Menu();
        kiosk = new Kiosk(menu);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }
}