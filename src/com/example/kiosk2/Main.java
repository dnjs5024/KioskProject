package com.example.kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private String[] menuArray = {"ShackBurger ","SmokeShack  ","Cheeseburger","Hamburger   "};
    private String[] priceArray = {"6.9","8.9","6.9","5.4"};
    private String[] descArray = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","비프패티를 기반으로 야채가 들어간 기본버거"};
    Kiosk kiosk = null;
    List<MenuItem> menuItemList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<main.menuArray.length;i++){
            System.out.println((i+1)+". " + main.menuItemList.get(i).getMenuName() + "   | W " + main.menuItemList.get(i).getPrice() + " | " + main.menuItemList.get(i).getDescription());
        }
        System.out.println("0. 종료    | 종료");
        main.kiosk.selectMenu(scanner.nextInt());
    }

    Main(){
        kiosk = new Kiosk();
        for(int i=0;i<menuArray.length;i++){
            menuItemList.add(new MenuItem(menuArray[i],priceArray[i],descArray[i]));
        }
    }


}