package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/7.
 */

public class DetailEntity extends DefaultEntity {
    /**
     * msg : null
     * data : {"clothingDetail":{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":null,"clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":19,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":20,"clothingStockTotal":50}]},"clothingDetailImg":[{"clothingImgId":6,"clothingImgUrl":"/image/detail.jsp","clothingImgExplain":"这是服装详情图","clothingImgType":2,"clothingId":2}],"brandDetail":{"brandId":12,"brandName":"Chanel","brandLogo":"Chanellogo","brandDesc":"Chaneldesc","brandImg":"Chanelimg"},"clothingBannerImg":[{"clothingImgId":5,"clothingImgUrl":"/image/banner.jsp","clothingImgExplain":"这是服装轮播图","clothingImgType":1,"clothingId":2}],"productList":[{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":19,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":20,"clothingStockTotal":50}]}]}
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
         * clothingDetail : {"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":null,"clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":19,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":20,"clothingStockTotal":50}]}
         * clothingDetailImg : [{"clothingImgId":6,"clothingImgUrl":"/image/detail.jsp","clothingImgExplain":"这是服装详情图","clothingImgType":2,"clothingId":2}]
         * brandDetail : {"brandId":12,"brandName":"Chanel","brandLogo":"Chanellogo","brandDesc":"Chaneldesc","brandImg":"Chanelimg"}
         * clothingBannerImg : [{"clothingImgId":5,"clothingImgUrl":"/image/banner.jsp","clothingImgExplain":"这是服装轮播图","clothingImgType":1,"clothingId":2}]
         * productList : [{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":19,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":20,"clothingStockTotal":50}]}]
         */
        private Integer isInCollectionFolder;
        private Integer occupiedClothes;
        private ClothingDetailEntity clothingDetail;
        private BrandListEntity brandDetail;
        private List<ClothingDetailImgEntity> clothingDetailImg;
        private List<ClothingBannerImgEntity> clothingBannerImg;
        private List<ProductListEntity> productList;
        private List<SizeTableVosEntity> sizeTableVos;

        public Integer getIsInCollectionFolder() {
            return isInCollectionFolder;
        }

        public void setIsInCollectionFolder(Integer isInCollectionFolder) {
            this.isInCollectionFolder = isInCollectionFolder;
        }

        public Integer getOccupiedClothes() {
            return occupiedClothes;
        }

        public void setOccupiedClothes(Integer occupiedClothes) {
            this.occupiedClothes = occupiedClothes;
        }

        public List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> getArticle() {
            return article;
        }

        public void setArticle(List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> article) {
            this.article = article;
        }

        private List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> article;
        /**
         * userSizeTable : {"userSizeTableId":null,"userId":null,"bust":null,"theWaist":null,"hipline":null,"shoulderWidth":null,"createDate":null}
         */

        private UserSizeTableEntity userSizeTable;

        public List<SizeTableVosEntity> getSizeTableVos() {
            return sizeTableVos;
        }

        public void setSizeTableVos(List<SizeTableVosEntity> sizeTableVos) {
            this.sizeTableVos = sizeTableVos;
        }

        public UserSizeTableEntity getUserSizeTable() {
            return userSizeTable;
        }

        public void setUserSizeTable(UserSizeTableEntity userSizeTable) {
            this.userSizeTable = userSizeTable;
        }

        public static class SizeTableVosEntity {
            /**
             * clothingId : 153
             * type : 1
             * model : M
             * trousersLength : 11
             * waistline : 11
             * hipline : 11
             * chestWidth : 11
             * clothesLength : 11
             * shoulderWidth : 11
             * sleeveLength : 11
             * skirtLength : 1
             */

            private int clothingId;
            private int type;
            private String model;
            private String trousersLength;
            private String waistline;
            private String hipline;
            private String chestWidth;
            private String clothesLength;
            private String shoulderWidth;
            private String sleeveLength;
            private String skirtLength;

            public int getClothingId() {
                return clothingId;
            }

            public void setClothingId(int clothingId) {
                this.clothingId = clothingId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getTrousersLength() {
                return trousersLength;
            }

            public void setTrousersLength(String trousersLength) {
                this.trousersLength = trousersLength;
            }

            public String getWaistline() {
                return waistline;
            }

            public void setWaistline(String waistline) {
                this.waistline = waistline;
            }

            public String getHipline() {
                return hipline;
            }

            public void setHipline(String hipline) {
                this.hipline = hipline;
            }

            public String getChestWidth() {
                return chestWidth;
            }

            public void setChestWidth(String chestWidth) {
                this.chestWidth = chestWidth;
            }

            public String getClothesLength() {
                return clothesLength;
            }

            public void setClothesLength(String clothesLength) {
                this.clothesLength = clothesLength;
            }

            public String getShoulderWidth() {
                return shoulderWidth;
            }

            public void setShoulderWidth(String shoulderWidth) {
                this.shoulderWidth = shoulderWidth;
            }

            public String getSleeveLength() {
                return sleeveLength;
            }

            public void setSleeveLength(String sleeveLength) {
                this.sleeveLength = sleeveLength;
            }

            public String getSkirtLength() {
                return skirtLength;
            }

            public void setSkirtLength(String skirtLength) {
                this.skirtLength = skirtLength;
            }
        }

        public ClothingDetailEntity getClothingDetail() {
            return clothingDetail;
        }

        public void setClothingDetail(ClothingDetailEntity clothingDetail) {
            this.clothingDetail = clothingDetail;
        }

        public BrandListEntity getBrandDetail() {
            return brandDetail;
        }

        public void setBrandDetail(BrandListEntity brandDetail) {
            this.brandDetail = brandDetail;
        }

        public List<ClothingDetailImgEntity> getClothingDetailImg() {
            return clothingDetailImg;
        }

        public void setClothingDetailImg(List<ClothingDetailImgEntity> clothingDetailImg) {
            this.clothingDetailImg = clothingDetailImg;
        }

        public List<ClothingBannerImgEntity> getClothingBannerImg() {
            return clothingBannerImg;
        }

        public void setClothingBannerImg(List<ClothingBannerImgEntity> clothingBannerImg) {
            this.clothingBannerImg = clothingBannerImg;
        }

        public List<ProductListEntity> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListEntity> productList) {
            this.productList = productList;
        }

        public static class ClothingDetailEntity {
            /**
             * clothingId : 2
             * clothingName : 测试裤子
             * clothingPrice : null
             * clothingStyle : 2
             * clothingBrandId : 12
             * brandName : Chanel
             * clothingSortId : 0
             * clothingTypeId : 100032
             * clothingImgUrl : null
             * clothingStockDTOS : [{"clothingId":2,"clothingStockType":"M","clothingStockNum":19,"clothingStockTotal":50},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":20,"clothingStockTotal":50}]
             */
            public Integer getOccupySeat() {
                return occupySeat;
            }

            public void setOccupySeat(Integer occupySeat) {
                this.occupySeat = occupySeat;
            }

            private Integer occupySeat;
            private int clothingId;
            private String clothingName;
            private double clothingPrice;
            private int clothingStyle;
            private int clothingBrandId;
            private String brandName;
            private int clothingSortId;
            private int clothingTypeId;
            private String clothingImgUrl;

            public String getClothingExplain() {
                return clothingExplain;
            }

            public void setClothingExplain(String clothingExplain) {
                this.clothingExplain = clothingExplain;
            }

            private String clothingExplain;
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

            public static class ClothingStockDTOSEntity {
                /**
                 * clothingId : 2
                 * clothingStockType : M
                 * clothingStockNum : 19
                 * clothingStockTotal : 50
                 */

                private int clothingId;
                private int clothingStockId;
                private String clothingStockType;
                private int clothingStockNum;
                private int clothingStockTotal;

                public int getClothingStockId() {
                    return clothingStockId;
                }

                public void setClothingStockId(int clothingStockId) {
                    this.clothingStockId = clothingStockId;
                }

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


        public static class ClothingDetailImgEntity {
            /**
             * clothingImgId : 6
             * clothingImgUrl : /image/detail.jsp
             * clothingImgExplain : 这是服装详情图
             * clothingImgType : 2
             * clothingId : 2
             */

            private int clothingImgId;
            private String clothingImgUrl;
            private String clothingImgExplain;
            private int clothingImgType;
            private int clothingId;

            public int getClothingImgId() {
                return clothingImgId;
            }

            public void setClothingImgId(int clothingImgId) {
                this.clothingImgId = clothingImgId;
            }

            public String getClothingImgUrl() {
                return clothingImgUrl;
            }

            public void setClothingImgUrl(String clothingImgUrl) {
                this.clothingImgUrl = clothingImgUrl;
            }

            public String getClothingImgExplain() {
                return clothingImgExplain;
            }

            public void setClothingImgExplain(String clothingImgExplain) {
                this.clothingImgExplain = clothingImgExplain;
            }

            public int getClothingImgType() {
                return clothingImgType;
            }

            public void setClothingImgType(int clothingImgType) {
                this.clothingImgType = clothingImgType;
            }

            public int getClothingId() {
                return clothingId;
            }

            public void setClothingId(int clothingId) {
                this.clothingId = clothingId;
            }
        }

        public static class ClothingBannerImgEntity {
            /**
             * clothingImgId : 5
             * clothingImgUrl : /image/banner.jsp
             * clothingImgExplain : 这是服装轮播图
             * clothingImgType : 1
             * clothingId : 2
             */

            private int clothingImgId;
            private String clothingImgUrl;
            private String clothingImgExplain;
            private int clothingImgType;
            private int clothingId;

            public int getClothingImgId() {
                return clothingImgId;
            }

            public void setClothingImgId(int clothingImgId) {
                this.clothingImgId = clothingImgId;
            }

            public String getClothingImgUrl() {
                return clothingImgUrl;
            }

            public void setClothingImgUrl(String clothingImgUrl) {
                this.clothingImgUrl = clothingImgUrl;
            }

            public String getClothingImgExplain() {
                return clothingImgExplain;
            }

            public void setClothingImgExplain(String clothingImgExplain) {
                this.clothingImgExplain = clothingImgExplain;
            }

            public int getClothingImgType() {
                return clothingImgType;
            }

            public void setClothingImgType(int clothingImgType) {
                this.clothingImgType = clothingImgType;
            }

            public int getClothingId() {
                return clothingId;
            }

            public void setClothingId(int clothingId) {
                this.clothingId = clothingId;
            }
        }


        public static class UserSizeTableEntity {
            /**
             * userSizeTableId : null
             * userId : null
             * bust : null
             * theWaist : null
             * hipline : null
             * shoulderWidth : null
             * createDate : null
             */

            private Integer userSizeTableId;

            public Integer getUserSizeTableId() {
                return userSizeTableId;
            }

            public void setUserSizeTableId(Integer userSizeTableId) {
                this.userSizeTableId = userSizeTableId;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getBust() {
                return bust;
            }

            public void setBust(Integer bust) {
                this.bust = bust;
            }

            public Integer getTheWaist() {
                return theWaist;
            }

            public void setTheWaist(Integer theWaist) {
                this.theWaist = theWaist;
            }

            public Integer getHipline() {
                return hipline;
            }

            public void setHipline(Integer hipline) {
                this.hipline = hipline;
            }

            public Integer getShoulderWidth() {
                return shoulderWidth;
            }

            public void setShoulderWidth(Integer shoulderWidth) {
                this.shoulderWidth = shoulderWidth;
            }

            public Long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Long createDate) {
                this.createDate = createDate;
            }

            private Integer userId;
            private Integer bust;
            private Integer theWaist;
            private Integer hipline;
            private Integer shoulderWidth;
            private Long createDate;

        }
    }
}
