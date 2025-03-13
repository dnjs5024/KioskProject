package com.example.kiosk7.kiosk6;

import java.util.HashMap;
import java.util.Map;

public class Burger extends MenuItem {

    private String[] menuArray = {"ShackBurger ", "SmokeShack  ", "Cheeseburger", "Hamburger   "};
    private Integer[] priceArray = {6900, 8900, 6900, 5400};
    private String[] descArray = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};
    private Map<Integer, MenuItem> menuItemMap = new HashMap<>();

    private final String category = "Burgers";

    public Burger() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemMap.put(i + 1, new Burger(menuArray[i], priceArray[i], descArray[i], category));
        }
    }


    public Burger(String menuName, Integer price, String description, String category) {
        super(menuName, price, description, category);
    }

    @Override
    public String getCategory() {
        return category;
    }
    @Override
    public Map<Integer, MenuItem> getMenuItemMap() {
        return this.menuItemMap;
    }
}
