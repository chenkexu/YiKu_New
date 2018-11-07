package com.dexfun.yiku.fragment;

import java.util.List;

public class Date2 {
    private String text;
    private List<Integer> image;

    public Date2(String text, List<Integer> image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getImage() {
        return image;
    }

    public void setImage(List<Integer> image) {
        this.image = image;
    }
}
