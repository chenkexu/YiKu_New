package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/14.
 */

public class BrandEntity extends DefaultEntity {
    /**
     * data : {"brandDetail":{"brandId":12,"brandName":"Chanel","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Chaneldesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},"productList":[{"clothingId":1,"clothingName":"测试上衣","clothingPrice":99.99,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100031,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":1,"clothingStockType":"S","clothingStockNum":5,"clothingStockTotal":50},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":50}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":2,"clothingTypeId":100032,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":15,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":13,"clothingStockTotal":50}]}],"secondLevelCategoryList":[{"catId":100033,"catName":"牛仔上衣"},{"catId":100034,"catName":"羽绒服"},{"catId":100035,"catName":"呢子大衣"},{"catId":100036,"catName":"牛仔裤"},{"catId":100037,"catName":"西裤"},{"catId":100038,"catName":"运动裤"}]}
     * success : true
     */

    private DataEntity data;
    private boolean success;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity {
        /**
         * brandDetail : {"brandId":12,"brandName":"Chanel","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Chaneldesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"}
         * productList : [{"clothingId":1,"clothingName":"测试上衣","clothingPrice":99.99,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100031,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":1,"clothingStockType":"S","clothingStockNum":5,"clothingStockTotal":50},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":50}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":2,"clothingTypeId":100032,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":15,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":13,"clothingStockTotal":50}]}]
         * secondLevelCategoryList : [{"catId":100033,"catName":"牛仔上衣"},{"catId":100034,"catName":"羽绒服"},{"catId":100035,"catName":"呢子大衣"},{"catId":100036,"catName":"牛仔裤"},{"catId":100037,"catName":"西裤"},{"catId":100038,"catName":"运动裤"}]
         */

        private BrandListEntity brandDetail;
        private List<ProductListEntity> productList;
        private List<SecondLevelCategoryListEntity> secondLevelCategoryList;

        public BrandListEntity getBrandDetail() {
            return brandDetail;
        }

        public void setBrandDetail(BrandListEntity brandDetail) {
            this.brandDetail = brandDetail;
        }

        public List<ProductListEntity> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListEntity> productList) {
            this.productList = productList;
        }

        public List<SecondLevelCategoryListEntity> getSecondLevelCategoryList() {
            return secondLevelCategoryList;
        }

        public void setSecondLevelCategoryList(List<SecondLevelCategoryListEntity> secondLevelCategoryList) {
            this.secondLevelCategoryList = secondLevelCategoryList;
        }





        public static class SecondLevelCategoryListEntity {
            /**
             * catId : 100033
             * catName : 牛仔上衣
             */

            private int catId;
            private String catName;

            public int getCatId() {
                return catId;
            }

            public void setCatId(int catId) {
                this.catId = catId;
            }

            public String getCatName() {
                return catName;
            }

            public void setCatName(String catName) {
                this.catName = catName;
            }
        }
    }
}
