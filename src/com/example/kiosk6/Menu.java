package com.example.kiosk6;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    //MenuItem 객체 관리하는 리스트
    private List<MenuItem> menuItemList = new ArrayList<>();
    //카테고리 이름 담는 리스트
    private List<String> categoryName = new ArrayList<>();
    //카테고리별 메뉴 데이터 저장하는 리스트
    private List<MenuItem> categoryList = new ArrayList<>(List.of(new Burger(),new Drink(),new Dessert()));
    private final Map<String, List<String>> selectItemUIMap = new HashMap<>();



    //생성자
    Menu() {
        for (MenuItem menuItem : categoryList) {
            String key = "";
            List<String>list = new ArrayList<>();
            for(MenuItem item  : menuItem.getSelectCategoryMenuList()){
                key = item.getCategory();
                list.add(item.toString());
            }
            selectItemUIMap.put(key,list);
            categoryName.add(key);
        }
        selectItemUIMap.put("Main",categoryName);
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

    public List<MenuItem> getCategoryList() {
        return new ArrayList<>(categoryList);
    }

    public Map<String, List<String>> getSelectItemUIMap() {
        return selectItemUIMap;
    }
    public void addSelectItemUIMap(String key,List<String> list) {
         selectItemUIMap.put(key,list);
    }

    public List<MenuItem> getMenuItems(){
         return new ArrayList<>(menuItemList);//리스트 수정 막기 위해 복사해서 리턴
    }

    public List<String> getCategoryName() {
        return categoryName;
    }

}

