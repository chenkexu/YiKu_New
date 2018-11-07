package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/14.
 */

public class ProductListEntity {
    /**
     * clothingId : 1
     * clothingName : 测试上衣
     * clothingPrice : 99.99
     * clothingStyle : 1
     * clothingBrandId : 12
     * brandName : Chanel
     * clothingSortId : 1
     * clothingTypeId : 100031
     * clothingImgUrl : https://www.dexfun.com/img/logo200x200.png
     * clothingStockDTOS : [{"clothingId":1,"clothingStockType":"S","clothingStockNum":5,"clothingStockTotal":50},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":50}]
     */

    private int clothingId;
    private String clothingName;
    private double clothingPrice;
    private int clothingStyle;
    private int clothingBrandId;
    private String brandName;
    private int clothingSortId;
    private int clothingTypeId;
    private long clothingCreatedate;
    private Integer starSameStyle;

    public Integer getOccupySeat() {
        return occupySeat;
    }

    public void setOccupySeat(Integer occupySeat) {
        this.occupySeat = occupySeat;
    }

    private Integer occupySeat;

    public Integer getStarSameStyle() {
        return starSameStyle;
    }

    public void setStarSameStyle(Integer starSameStyle) {
        this.starSameStyle = starSameStyle;
    }



    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    private String adUrl;


    private String clothingImgUrl;
    private List<ClothingStockDTOSEntity> clothingStockDTOS;

    public int getClothingId() {
        return clothingId;
    }

    public void setClothingId(int clothingId) {
        this.clothingId = clothingId;
    }

    public String getClothingName() {
        return clothingName;
    }

    public void setClothingName(String clothingName) {
        this.clothingName = clothingName;
    }

    public double getClothingPrice() {
        return clothingPrice;
    }

    public void setClothingPrice(double clothingPrice) {
        this.clothingPrice = clothingPrice;
    }

    public int getClothingStyle() {
        return clothingStyle;
    }

    public void setClothingStyle(int clothingStyle) {
        this.clothingStyle = clothingStyle;
    }

    public int getClothingBrandId() {
        return clothingBrandId;
    }

    public void setClothingBrandId(int clothingBrandId) {
        this.clothingBrandId = clothingBrandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getClothingSortId() {
        return clothingSortId;
    }

    public void setClothingSortId(int clothingSortId) {
        this.clothingSortId = clothingSortId;
    }

    public int getClothingTypeId() {
        return clothingTypeId;
    }

    public void setClothingTypeId(int clothingTypeId) {
        this.clothingTypeId = clothingTypeId;
    }

    public String getClothingImgUrl() {
        return clothingImgUrl;
    }

    public void setClothingImgUrl(String clothingImgUrl) {
        this.clothingImgUrl = clothingImgUrl;
    }

    public List<ClothingStockDTOSEntity> getClothingStockDTOS() {
        return clothingStockDTOS;
    }

    public void setClothingStockDTOS(List<ClothingStockDTOSEntity> clothingStockDTOS) {
        this.clothingStockDTOS = clothingStockDTOS;
    }

    public long getClothingCreatedate() {
        return clothingCreatedate;
    }

    public void setClothingCreatedate(long clothingCreatedate) {
        this.clothingCreatedate = clothingCreatedate;
    }

    public static class ClothingStockDTOSEntity {
        /**
         * clothingId : 1
         * clothingStockType : S
         * clothingStockNum : 5
         * clothingStockTotal : 50
         */

        private int clothingId;
        private String clothingStockType;
        private int clothingStockNum;
        private int clothingStockTotal;

        public int getClothingId() {
            return clothingId;
        }

        public void setClothingId(int clothingId) {
            this.clothingId = clothingId;
        }

        public String getClothingStockType() {
            return clothingStockType;
        }

        public void setClothingStockType(String clothingStockType) {
            this.clothingStockType = clothingStockType;
        }

        public int getClothingStockNum() {
            return clothingStockNum;
        }

        public void setClothingStockNum(int clothingStockNum) {
            this.clothingStockNum = clothingStockNum;
        }

        public int getClothingStockTotal() {
            return clothingStockTotal;
        }

        public void setClothingStockTotal(int clothingStockTotal) {
            this.clothingStockTotal = clothingStockTotal;
        }
    }
}