package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/6.
 */

public class HomeEntity extends DefaultEntity {

    /**
     * msg : null
     * data : {"brandList":[{"brandId":12,"brandName":"Chanel","brandLogo":"Chanellogo","brandDesc":"Chaneldesc","brandImg":"Chanelimg"},{"brandId":13,"brandName":"DHC","brandLogo":"DHClogo","brandDesc":"DHCdesc","brandImg":"DHCimg"},{"brandId":14,"brandName":"ENVOY","brandLogo":"ENVOYlogo","brandDesc":"ENVOYdesc","brandImg":"ENVOYimg"},{"brandId":15,"brandName":"ELLE","brandLogo":"ELLElogo","brandDesc":"ELLEdesc","brandImg":"ELLEimg"},{"brandId":16,"brandName":"Evisu","brandLogo":"Evisulogo","brandDesc":"Evisudesc","brandImg":"Evisuimg"},{"brandId":17,"brandName":"EVGA","brandLogo":"EVGAlogo","brandDesc":"EVGAdesc","brandImg":"EVGAimg"}],"productList":{"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"total":3,"pages":1,"list":[{"clothingId":1,"clothingName":"测试上衣","clothingPrice":null,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":1,"clothingStockType":"S","clothingStockNum":0,"clothingStockTotal":2},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":4}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":0,"clothingStockTotal":10},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":2,"clothingStockTotal":5}]},{"clothingId":3,"clothingName":"外套","clothingPrice":null,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":0,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[]}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1},"imgList":[{"homeImgId":1,"homeImgUrl":"urlurlurlurlurlurlurlurl"},{"homeImgId":3,"homeImgUrl":"这是地址"}]}
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
         * brandList : [{"brandId":12,"brandName":"Chanel","brandLogo":"Chanellogo","brandDesc":"Chaneldesc","brandImg":"Chanelimg"},{"brandId":13,"brandName":"DHC","brandLogo":"DHClogo","brandDesc":"DHCdesc","brandImg":"DHCimg"},{"brandId":14,"brandName":"ENVOY","brandLogo":"ENVOYlogo","brandDesc":"ENVOYdesc","brandImg":"ENVOYimg"},{"brandId":15,"brandName":"ELLE","brandLogo":"ELLElogo","brandDesc":"ELLEdesc","brandImg":"ELLEimg"},{"brandId":16,"brandName":"Evisu","brandLogo":"Evisulogo","brandDesc":"Evisudesc","brandImg":"Evisuimg"},{"brandId":17,"brandName":"EVGA","brandLogo":"EVGAlogo","brandDesc":"EVGAdesc","brandImg":"EVGAimg"}]
         * productList : {"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"total":3,"pages":1,"list":[{"clothingId":1,"clothingName":"测试上衣","clothingPrice":null,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":1,"clothingStockType":"S","clothingStockNum":0,"clothingStockTotal":2},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":4}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":0,"clothingStockTotal":10},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":2,"clothingStockTotal":5}]},{"clothingId":3,"clothingName":"外套","clothingPrice":null,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":0,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[]}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         * imgList : [{"homeImgId":1,"homeImgUrl":"urlurlurlurlurlurlurlurl"},{"homeImgId":3,"homeImgUrl":"这是地址"}]
         */

        private ProductListEntity productList;
        private List<BrandListEntity> brandList;
        private List<ImgListEntity> loopPic;
        private List<SpecialsEntity> thematicActivities;
        /**
         * weekNewProduct : {"newProductId":2,"productImg":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4050523606,2170310969&fm=27&gp=0.jpg","productUrl":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4050523606,2170310969&fm=27&gp=0.jpg"}
         * hotWears : [{"hotWearId":1,"hotWearImg":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2319581713,1459380543&fm=27&gp=0.jpg","hotWearUrl":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2319581713,1459380543&fm=27&gp=0.jpg"}]
         */

        private WeekNewProductEntity weekNewProduct;
        private List<HotWearsEntity> hotWears;

        public List<SpecialsEntity> getThematicActivities() {
            return thematicActivities;
        }

        public void setThematicActivities(List<SpecialsEntity> thematicActivities) {
            this.thematicActivities = thematicActivities;
        }

        public ProductListEntity getProductList() {
            return productList;
        }

        public void setProductList(ProductListEntity productList) {
            this.productList = productList;
        }

        public List<BrandListEntity> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListEntity> brandList) {
            this.brandList = brandList;
        }

        public List<ImgListEntity> getLoopPic() {
            return loopPic;
        }

        public void setLoopPic(List<ImgListEntity> loopPic) {
            this.loopPic = loopPic;
        }

        public WeekNewProductEntity getWeekNewProduct() {
            return weekNewProduct;
        }

        public void setWeekNewProduct(WeekNewProductEntity weekNewProduct) {
            this.weekNewProduct = weekNewProduct;
        }

        public List<HotWearsEntity> getHotWears() {
            return hotWears;
        }

        public void setHotWears(List<HotWearsEntity> hotWears) {
            this.hotWears = hotWears;
        }

        public static class ProductListEntity {
            /**
             * pageNum : 1
             * pageSize : 3
             * size : 3
             * startRow : 0
             * endRow : 2
             * total : 3
             * pages : 1
             * list : [{"clothingId":1,"clothingName":"测试上衣","clothingPrice":null,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":1,"clothingStockType":"S","clothingStockNum":0,"clothingStockTotal":2},{"clothingId":1,"clothingStockType":"L","clothingStockNum":2,"clothingStockTotal":4}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":null,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":0,"clothingTypeId":100032,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[{"clothingId":2,"clothingStockType":"M","clothingStockNum":0,"clothingStockTotal":10},{"clothingId":2,"clothingStockType":"XL","clothingStockNum":2,"clothingStockTotal":5}]},{"clothingId":3,"clothingName":"外套","clothingPrice":null,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":0,"clothingTypeId":100031,"clothingImgUrl":"/image/logo.jsp","clothingStockDTOS":[]}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int firstPage;
            private int lastPage;
            private List<com.dexfun.yiku.entity.ProductListEntity> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<com.dexfun.yiku.entity.ProductListEntity> getList() {
                return list;
            }

            public void setList(List<com.dexfun.yiku.entity.ProductListEntity> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }


        }
        public static class SpecialsEntity {
            /**
             * specialId : 1
             * specialName : 测试
             * specialImg : http://img3.imgtn.bdimg.com/it/u=478492314,2348383413&fm=27&gp=0.jpg
             * specialLink : http://img3.imgtn.bdimg.com/it/u=478492314,2348383413&fm=27&gp=0.jpg
             * specialSequence : 1
             */

            private int specialId;
            private String specialName;
            private String specialImg;
            private String specialLink;
            private String specialSequence;

            public int getSpecialId() {
                return specialId;
            }

            public void setSpecialId(int specialId) {
                this.specialId = specialId;
            }

            public String getSpecialName() {
                return specialName;
            }

            public void setSpecialName(String specialName) {
                this.specialName = specialName;
            }

            public String getSpecialImg() {
                return specialImg;
            }

            public void setSpecialImg(String specialImg) {
                this.specialImg = specialImg;
            }

            public String getSpecialLink() {
                return specialLink;
            }

            public void setSpecialLink(String specialLink) {
                this.specialLink = specialLink;
            }

            public String getSpecialSequence() {
                return specialSequence;
            }

            public void setSpecialSequence(String specialSequence) {
                this.specialSequence = specialSequence;
            }
        }

        public static class ImgListEntity {
            /**
             * homeImgId : 1
             * homeImgUrl : urlurlurlurlurlurlurlurl
             */

            private int homeImgId;
            private String homeImgUrl;

            public String getHomeLinkUrl() {
                return homeLinkUrl;
            }

            public void setHomeLinkUrl(String homeLinkUrl) {
                this.homeLinkUrl = homeLinkUrl;
            }

            private String homeLinkUrl;

            public int getHomeImgId() {
                return homeImgId;
            }

            public void setHomeImgId(int homeImgId) {
                this.homeImgId = homeImgId;
            }

            public String getHomeImgUrl() {
                return homeImgUrl;
            }

            public void setHomeImgUrl(String homeImgUrl) {
                this.homeImgUrl = homeImgUrl;
            }
        }

        public static class WeekNewProductEntity {
            /**
             * newProductId : 2
             * productImg : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4050523606,2170310969&fm=27&gp=0.jpg
             * productUrl : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4050523606,2170310969&fm=27&gp=0.jpg
             */

            private int newProductId;
            private String productImg;
            private String productUrl;

            public int getNewProductId() {
                return newProductId;
            }

            public void setNewProductId(int newProductId) {
                this.newProductId = newProductId;
            }

            public String getProductImg() {
                return productImg;
            }

            public void setProductImg(String productImg) {
                this.productImg = productImg;
            }

            public String getProductUrl() {
                return productUrl;
            }

            public void setProductUrl(String productUrl) {
                this.productUrl = productUrl;
            }
        }

        public static class HotWearsEntity {
            /**
             * hotWearId : 1
             * hotWearImg : https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2319581713,1459380543&fm=27&gp=0.jpg
             * hotWearUrl : https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2319581713,1459380543&fm=27&gp=0.jpg
             */

            private int hotWearId;
            private String hotWearImg;
            private String hotWearUrl;

            public int getHotWearId() {
                return hotWearId;
            }

            public void setHotWearId(int hotWearId) {
                this.hotWearId = hotWearId;
            }

            public String getHotWearImg() {
                return hotWearImg;
            }

            public void setHotWearImg(String hotWearImg) {
                this.hotWearImg = hotWearImg;
            }

            public String getHotWearUrl() {
                return hotWearUrl;
            }

            public void setHotWearUrl(String hotWearUrl) {
                this.hotWearUrl = hotWearUrl;
            }
        }
    }


}
