package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/1/10.
 */

public class CardPriceEntity extends DefaultEntity {
    /**
     * msg : null
     * data : [{"priceId":1,"priceType":0,"price":0.01,"creationTime":1513048332000,"updateTime":1513066805000},{"priceId":2,"priceType":1,"price":0.01,"creationTime":1513048347000,"updateTime":1513066811000},{"priceId":3,"priceType":2,"price":0.01,"creationTime":1513048367000,"updateTime":1513066815000},{"priceId":4,"priceType":3,"price":0.01,"creationTime":1513048380000,"updateTime":1513066819000}]
     * success : true
     */


    private boolean success;
    private List<DataEntity> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * priceId : 1
         * priceType : 0
         * price : 0.01
         * creationTime : 1513048332000
         * updateTime : 1513066805000
         */

        private int priceId;
        private int priceType;
        private int price;
        private long creationTime;
        private long updateTime;

        public int getPriceId() {
            return priceId;
        }

        public void setPriceId(int priceId) {
            this.priceId = priceId;
        }

        public int getPriceType() {
            return priceType;
        }

        public void setPriceType(int priceType) {
            this.priceType = priceType;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(long creationTime) {
            this.creationTime = creationTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
