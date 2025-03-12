package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    //MenuItem 객체 관리하는 리스트
    private List<MenuItem> menuItemList = new ArrayList<>();
    //카테고리 이름 담는 리스트
    private String[] categoryName = {"Burgers","Drinks","Desserts"};

    private List<MenuItem> categoryList = new ArrayList<>(List.of(new Burger(),new Drink(),new Dessert()));

    //생성자
    Menu() {
    }

    //콘솔에 메인 메뉴 출력
    public void showMainMenu() {
        System.out.println("[Main Menu]");
        int cnt = 1;
        for(String title : categoryName){
            System.out.println(cnt+". "+title);
            cnt++;
        }
        System.out.println("0. 종료    | 종료\n");
    }
    //콘솔에 선택한 카테고리의 메뉴 출력
    public int selectMenu(int selectNum)  {
        try{
            menuItemList = categoryList.get(selectNum-1).getSelectCategoryMenuList();

            for (int i = 0; i < menuItemList.size(); i++) {
                System.out.println((i + 1) + ". " + menuItemList.get(i).toString());
            }
            System.out.println("0. 뒤로가기    | 뒤로가기");
        }catch(IndexOutOfBoundsException e){
            System.out.println("올바른 범위 수");
        }
//        if(selectNum > menuItemList.size()){
//        }
        return menuItemList.size();
    }

    public List<MenuItem> getMenuItems(){
         return new ArrayList<>(menuItemList);//리스트 수정 막기 위해 복사해서 리턴
    }

    public String[] getCategoryName() {
        return categoryName;
    }

}

