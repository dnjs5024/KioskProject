package com.example.kiosk6;

public class Main {

    private Kiosk kiosk = null;

    Main() {
        Menu menu = new Menu();//MenuItem 데이터들 초기 세팅
        kiosk = new Kiosk();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }
}