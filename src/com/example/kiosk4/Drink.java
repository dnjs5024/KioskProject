package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Drink extends MenuItem{
    private String[] menuArray = {"Pepsi ","Sprite", "Fanta   "};
    private String[] priceArray = {"2.0", "2.0", "2.0"};
    private String[] descArray = {"팹시 제로", "스프라이트 시원한 사이다", "환타 오렌지맛"};
    List<MenuItem> menuItemList = new ArrayList<>();

    public Drink() {
        for (int i = 0; i < menuArray.length; i++) {
            menuItemList.add(new Drink(menuArray[i], priceArray[i], descArray[i], "Drinks"));
        }
    }

    public Drink(String menuName, String price, String description, String category) {
        super(menuName, price, description, category);
    }
    @Override
    public List<MenuItem> getSelectCategoryMenuList() {
        return menuItemList;
    }
}
