package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/6/13.
 */

public class OrnamentEntity extends DefaultEntity {
    /**
     * data : [{"clothingId":775,"clothingNo":"peishi0001","clothingName":"配饰","clothingExplain":"配饰","adUrl":null,"clothingPrice":999,"clothingStyle":null,"clothingBrandId":null,"brandName":"","clothingSortId":null,"clothingTypeId":0,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/穿插带高腰牛仔裤/detailsImg0","clothingStockDTOS":[{"clothingId":775,"clothingStockId":2956,"clothingStockType":"均码","clothingStockNum":3,"clothingStockTotal":3}],"clothingStyleVOS":[],"clothingStatus":1,"clothingCreatedate":1528801516000}]
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
         * clothingId : 775
         * clothingNo : peishi0001
         * clothingName : 配饰
         * clothingExplain : 配饰
         * adUrl : null
         * clothingPrice : 999
         * clothingStyle : null
         * clothingBrandId : null
         * brandName :
         * clothingSortId : null
         * clothingTypeId : 0
         * clothingImgUrl : http://img-cdn.xykoo.cn/clothing/穿插带高腰牛仔裤/detailsImg0
         * clothingStockDTOS : [{"clothingId":775,"clothingStockId":2956,"clothingStockType":"均码","clothingStockNum":3,"clothingStockTotal":3}]
         * clothingStyleVOS : []
         * clothingStatus : 1
         * clothingCreatedate : 1528801516000
         */

        private int clothingId;
        private String clothingNo;
        private String clothingName;
        private String clothingExplain;
        private Object adUrl;
        private int clothingPrice;
        private Object clothingStyle;
        private Object clothingBrandId;
        private String brandName;
        private Object clothingSortId;
        private int clothingTypeId;
        private String clothingImgUrl;
        private int clothingStatus;
        private long clothingCreatedate;
        private List<ClothingStockDTOSEntity> clothingStockDTOS;
        private List<?> clothingStyleVOS;

        public int getClothingId() {
            return clothingId;
        }

        public void setClothingId(int clothingId) {
            this.clothingId = clothingId;
        }

        public String getClothingNo() {
            return clothingNo;
        }

        public void setClothingNo(String clothingNo) {
            this.clothingNo = clothingNo;
        }

        public String getClothingName() {
            return clothingName;
        }

        public void setClothingName(String clothingName) {
            this.clothingName = clothingName;
        }

        public String getClothingExplain() {
            return clothingExplain;
        }

        public void setClothingExplain(String clothingExplain) {
            this.clothingExplain = clothingExplain;
        }

        public Object getAdUrl() {
            return adUrl;
        }

        public void setAdUrl(Object adUrl) {
            this.adUrl = adUrl;
        }

        public int getClothingPrice() {
            return clothingPrice;
        }

        public void setClothingPrice(int clothingPrice) {
            this.clothingPrice = clothingPrice;
        }

        public Object getClothingStyle() {
            return clothingStyle;
        }

        public void setClothingStyle(Object clothingStyle) {
            this.clothingStyle = clothingStyle;
        }

        public Object getClothingBrandId() {
            return clothingBrandId;
        }

        public void setClothingBrandId(Object clothingBrandId) {
            this.clothingBrandId = clothingBrandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Object getClothingSortId() {
            return clothingSortId;
        }

        public void setClothingSortId(Object clothingSortId) {
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

        public int getClothingStatus() {
            return clothingStatus;
        }

        public void setClothingStatus(int clothingStatus) {
            this.clothingStatus = clothingStatus;
        }

        public long getClothingCreatedate() {
            return clothingCreatedate;
        }

        public void setClothingCreatedate(long clothingCreatedate) {
            this.clothingCreatedate = clothingCreatedate;
        }

        public List<ClothingStockDTOSEntity> getClothingStockDTOS() {
            return clothingStockDTOS;
        }

        public void setClothingStockDTOS(List<ClothingStockDTOSEntity> clothingStockDTOS) {
            this.clothingStockDTOS = clothingStockDTOS;
        }

        public List<?> getClothingStyleVOS() {
            return clothingStyleVOS;
        }

        public void setClothingStyleVOS(List<?> clothingStyleVOS) {
            this.clothingStyleVOS = clothingStyleVOS;
        }

        public static class ClothingStockDTOSEntity {
            /**
             * clothingId : 775
             * clothingStockId : 2956
             * clothingStockType : 均码
             * clothingStockNum : 3
             * clothingStockTotal : 3
             */

            private int clothingId;
            private int clothingStockId;
            private String clothingStockType;
            private int clothingStockNum;
            private int clothingStockTotal;

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
}
