package com.example.kiosk7.kiosk6;

import java.util.ArrayList;
import java.util.List;

public enum KioskKey {
    MAIN("MAIN",new ArrayList<>(),0),
    ITEMS("ITEMS",new ArrayList<>(),0),
    PAY("PAY",new ArrayList<>(),0),
    SAVE("SAVE",new ArrayList<>(),0),
    END("END",new ArrayList<>(),0);

    private String keyName;
    private List<String> itemList;
    private Integer insertNumRange;

    private KioskKey(String keyName, List<String> itemList, Integer insertNumRange ) {
        this.keyName = keyName;
        this.itemList = itemList;
        this.insertNumRange = insertNumRange;
    }

    public Integer getInsertNumRange() {
        return insertNumRange;
    }

    public void setInsertNumRange(Integer insertNumRange) {
        this.insertNumRange = insertNumRange;
    }

    public String getKeyName() {
        return keyName;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }
}
