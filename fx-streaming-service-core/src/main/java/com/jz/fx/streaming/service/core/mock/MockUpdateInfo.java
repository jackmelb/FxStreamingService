package com.jz.fx.streaming.service.core.mock;

import com.jz.fx.streaming.service.core.pojo.Price;
import com.lightstreamer.ls_client.UpdateInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 17/11/2017.
 */
public class MockUpdateInfo implements UpdateInfo {

    private Price price;

    private List<String> newValue = new ArrayList<>();

    public MockUpdateInfo (Price price){
        newValue.add(price.getCcyName());
        newValue.add(price.getBid());
        newValue.add(price.getAsk());
    }


    public int getItemPos() {
        return 0;
    }

    public String getItemName() {
        return null;
    }

    public boolean isValueChanged(int i) {
        return false;
    }

    public boolean isValueChanged(String s) {
        return false;
    }

    public String getNewValue(int i) {
        return newValue.get(i);
    }

    public String getNewValue(String s) {
        return null;
    }

    public String getOldValue(int i) {
        return null;
    }

    public String getOldValue(String s) {
        return null;
    }

    public int getNumFields() {
        return 0;
    }

    public boolean isSnapshot() {
        return false;
    }
}
