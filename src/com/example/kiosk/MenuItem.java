package com.example.kiosk;

public class MenuItem {

    private String menuName;
    private String price;
    private String description;

    //생성자
    public MenuItem(String menuName, String price, String description){
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    };



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

}
