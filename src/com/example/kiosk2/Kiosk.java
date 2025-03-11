package com.example.kiosk2;

public class Kiosk {


    public void selectMenu(int order){

        switch (order){
            case 1 : System.out.println("ShackBurger 6.9 토마토, 양상추, 쉑소스가 토핑된 치즈버거"); break;

            case 2 : System.out.println("SmokeShack 8.9 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"); break;

            case 3 : System.out.println("Cheeseburger 9.9 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"); break;

            case 4 : System.out.println("Hamburger 5.4 비프패티를 기반으로 야채가 들어간 기본버거"); break;

            case 0 : System.out.println("프로그램을 종료합니다."); break;
        }
    }
}
