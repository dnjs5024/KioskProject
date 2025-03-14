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
