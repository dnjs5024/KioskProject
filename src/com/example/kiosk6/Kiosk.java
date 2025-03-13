package com.example.kiosk6;

import java.util.*;

public class Kiosk implements KioskFunction {
    //장바구니 구현
    List<MenuItem> orderMenuList = new ArrayList<>();
    //입력받을 수 있는 숫자 범위
    private int insertNumRange;
    private Menu menu = null;
    private String key = "Main";

    private final Map<String, List<String>> nextLocationKeySaveMap = new HashMap<>();

    private final Map<String, List<String>> selectUserQueryUIMap = new HashMap<>();

    //생성자
    public Kiosk(Menu menu) {
        this.menu = menu;
        insertNumRange = menu.getCategoryName().size();
        menu.addSelectItemUIMap("ORDER", new ArrayList<>(List.of("\"4. Orders    | 장바구니를 확인 후 주문합니다.\",\"5. Cancel    | 진행중인 주문을 취소합니다.\\n\"")));
        selectUserQueryUIMap.put("OrderMenu", new ArrayList<>(List.of("아래와 같이 주문 하시겠습니까?\n", "[ Orders ]", "[ Total ]", "1.   주문       2.  메뉴판         ")));
        selectUserQueryUIMap.put("Shopping", new ArrayList<>(List.of("위 메뉴를 장바구니에 추가하시겠습니까?", "1.   확인       2.  취소         ")));
        selectUserQueryUIMap.put("Main", new ArrayList<>(List.of("0. 종료    | 종료\n")));
        for (String key : menu.getSelectItemUIMap().keySet()) {
            selectUserQueryUIMap.put(key, new ArrayList<>(List.of("0. 뒤로가기    | 뒤로가기")));
        }
        //nextLocationKeySaveMap 세팅
        nextLocationKeySaveMap.put("Main",new ArrayList<>(List.of("Burgers","Drinks","Desserts","ORDER","Cancel")));
        nextLocationKeySaveMap.put("ORDER",new ArrayList<>(List.of("ORDER","Main")));

    }
    public void locationCheck(String key,Scanner scanner){
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
                settingMenuUI(key); //Key 가 Burgers, Drinks, Desserts 일 떄
                break;
        }
    }
    //콘솔에 선택한 카테고리의 메뉴 출력
    public void selectMenu(int selectNum)  {
        settingMenuUI(key);
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

    public void settingMenuUI(String key) {
        if (!menu.getSelectItemUIMap().get(key).isEmpty()) {
            System.out.println("[" + key + " Menu]");
        }
        int cnt = 1;
        for (String item : menu.getSelectItemUIMap().get(key)) {
            System.out.println(cnt + ". " + item);
            cnt++;
        }
        for (String item : selectUserQueryUIMap.get(key)) {
            System.out.println(item);
        }
    }

    public void putMap(String key, List<String> list) {
        this.menu.getSelectItemUIMap().put(key, list);
    }

    public void setSelectMenuSize(String key) {
        switch (key) {
            case ("Main"):
                this.insertNumRange = 4;
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
                this.insertNumRange = menu.getMenuItems().size();//Key 가 Burgers, Drinks, Desserts 일 떄
                break;
        }

    }

    //kiosk 실행
    public void start() {
        //false면 종료
        boolean flag = true;

        //사용자 입력
        Scanner scanner = new Scanner(System.in);
        while (flag) {

            // KEY 로 바라보고 있는 위치체크해서  UI 출력
            settingMenuUI(key);
            setSelectMenuSize(key);
            //장바구니에 메뉴 들어있으면 보여줌
            if (!orderMenuList.isEmpty()) settingMenuUI("ORDER");
            int selectNum = insertValueCheck(scanner);
//            //첫번째 선택화면 0 누르면 종료
//            if (selectNum == 0) {
//                flag = false;
//                System.out.println("프로그램을 종료합니다.");
//            } else if (3 < selectNum) {
//                if (selectNum == 4) choiceMenuSelectShoppingCart(scanner);
//                if (selectNum == 5) choiceMenuDeleteShoppingCart();
//            } else {
//                //내가 고른 카테고리의 메뉴 보이는 화면 0 누르면 뒤로가기
//                insertNumRange = menu.selectMenu(selectNum);
//                selectNum = insertValueCheck(scanner);
//                if (selectNum != 0) {
//                    //선택한 메뉴 보여줌
//                    System.out.println("선택한 메뉴 : " + menu.getMenuItems().get(selectNum - 1).toString() + "\n");
//                    insertNumRange = 2;
//                    choiceMenuInsertShoppingCart(scanner, menu.getMenuItems().get(selectNum - 1));
//                }
//            }
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
