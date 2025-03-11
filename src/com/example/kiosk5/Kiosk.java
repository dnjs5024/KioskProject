package com.example.kiosk5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {

    //입력받을 수 있는 숫자 범위
    private int insertNumRange;
    private Menu menu = null;

    //생성자
    public Kiosk() {
        menu = new Menu();
        insertNumRange = menu.getCategoryName().length;
    }

    public int insertValueCheck(Scanner scanner) {
        int orderNum = 0;
        while (true) {
            try {
                orderNum = scanner.nextInt();
                if (insertNumRange < orderNum || orderNum < 0) {
                    System.out.println("범위안의 수를 입력하세요.");
                } else {
                    scanner.nextLine();
                    return orderNum;
                }
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

        //사용자 입력
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            menu.showMainMenu();
            int selectNum = insertValueCheck(scanner);
            if (selectNum == 0) {
                flag = false;
                System.out.println("프로그램을 종료합니다.");
            } else {
                insertNumRange = menu.selectMenu(selectNum);
                selectNum = insertValueCheck(scanner);
                if (selectNum != 0) {
                    System.out.println("선택한 메뉴 : " + menu.getMenuItems().get(selectNum - 1).getMenuName() + "   | W " + menu.getMenuItems().get(selectNum - 1).getPrice() + " | " + menu.getMenuItems().get(selectNum - 1).getDescription());
                }
                insertNumRange = menu.getCategoryName().length;
            }
        }
        scanner.close();
    }
}
