package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public enum KioskKey {
    MAIN("MAIN",new ArrayList<>(),0),
    ITEMS("ITEMS",new ArrayList<>(),0),
    PAY("PAY",new ArrayList<>(),0),
    SAVE("SAVE",new ArrayList<>(),0);

    private String keyName;
    private  List<?> itemList;
    private Integer insertNumRange;

    private KioskKey(String keyName, List<?> itemList, Integer insertNumRange ) {
        this.keyName = keyName;
        this.itemList = itemList;
        this.insertNumRange = insertNumRange;
    }

    public void setItemList(List<?> itemList) {
        this.itemList = itemList;
    }
}
