package com.example.kiosk7.kiosk6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Menu {

    //카테고리별 메뉴 데이터 저장하는 리스트
    private List<MenuItem> categoryMenuItemList = new ArrayList<>(List.of(new Burger(), new Drink(), new Dessert()));
    //카테고리별 제목 저장하는 리스트
    private List<String> categoryTitle = new ArrayList<>();


    //생성자
    Menu() {
        //카테고리 제목 가져와서 저장
        for (int i = 0; i < categoryMenuItemList.size(); i++) {
            categoryTitle.add(categoryMenuItemList.get(i).getCategory());
        }
        KioskKey.MAIN.setItemList(categoryTitle);
    }


    public List<String> getCategoryTitle() {
        return categoryTitle;
    }

    public List<String> getCategoryMenuItemList(int orderNum) {
        MenuItem item = categoryMenuItemList.get(orderNum-1);
        List<String> tempList = new ArrayList<>();
        for (Integer key : item.getMenuItemMap().keySet()) {
            tempList.add(item.getMenuItemMap().get(key).toString());
        }
        return tempList;
    }


}

