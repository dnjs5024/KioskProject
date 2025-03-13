
package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    //MenuItem 객체 관리하는 리스트 현재 선택한 카테고리의 아이템을 담아줌
    private List<MenuItem> menuItemList = new ArrayList<>();
    //카테고리 이름 담는 리스트
    private String[] categoryName = {"Burgers", "Drinks", "Desserts"};

    private List<MenuItem> categoryList = new ArrayList<>(List.of(new Burger(), new Drink(), new Dessert()));


    //선택한 카테고리의 아이템들 리턴
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItemList);//리스트 수정 막기 위해 복사해서 리턴
    }

    public void setMenuItemList(int selectNum) {
        this.menuItemList = categoryList.get(selectNum - 1).getSelectCategoryMenuList();
    }

    public String[] getCategoryName() {
        return categoryName;
    }

}
