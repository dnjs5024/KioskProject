package com.example.kiosk6;

import java.util.List;

public class MenuItem {

    private String menuName;
    private Integer price;
    private String description;
    private String category;

    //생성자
    public MenuItem(String menuName, Integer price, String description, String category) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public MenuItem() {}

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<MenuItem> getSelectCategoryMenuList() {
        return null;
    }

    @Override
    public String toString() {
        return   menuName +
                "  | W " + (price / 1000) + "." + (price / 100 % 10) +
                "  | " + description;
    }
}