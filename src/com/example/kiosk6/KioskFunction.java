package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface KioskFunction {
    //장바구니 구현
    List<MenuItem> orderMenuList = new ArrayList<>();
    public void viewShoppingCartUI();//장바구니에 물건이 있으면 추가 UI 생성
    public void choiceMenuInsertToShoppingCart(Scanner scanner, MenuItem choiceMenuItem);//선택한 메뉴 장바구니에 추가할지 체크
    public void choiceMenuDeleteToShoppingCart(Scanner scanner);//선택한 메뉴 장바구니에서 삭제
    public void selectShoppingCart();//장바구니에 담아둔 메뉴 보여줌
    public void continuePaymentCheck(Scanner scanner);//결재를 계속 진행할건지 체크
    public void doPaymentShoppingCart(Scanner scanner,int totalPrice);//결재 진행하는 메소드
    //부가 기능
    public void setUserInsertValueSize();//사용자가 입력 할 수 있는 값 범위 지정
}