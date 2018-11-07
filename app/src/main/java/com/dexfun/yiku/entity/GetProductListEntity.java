package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 17/12/15.
 */

public class GetProductListEntity extends DefaultEntity {

    public List<ProductListEntity> getProductListEntity() {
        return brandListEntityList;
    }

    public void setProductListEntity(List<ProductListEntity> productListEntity) {
        this.brandListEntityList = productListEntity;
    }

    @SerializedName("data")
    private List<ProductListEntity> brandListEntityList;
}
