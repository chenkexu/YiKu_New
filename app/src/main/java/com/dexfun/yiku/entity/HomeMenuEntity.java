package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/1/12.
 */

public class HomeMenuEntity {

    private String title;
    private int resId;


    public HomeMenuEntity(String title, int resId) {
        this.resId = resId;
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
