package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/7/24.
 */

public class BuyCardEntity {

    private String title;
    private String subTitle;
    private Integer price;
    private int rsd;

    public BuyCardEntity(String title, String subTitle, Integer price ,int rsd) {
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.rsd = rsd;
    }

    public int getRsd() {
        return rsd;
    }

    public void setRsd(int rsd) {
        this.rsd = rsd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
