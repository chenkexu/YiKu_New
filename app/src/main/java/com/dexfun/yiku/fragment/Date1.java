package com.dexfun.yiku.fragment;

import java.util.List;

public class Date1 {
    private String title;
    private List<String> content;

    public Date1(String title, List<String> content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
