package com.example.kiosk6;

public enum Payment {
    ARMY(5,"군인",(a,b)->a-a/100*b),
    NMPERSON(10,"국가유공자",(a,b)->a-a/100*b),
    STUDENT(3,"학생",(a,b)->a-a/100*b),
    CITIZEN(1,"일반",(a,b)->a-a/100*b);

    private Payment(Integer sale, String krName,SaleCalculation saleCalculation){
        this.saleCalculation = saleCalculation;
        this.sale = sale;
        this.krName = krName;
    }

    private SaleCalculation saleCalculation;
    private Integer sale;
    private String krName;

    public  int getFinalPrice(int price){
        return saleCalculation.doCalculation(price,this.sale);
    }
}
