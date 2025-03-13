package com.example.kiosk7.kiosk6;

import java.util.HashMap;
import java.util.Map;

public class Drink extends MenuItem {
    private String[] menuArray = {"Pepsi ","Sprite", "Fanta   "};
    private Integer[] priceArray = {2000, 2000, 2000};
    private String[] descArray = {"팹시 제로", "스프라이트 시원한 사이다", "환타 오렌지맛"};
    private Map<Integer,MenuItem> menuItemMap = new HashMap<>();
    private final String category = "Drinks";

    public Drink() {

        for (int i = 0; i < menuArray.length; i++) {
            menuItemMap.put(i+1,new Burger(menuArray[i], priceArray[i], descArray[i], category));
        }
    }


    public Drink(String menuName, Integer price, String description, String category) {
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
