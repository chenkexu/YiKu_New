package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/6/13.
 */

public class AttentionListEntity extends DefaultEntity {

    public List<Integer> data;

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
