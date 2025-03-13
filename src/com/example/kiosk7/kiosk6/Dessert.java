package com.example.kiosk7.kiosk6;

import java.util.HashMap;
import java.util.Map;

public class Dessert extends MenuItem {
    private String[] menuArray = {"French fries ", "Cheese Stick  ", "Shake fries", "Vanilla Iscream   "};
    private Integer[] priceArray = {1500, 2500, 2000, 1500};
    private String[] descArray = {"바삭한 감자튀김", "치즈스틱", "흔들어 먹는 감자튀김", "바닐라 아이스크림"};
    private Map<Integer,MenuItem> menuItemMap = new HashMap<>();
    private final String category = "Desserts";

    public Dessert() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemMap.put(i+1,new Burger(menuArray[i], priceArray[i], descArray[i], category));
        }
    }

    public Dessert(String menuName, Integer price, String description, String category) {
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
