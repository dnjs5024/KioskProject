package com.example.kiosk6;

public class Main {

    private Kiosk kiosk = null;

    Main() {
        kiosk = new Kiosk();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }
}