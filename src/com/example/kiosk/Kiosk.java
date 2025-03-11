package com.example.kiosk;

public class Kiosk {

    private String[] menuArray = {"ShackBurger ","SmokeShack  ","Cheeseburger","Hamburger   "};
    private String[] priceArray = {"6.9","8.9","6.9","5.4"};
    private String[] descArray = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","비프패티를 기반으로 야채가 들어간 기본버거"};

    public void selectMenu(int order){

        for(int i=0;i<menuArray.length;i++){
            System.out.println((i+1)+". " + menuArray[i] + "   | W " + priceArray[i] + " | " + descArray[i]);
        }
        System.out.println("0. 종료    | 종료");
        MenuItem menuItem = null;
        switch (order){
            case 1 : menuItem = new MenuItem("ShackBurger","6.9","토마토, 양상추, 쉑소스가 토핑된 치즈버거"); break;

            case 2 : menuItem = new MenuItem("SmokeShack","8.9","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"); break;

            case 3 : menuItem = new MenuItem("Cheeseburger","9.9","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"); break;

            case 4 : menuItem = new MenuItem("Hamburger","5.4","비프패티를 기반으로 야채가 들어간 기본버거"); break;

            case 0 : System.out.println("프로그램을 종료합니다."); break;
        }
    }
}
