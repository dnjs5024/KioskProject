package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Main {


    Kiosk kiosk = null;

    Main() {
        kiosk = new Kiosk();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }
}