package com.dexfun.yiku.entity;

import com.dexfun.layout.utils.L;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 17/12/14.
 */

public class BrandCategoryEntity extends DefaultEntity {

    public List<ProductListEntity> getProductListEntity() {
        return productListEntity;
    }

    public void setProductListEntity(List<ProductListEntity> productListEntity) {
        this.productListEntity = productListEntity;
    }

    @SerializedName("data")
    private List<ProductListEntity> productListEntity;
}
