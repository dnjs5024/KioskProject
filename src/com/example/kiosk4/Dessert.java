package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends MenuItem{
    private String[] menuArray = {"French fries ", "Cheese Stick  ", "Shake fries", "Vanilla Iscream   "};
    private String[] priceArray = {"1.5", "2.5", "2.0", "1.5"};
    private String[] descArray = {"바삭한 감자튀김", "치즈스틱", "흔들어 먹는 감자튀김", "바닐라 아이스크림"};
    List<MenuItem> menuItemList = new ArrayList<>();

    public Dessert() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemList.add(new Dessert(menuArray[i], priceArray[i], descArray[i], "Desserts"));
        }
    }

    public Dessert(String menuName, String price, String description, String category) {
        super(menuName, price, description, category);
    }
    @Override
    public List<MenuItem> getSelectCategoryMenuList() {
        return menuItemList;
    }
}
