# Kiosk Project

## 개요

Kiosk Project는 무인 주문 시스템을 위한 CLI 기반 애플리케이션입니다. 사용자는 메뉴를 선택하고 장바구니에 담고 결제할 수 있습니다

## 주요 기능

- **사용자 모드**
  - 메뉴 선택 및 장바구니 기능
  - 결제 및 주문 확인

- **기타 기능**
  - 데이터 검증 및 예외 처리

## 기술 스택

- **언어**: Java
- **개발 도구**: IntelliJ IDEA
- **기타**: 파일 입출력, 컬렉션 프레임워크 활용

## 프로젝트 구조

```
KioskProject/
│── src/
│   ├── com/
│   │   ├── example/
│   │   │   ├── kiosk1/    //LV1
│   │   │   ├── kiosk2/    //LV2
│   │   │   ├── kiosk3/    //LV3
│   │   │   ├── kiosk4/    //LV4
│   │   │   ├── kiosk5/    //LV5
│   │   │   ├── kiosk6/ ├── Main.class //도전과제 LV1,2 실행 클래스
                        ├── Kiosk.java // 키오스크 기능 구현 클래스
                        ├── Menu.java //MenuItem 관리 클래스
                        ├── Drink.java //MenuItem 
                        ├── Burger.java //MenuItem 
                        ├── Dessert.java //MenuItem 
                        ├── MenuItem.java //메뉴담아주는 클래스
                        ├── KioskFunction.java //키오스크 기능 인터페이스
                        └── Payment.java //결제 enum

```
## 코드 리뷰

3. [🛠 코드 순서](#-코드-순)
    - [Main](#main)   
    - [MenuItem](#menuitem)   
    - [Burger](#burger)   
    - [Menu](#menu)      
    - [Kiosk](#kiosk)   


- ## Main 

👉 프로그램 시작 부분

```java
package com.example.kiosk6;

public class Main {

    private Kiosk kiosk = null;

    Main() {
        Menu menu = new Menu();//MenuItem 데이터들 초기 세팅
        kiosk = new Kiosk();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.kiosk.start();
    }
}
```
- ## MenuItem 

👉 변수 선언, 게터 세터 구현 ,menuItem 담는 리스트 가져오기 위한 메소드 , toString 구현

```java
public class MenuItem {

    private String menuName;
    private Integer price;
    private String description;
    private String category;

    //생성자
    public MenuItem(String menuName, Integer price, String description, String category) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public MenuItem() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<MenuItem> getSelectCategoryMenuList() {
        return null;
    }

    @Override
    public String toString() {
        return   menuName +
                "  | W " + (price / 1000) + "." + (price / 100 % 10) +
                "  | " + description;
    }
}
``` 
- ## Burger

👉 아이템 담는 리스트, menuItemList에 값 저장하고 getter로 접근근
  
```java
package com.example.kiosk6;


import java.util.ArrayList;
import java.util.List;

public class Burger extends MenuItem {

    private String[] menuArray = {"ShackBurger ", "SmokeShack  ", "Cheeseburger", "Hamburger   "};
    private Integer[] priceArray = {6900, 8900, 6900, 5400};
    private String[] descArray = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};
    private List<MenuItem> menuItemList = new ArrayList<>();
    private final String category = "Burgers";


    public Burger() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemList.add(new Burger(menuArray[i], priceArray[i], descArray[i], category));
        }
    }

    public Burger(String menuName, Integer price, String description, String category) {
        super(menuName, price, description, category);
    }

    @Override
    public List<MenuItem> getSelectCategoryMenuList() {
        return new ArrayList<>(menuItemList);
    }

    @Override
    public String getCategory() {
        return category;
    }
}
```
- ## Menu

👉 menuItem 관리 kiosk에서 데이터 요청하면 보내주는 역할

```java

package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    //MenuItem 객체 관리하는 리스트 현재 선택한 카테고리의 아이템을 담아줌
    private List<MenuItem> menuItemList = new ArrayList<>();
    //모든 메뉴의 데이터 저장
    private List<MenuItem> categoryList = new ArrayList<>(List.of(new Burger(), new Drink(), new Dessert()));
    //카테고리 이름 담는 리스트
    private String[] categoryName = new String[categoryList.size()];

    public Menu() {
        //카테고리이름 동적 생성
        for (int i = 0; i < categoryList.size(); i++) {
            categoryName[i] = categoryList.get(i).getCategory();
        }
    }

    //선택한 카테고리의 아이템들 리턴
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItemList);//리스트 수정 막기 위해 복사해서 리턴
    }
    //카테고리 아이템 중 선택한 메뉴를 menuItemList에 담아줌
    public void setMenuItemList(int selectNum) {
        this.menuItemList = categoryList.get(selectNum - 1).getSelectCategoryMenuList();
    }

    public String[] getCategoryName() {
        return categoryName;
    }

}

```
- ## Kiosk

  👉 데이터 직접 접근 x ,menu 에게서 받음 사용자에게 보여줄 화면과 입력값 처리, 장바구니 기능 수행

```java
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
        System.out.println("[" + menu.getCategoryName()[selectNum - 1] + " Menu]");
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
            } else if (menu.getCategoryName().length < selectNum) {//주문 , 장바구니 삭제 부분
                if (selectNum == menu.getCategoryName().length + 1) continuePaymentCheck(scanner);//주문
                if (selectNum == menu.getCategoryName().length + 2) choiceMenuDeleteToShoppingCart(scanner);//삭제
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
        // 1. 국가유공자 : 10% 식으로 출력
        for (int i = 0; i < Payment.values().length; i++) {
            Payment item = Payment.values()[i];
            System.out.println(i + 1 + ". " + item.getKrName() + " : " + item.getSale() + "%");
        }
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
```
- ## Kiosk 예제 실행 결과
- 😁 첫 화면
![image](https://github.com/user-attachments/assets/937d2628-8dc7-4d3c-b0f2-912797379d48)
- 😁 첫 화면 + 장바구니에 물건 있을 경우
![image](https://github.com/user-attachments/assets/5a98e808-9d05-4e7b-8ee6-2e605cf5b3a5)
- 😁 선택 카테고리 메뉴들
![image](https://github.com/user-attachments/assets/2c8fb04e-e6f1-4a5a-a6db-63ea374bee28)
- 😁 장바구니 추가
![image](https://github.com/user-attachments/assets/c0c9f5dc-54f0-471f-9096-a112f5b42fa1)
- 😁 장바구니 조회,삭제
![image](https://github.com/user-attachments/assets/6180c269-62dc-4249-88ea-cb1af1564f15)
- 😁 주문 
![image](https://github.com/user-attachments/assets/ded05c97-8968-4d29-9ec0-a614de8a2176)


