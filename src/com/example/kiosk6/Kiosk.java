package com.example.kiosk6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk implements KioskFunction {

    //입력받을 수 있는 숫자 범위
    private int insertNumRange;
    private Menu menu = null;

    //생성자
    public Kiosk() {
        menu = new Menu();
        insertNumRange = menu.getCategoryName().length;
    }

    public static String changeStringFormat(Integer price) {
        return (price / 1000) + "." + (price / 100 % 10);
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
            insertNumRange = menu.getCategoryName().length;
            menu.showMainMenu();
            //장바구니에 메뉴 들어있으면 보여줌
            if (!orderMenuList.isEmpty()) viewShoppingCart();
            insertNumRange += 2;
            int selectNum = insertValueCheck(scanner);
            //첫번째 선택화면 0 누르면 종료
            if (selectNum == 0) {
                flag = false;
                System.out.println("프로그램을 종료합니다.");
            } else if (3 < selectNum) {
                if (selectNum == 4) choiceMenuSelectShoppingCart(scanner);
                if (selectNum == 5) choiceMenuDeleteShoppingCart();
            } else {
                //내가 고른 카테고리의 메뉴 보이는 화면 0 누르면 뒤로가기
                insertNumRange = menu.selectMenu(selectNum);
                selectNum = insertValueCheck(scanner);
                if (selectNum != 0) {
                    //선택한 메뉴 보여줌
                    System.out.println("선택한 메뉴 : " + menu.getMenuItems().get(selectNum - 1).toString()+"\n");
                    insertNumRange = 2;
                    choiceMenuInsertShoppingCart(scanner, menu.getMenuItems().get(selectNum - 1));
                }
            }
        }
        scanner.close();
    }

    @Override
    public void viewShoppingCart() {
        System.out.println("[ORDER Menu]");
        System.out.println("4. Orders    | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.\n");
    }

    @Override
    public void choiceMenuInsertShoppingCart(Scanner scanner, MenuItem choiceMenuItem) {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.   확인       2.  취소         ");
        if (insertValueCheck(scanner) == 1) {
            orderMenuList.add(choiceMenuItem);
            System.out.println(choiceMenuItem.getMenuName() + " 이 장바구니에 추가되었습니다.\n");
        }
    }

    @Override
    public void choiceMenuDeleteShoppingCart() {
        orderMenuList.clear();
    }

    @Override
    public void choiceMenuSelectShoppingCart(Scanner scanner) {
        int totalPrice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (MenuItem menuItem : orderMenuList) {
            System.out.println(menuItem.toString());
            totalPrice += menuItem.getPrice();
        }
        System.out.println("[ Total ]");
        System.out.println("W " + changeStringFormat(totalPrice));
        System.out.println("1.   주문       2.  메뉴판         ");
        int selectNum = insertValueCheck(scanner);
        if (selectNum == 1) doPaymentShoppingCart(scanner, totalPrice);
    }

    @Override
    public void doPaymentShoppingCart(Scanner scanner, int totalPrice) {
        System.out.println("1. 국가유공자 : 10% \n2. 군인     :  5% \n3. 학생     :  3% \n4. 일반     :  0%\n");
        System.out.println("할인 정보를 입력해주세요.");
        int selectNum = insertValueCheck(scanner);
        switch(selectNum){
            case 1 : totalPrice -= totalPrice/100*10; break;
            case 2 : totalPrice -= totalPrice/100*5; break;
            case 3 : totalPrice -= totalPrice/100*3; break;
            case 4 :  break;
        }
        System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice + " 원 입니다.\n");
        orderMenuList.clear();
    }
}
