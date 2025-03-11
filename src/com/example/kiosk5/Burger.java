package com.example.kiosk5;


import java.util.ArrayList;
import java.util.List;

public class Burger extends MenuItem {

    private String[] menuArray = {"ShackBurger ", "SmokeShack  ", "Cheeseburger", "Hamburger   "};
    private String[] priceArray = {"6.9", "8.9", "6.9", "5.4"};
    private String[] descArray = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Burger() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemList.add(new Burger(menuArray[i], priceArray[i], descArray[i], "Burgers"));
        }
    }

    public Burger(String menuName, String price, String description, String category) {
        super(menuName, price, description, category);
    }
    @Override
    public List<MenuItem> getSelectCategoryMenuList() {
        return new ArrayList<>(menuItemList);
    }
}
