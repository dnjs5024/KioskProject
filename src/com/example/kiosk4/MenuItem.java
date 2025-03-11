package com.example.kiosk4;

import java.util.List;

public class MenuItem {

    private String menuName;
    private String price;
    private String description;
    private String category;

    //생성자
    public MenuItem(String menuName, String price, String description, String category) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    ;

    public MenuItem() {

    }

    ;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<MenuItem> getSelectCategoryMenuList() {
        return null;
    }
}
