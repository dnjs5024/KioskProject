package com.example.kiosk6;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kiosk implements KioskFunction {

    //입력받을 수 있는 숫자 범위
    private int insertSuffix;//입력 받을 값 마지막
    private int insertPreFix = 0;// 입력 받을 값 시작

    private Menu menu = null;

    //생성자
    public Kiosk() {
        menu = new Menu();
        insertSuffix = menu.getCategoryName().length;
    }

    /**
     * @param price
     * @return int 형식의 가격을 출력하기 좋은 String 형태로 바꿔줌
     */
    public static String changeStringFormat(Integer price) {
        return (price / 1000) + "." + (price / 100 % 10);
    }

    /**
     * @param scanner
     * @return 입력받은 수 를 체크해서 제대로된 입력 값이면 돌려줌
     */
    public int insertValueCheck(Scanner scanner) {
        int orderNum = 0;
        while (true) {
            try {
                orderNum = scanner.nextInt();
                if (insertSuffix < orderNum || orderNum < insertPreFix) {
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

    //콘솔에 메인 메뉴 출력
    public void showMainMenu() {
        System.out.println("[Main Menu]");
        IntStream.range(0, menu.getCategoryName().length).forEach(cnt -> System.out.println(cnt + 1 + ". " + menu.getCategoryName()[cnt]));
        System.out.println("0. 종료    | 종료\n");
    }

    //콘솔에 선택한 카테고리의 메뉴 출력
    public void selectMenu(int selectNum) {
        System.out.println("[" + menu.getCategoryName()[selectNum-1] + " Menu]");
        IntStream.range(0, menu.getMenuItems().size()).forEach(cnt -> System.out.println(cnt + 1 + ". " + menu.getMenuItems().get(cnt).toString()));
        System.out.println("0. 뒤로가기    | 뒤로가기");
    }

    /**
     * 키오스크 실행부분
     */
    public void start() {
        //false면 종료
        boolean flag = true;

        //사용자 입력
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            //입력 범위 초기화
            insertSuffix = menu.getCategoryName().length;
            insertPreFix = 0;

            showMainMenu();
            //장바구니에 메뉴 들어있으면 보여줌
            if (!orderMenuList.isEmpty()) {
                viewShoppingCartUI();
                insertSuffix += 2;
            }
            int selectNum = insertValueCheck(scanner);
            //첫번째 선택화면 0 누르면 종료
            if (selectNum == 0) {
                flag = false;
                System.out.println("프로그램을 종료합니다.");
            } else if (3 < selectNum) {
                if (selectNum == 4) continuePaymentCheck(scanner);
                if (selectNum == 5) choiceMenuDeleteToShoppingCart(scanner);
            } else {
                //내가 고른 카테고리의 메뉴 보이는 화면 0 누르면 뒤로가기
                menu.setMenuItemList(selectNum);
                insertSuffix = menu.getMenuItems().size();
                selectMenu(selectNum);//콘솔에 선택한 카테고리의 메뉴 출력
                selectNum = insertValueCheck(scanner);
                if (selectNum != 0) {
                    //선택한 메뉴 보여줌
                    System.out.println("선택한 메뉴 : " + menu.getMenuItems().get(selectNum - 1).toString() + "\n");
                    choiceMenuInsertToShoppingCart(scanner, menu.getMenuItems().get(selectNum - 1));
                }
            }
        }
        scanner.close();
    }


    @Override
    public void setUserInsertValueSize() {
    }

    /**
     * 장바구니에 물건이 있다면 보여주는 UI
     */
    @Override
    public void viewShoppingCartUI() {
        System.out.println("[ORDER Menu]");
        System.out.println("4. Orders    | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.\n");
    }

    /**
     * @param scanner
     * @param choiceMenuItem 선택한 메뉴 정보
     *                       <p>
     *                       선택한 메뉴 장바구니에 넣을지 체크
     */
    @Override
    public void choiceMenuInsertToShoppingCart(Scanner scanner, MenuItem choiceMenuItem) {
        //입력 범위지정
        insertPreFix = 1;
        insertSuffix = 2;
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.   확인       2.  취소         ");
        if (insertValueCheck(scanner) == 1) {// 확인 눌렀으므로 저장
            orderMenuList.add(choiceMenuItem);
            System.out.println(choiceMenuItem.getMenuName() + " 이(가) 장바구니에 추가되었습니다.\n");
        }
    }

    /**
     * 선택한 메뉴 장바구니에서 제거하는 메소드
     */
    @Override
    public void choiceMenuDeleteToShoppingCart(Scanner scanner) {
        //범위 지정
        insertPreFix = 1;
        insertSuffix = orderMenuList.size();
        selectShoppingCart();//장바구니 내용 보여줌
        int orderNum = insertValueCheck(scanner) - 1;
        System.out.println(orderMenuList.get(orderNum).getMenuName() + " 이(가) 장바구니에 삭제되었습니다.\n");
        orderMenuList.remove(orderNum);//선택 메뉴 제거
    }

    /**
     * 장바구니에 들어있는 메뉴를 보여줌
     */
    @Override
    public void selectShoppingCart() {
        IntStream.range(0, orderMenuList.size()).forEach(cnt -> System.out.println(cnt + 1 + ". " + orderMenuList.get(cnt)));
    }

    /**
     * @param scanner 계속 결제를 진행 할 지 체크함 장바구니 내용,총 가격 보여줌
     */
    @Override
    public void continuePaymentCheck(Scanner scanner) {
        //입력 범위지정
        insertPreFix = 1;
        insertSuffix = 2;
        int totalPrice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        selectShoppingCart();//장바구니 내용 가져오기
        totalPrice = orderMenuList.stream().map(MenuItem::getPrice).reduce(Integer::sum).orElse(totalPrice);//총 결제 할 가격
        System.out.println("[ Total ]");
        System.out.println("W " + changeStringFormat(totalPrice));
        System.out.println("1.   주문       2.  메뉴판         ");
        int selectNum = insertValueCheck(scanner);
        if (selectNum == 1) doPaymentShoppingCart(scanner, totalPrice);
    }

    /**
     * @param scanner
     * @param totalPrice 결제를 진행하는 메소드 할인 정보를 입력받고 진행함
     */
    @Override
    public void doPaymentShoppingCart(Scanner scanner, int totalPrice) {
        Payment payment = null;
        System.out.println("1. 국가유공자 : 10% \n2. 군인     :  5% \n3. 학생     :  3% \n4. 일반     :  0%\n");
        System.out.println("할인 정보를 입력해주세요.");
        payment = switch (insertValueCheck(scanner)) {
            case 1 -> Payment.NMPERSON;
            case 2 -> Payment.ARMY;
            case 3 -> Payment.STUDENT;
            case 4 -> Payment.CITIZEN;
            default -> payment;
        };
        System.out.println("주문이 완료되었습니다. 금액은 " + payment.getFinalPrice(totalPrice) + " 원 입니다.\n");
        orderMenuList.clear();//결제 완료 후 장바구니 초기화
    }


}