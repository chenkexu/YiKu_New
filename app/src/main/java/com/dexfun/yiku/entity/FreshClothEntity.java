package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/1/12.
 */

public class FreshClothEntity extends DefaultEntity {
    public List<ProductListEntity> getData() {
        return data;
    }

    public void setData(List<ProductListEntity> data) {
        this.data = data;
    }

    private List<ProductListEntity> data;
}
