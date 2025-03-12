package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends MenuItem {
    private String[] menuArray = {"French fries ", "Cheese Stick  ", "Shake fries", "Vanilla Iscream   "};
    private Integer[] priceArray = {1500, 2500, 2000, 1500};
    private String[] descArray = {"바삭한 감자튀김", "치즈스틱", "흔들어 먹는 감자튀김", "바닐라 아이스크림"};
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Dessert() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemList.add(new Dessert(menuArray[i], priceArray[i], descArray[i], "Desserts"));
        }
    }

    public Dessert(String menuName, Integer price, String description, String category) {
        super(menuName, price, description, category);
    }
    @Override
    public List<MenuItem> getSelectCategoryMenuList() {
        return new ArrayList<>(menuItemList);
    }
}
