package com.example.kiosk6;

public enum Payment {
    ARMY(5,"군인"),
    NMPERSON(10,"국가유공자"),
    STUDENT(3,"학생"),
    CITIZEN(1,"일반");

    private Payment(Integer sale, String krName ){
        this.sale = sale;
        this.krName = krName;
    }

    private Integer sale;
    private String krName;
    //할인 적용 된 가격으로 계산
    public  int getFinalPrice(int price){
        return price-price/100*sale;
    }
}
