package com.jz.fx.streaming.service.core.pojo;

/**
 * Created by Jack on 12/11/2017.
 */
public class Price {

    public String getCcyName() {
        return ccyName;
    }

    public void setCcyName(String ccyName) {
        this.ccyName = ccyName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    private String ccyName;

    private String bid;

    private String ask;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    @Override
    public String toString(){
        return "Ccy: " + ccyName + " bid " + bid + " ask " + ask;
    }
}
