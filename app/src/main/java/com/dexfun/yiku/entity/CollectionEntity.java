package com.dexfun.yiku.entity;

import java.util.List;

public class CollectionEntity extends DefaultEntity {
    /**
     * data : [{"collectionId":"1051736138687057920","clothingId":1485,"clothingStockId":4004,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/秋冬波点上衣/clothingImg0","clothingName":"秋冬波点上衣","clothingBrandName":"E-COOL","clothingPrice":425,"stockType":"均码","stockNumber":1,"classify":1,"occupySeat":1}]
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
         * collectionId : 1051736138687057920
         * clothingId : 1485
         * clothingStockId : 4004
         * clothingImgUrl : http://img-cdn.xykoo.cn/clothing/秋冬波点上衣/clothingImg0
         * clothingName : 秋冬波点上衣
         * clothingBrandName : E-COOL
         * clothingPrice : 425
         * stockType : 均码
         * stockNumber : 1
         * classify : 1
         * occupySeat : 1
         */

        private String collectionId;
        private int clothingId;
        private int clothingStockId;
        private String clothingImgUrl;
        private String clothingName;
        private String clothingBrandName;
        private int clothingPrice;
        private String stockType;
        private int stockNumber;
        private int classify;
        private int occupySeat;

        public String getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(String collectionId) {
            this.collectionId = collectionId;
        }

        public int getClothingId() {
            return clothingId;
        }

        public void setClothingId(int clothingId) {
            this.clothingId = clothingId;
        }

        public int getClothingStockId() {
            return clothingStockId;
        }

        public void setClothingStockId(int clothingStockId) {
            this.clothingStockId = clothingStockId;
        }

        public String getClothingImgUrl() {
            return clothingImgUrl;
        }

        public void setClothingImgUrl(String clothingImgUrl) {
            this.clothingImgUrl = clothingImgUrl;
        }

        public String getClothingName() {
            return clothingName;
        }

        public void setClothingName(String clothingName) {
            this.clothingName = clothingName;
        }

        public String getClothingBrandName() {
            return clothingBrandName;
        }

        public void setClothingBrandName(String clothingBrandName) {
            this.clothingBrandName = clothingBrandName;
        }

        public int getClothingPrice() {
            return clothingPrice;
        }

        public void setClothingPrice(int clothingPrice) {
            this.clothingPrice = clothingPrice;
        }

        public String getStockType() {
            return stockType;
        }

        public void setStockType(String stockType) {
            this.stockType = stockType;
        }

        public int getStockNumber() {
            return stockNumber;
        }

        public void setStockNumber(int stockNumber) {
            this.stockNumber = stockNumber;
        }

        public int getClassify() {
            return classify;
        }

        public void setClassify(int classify) {
            this.classify = classify;
        }

        public int getOccupySeat() {
            return occupySeat;
        }

        public void setOccupySeat(int occupySeat) {
            this.occupySeat = occupySeat;
        }
    }
}
