package com.example.kiosk5;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }

    private Kiosk kiosk = null;

    Main() {
        kiosk = new Kiosk();
    }


}