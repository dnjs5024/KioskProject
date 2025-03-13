package com.example.kiosk7.kiosk6;

import java.util.*;

public class Kiosk implements KioskFunction {
    //장바구니 구현
    List<MenuItem> orderMenuList = new ArrayList<>();
    //입력받을 수 있는 숫자 범위
    private int insertNumRange;
    private Menu menu = null;
    private String key = "Main";
    private KioskKey kioskKey = null;

    private final Map<String, List<String>> nextLocationKeySaveMap = new HashMap<>();
    private final Map<String, List<String>> getSelectItemUIMap = new HashMap<>();


    //생성자
    public Kiosk(Menu menu) {
        this.menu = menu;

    }

    public void locationCheck(String key, Scanner scanner) {
        int selectNum = insertValueCheck(scanner);
        switch (key) {
            case ("Main"):
                break;
            case ("ORDER"):
                this.insertNumRange = 6;
                break;
            case ("OrderMenu"):
                this.insertNumRange = 3;
                break;
            case ("Shopping"):
                this.insertNumRange = 3;
                break;
            default:
                //Key 가 Burgers, Drinks, Desserts 일 떄
                break;
        }
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

       while(kioskKey==KioskKey.END){

       }
        Scanner scanner = new Scanner(System.in);
        //화면출력
        kioskKey = KioskKey.MAIN;
        setSelectMenuSize(kioskKey);
        settingMenuUI(kioskKey);
        selectMenu(scanner.nextInt());


//            //장바구니에 메뉴 들어있으면 보여줌
//            if (!orderMenuList.isEmpty()) settingMenuUI("ORDER");

    }

    //콘솔에 선택한 카테고리의 메뉴 출력
    public void selectMenu(int orderNum) {
        kioskKey = KioskKey.ITEMS;
        kioskKey.setItemList(menu.getCategoryMenuItemList(orderNum));
    }

    public void settingMenuUI(KioskKey kioskKey) {
        System.out.println("[" + kioskKey.getKeyName() + " Menu]");
        for (int i = 0; i < kioskKey.getItemList().size(); i++) {
            System.out.println(i + 1 + ". " + kioskKey.getItemList().get(i));
        }
    }

    public void setSelectMenuSize(KioskKey kioskKey) {
        switch (kioskKey.getKeyName()) {
            case ("MAIN"):
                KioskKey.MAIN.setInsertNumRange(4);
                break;
            case ("ITEMS"):
                this.insertNumRange = KioskKey.ITEMS.getItemList().size();
                break;
            case ("OrderMenu"):
                this.insertNumRange = 3;
                break;
            case ("Shopping"):
                this.insertNumRange = 3;
                break;
            default:
                break;
        }

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
        switch (selectNum) {
            case 1:
                totalPrice -= totalPrice / 100 * 10;
                break;
            case 2:
                totalPrice -= totalPrice / 100 * 5;
                break;
            case 3:
                totalPrice -= totalPrice / 100 * 3;
                break;
            case 4:
                break;
        }
        System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice + " 원 입니다.\n");
        orderMenuList.clear();
    }
}
