package com.example.kiosk3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    //MenuItem 객체 관리하는 리스트
    List<MenuItem> menuItemList = null;
    //생성자
    public Kiosk(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public int insertValueCheck(Scanner scanner) {
        int orderNum = 0;
        while (true) {
            try {
                orderNum = scanner.nextInt();
                scanner.nextLine();
                return orderNum;
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine();
            }
        }

    }


    //kiosk 실행
    public void start() {
        //false면 종료
        boolean flag = true;
        //콘솔에 메뉴 출력
        for (int i = 0; i < menuItemList.size(); i++) {
            System.out.println((i + 1) + ". " + menuItemList.get(i).getMenuName() + "   | W " + menuItemList.get(i).getPrice() + " | " + menuItemList.get(i).getDescription());
        }
        System.out.println("0. 종료    | 종료");
        //사용자 입력
        Scanner scanner = new Scanner(System.in);
        while (flag) {

            switch (insertValueCheck(scanner)) {
                case 1:
                    System.out.println("ShackBurger 6.9 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;

                case 2:
                    System.out.println("SmokeShack 8.9 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;

                case 3:
                    System.out.println("Cheeseburger 9.9 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;

                case 4:
                    System.out.println("Hamburger 5.4 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;

                case 0:
                    flag = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("0 ~ 4 입력하세요");
            }
        }

        scanner.close();
    }
}
