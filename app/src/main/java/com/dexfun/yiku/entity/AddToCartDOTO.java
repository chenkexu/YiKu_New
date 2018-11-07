package com.dexfun.yiku.entity;

public class AddToCartDOTO {
    int clothingId;
    int stockId;

    public AddToCartDOTO(int clothingId, int stockId) {
        this.clothingId = clothingId;
        this.stockId = stockId;
    }

    public int getClothingId() {
        return clothingId;
    }

    public void setClothingId(int clothingId) {
        this.clothingId = clothingId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }
}
