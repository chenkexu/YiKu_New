package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/15.
 */

public class SelectClothEntity extends DefaultEntity {
    /**
     * data : {"sortList":[{"clothingSortId":1,"clothingSortName":"新品"},{"clothingSortId":2,"clothingSortName":"热门"},{"clothingSortId":3,"clothingSortName":"推荐"},{"clothingSortId":4,"clothingSortName":"默认"}],"brandList":[{"brandId":12,"brandName":"Chanel","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Supreme1994年秋季诞生于美国纽约曼哈顿，由James Jebbia创办。supreme的本意是最高、至上的。Supreme是结合滑板、Hip-hop等文化并以滑板为主的美国街头服饰品牌。","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":13,"brandName":"DHC","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"DHCdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":14,"brandName":"ENVOY","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"ENVOYdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":15,"brandName":"ELLE","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"ELLEdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":16,"brandName":"Evisu","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Evisudesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":17,"brandName":"EVGA","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"EVGAdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"}],"productList":{"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"total":3,"pages":1,"list":[{"clothingId":1,"clothingName":"测试上衣","clothingPrice":99.99,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100033,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":1,"clothingStockId":1,"clothingStockType":"S","clothingStockNum":3,"clothingStockTotal":50},{"clothingId":1,"clothingStockId":3,"clothingStockType":"L","clothingStockNum":0,"clothingStockTotal":50}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":2,"clothingTypeId":100032,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":2,"clothingStockId":2,"clothingStockType":"M","clothingStockNum":14,"clothingStockTotal":50},{"clothingId":2,"clothingStockId":4,"clothingStockType":"XL","clothingStockNum":11,"clothingStockTotal":50}]},{"clothingId":3,"clothingName":"外套","clothingPrice":88,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":2,"clothingTypeId":100031,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[]}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1},"secondLevelCategoryList":[{"catId":100033,"catName":"牛仔上衣"},{"catId":100034,"catName":"羽绒服"},{"catId":100035,"catName":"呢子大衣"},{"catId":100036,"catName":"牛仔裤"},{"catId":100037,"catName":"西裤"},{"catId":100038,"catName":"运动裤"}]}
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
         * sortList : [{"clothingSortId":1,"clothingSortName":"新品"},{"clothingSortId":2,"clothingSortName":"热门"},{"clothingSortId":3,"clothingSortName":"推荐"},{"clothingSortId":4,"clothingSortName":"默认"}]
         * brandList : [{"brandId":12,"brandName":"Chanel","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Supreme1994年秋季诞生于美国纽约曼哈顿，由James Jebbia创办。supreme的本意是最高、至上的。Supreme是结合滑板、Hip-hop等文化并以滑板为主的美国街头服饰品牌。","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":13,"brandName":"DHC","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"DHCdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":14,"brandName":"ENVOY","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"ENVOYdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":15,"brandName":"ELLE","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"ELLEdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":16,"brandName":"Evisu","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"Evisudesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"},{"brandId":17,"brandName":"EVGA","brandLogo":"https://www.dexfun.com/img/logo200x200.png","brandDesc":"EVGAdesc","brandImg":"https://www.dexfun.com/img/logo200x200.png"}]
         * productList : {"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"total":3,"pages":1,"list":[{"clothingId":1,"clothingName":"测试上衣","clothingPrice":99.99,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100033,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":1,"clothingStockId":1,"clothingStockType":"S","clothingStockNum":3,"clothingStockTotal":50},{"clothingId":1,"clothingStockId":3,"clothingStockType":"L","clothingStockNum":0,"clothingStockTotal":50}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":2,"clothingTypeId":100032,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":2,"clothingStockId":2,"clothingStockType":"M","clothingStockNum":14,"clothingStockTotal":50},{"clothingId":2,"clothingStockId":4,"clothingStockType":"XL","clothingStockNum":11,"clothingStockTotal":50}]},{"clothingId":3,"clothingName":"外套","clothingPrice":88,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":2,"clothingTypeId":100031,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[]}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         * secondLevelCategoryList : [{"catId":100033,"catName":"牛仔上衣"},{"catId":100034,"catName":"羽绒服"},{"catId":100035,"catName":"呢子大衣"},{"catId":100036,"catName":"牛仔裤"},{"catId":100037,"catName":"西裤"},{"catId":100038,"catName":"运动裤"}]
         */

        private ProductListEntityx productList;
        private List<SortListEntity> sortList;
        private List<BrandListEntity> brandList;
        private List<SecondLevelCategoryListEntity> secondLevelCategoryList;
        private List<ClothingStylesEntity> clothingStyles;

        public ProductListEntityx getProductList() {
            return productList;
        }

        public void setProductList(ProductListEntityx productList) {
            this.productList = productList;
        }

        public List<SortListEntity> getSortList() {
            return sortList;
        }

        public void setSortList(List<SortListEntity> sortList) {
            this.sortList = sortList;
        }

        public List<BrandListEntity> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListEntity> brandList) {
            this.brandList = brandList;
        }

        public List<SecondLevelCategoryListEntity> getSecondLevelCategoryList() {
            return secondLevelCategoryList;
        }

        public void setSecondLevelCategoryList(List<SecondLevelCategoryListEntity> secondLevelCategoryList) {
            this.secondLevelCategoryList = secondLevelCategoryList;
        }

        public List<ClothingStylesEntity> getClothingStyles() {
            return clothingStyles;
        }

        public void setClothingStyles(List<ClothingStylesEntity> clothingStyles) {
            this.clothingStyles = clothingStyles;
        }

        public static class ProductListEntityx {
            /**
             * pageNum : 1
             * pageSize : 3
             * size : 3
             * startRow : 0
             * endRow : 2
             * total : 3
             * pages : 1
             * list : [{"clothingId":1,"clothingName":"测试上衣","clothingPrice":99.99,"clothingStyle":1,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":1,"clothingTypeId":100033,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":1,"clothingStockId":1,"clothingStockType":"S","clothingStockNum":3,"clothingStockTotal":50},{"clothingId":1,"clothingStockId":3,"clothingStockType":"L","clothingStockNum":0,"clothingStockTotal":50}]},{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingStyle":2,"clothingBrandId":12,"brandName":"Chanel","clothingSortId":2,"clothingTypeId":100032,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[{"clothingId":2,"clothingStockId":2,"clothingStockType":"M","clothingStockNum":14,"clothingStockTotal":50},{"clothingId":2,"clothingStockId":4,"clothingStockType":"XL","clothingStockNum":11,"clothingStockTotal":50}]},{"clothingId":3,"clothingName":"外套","clothingPrice":88,"clothingStyle":1,"clothingBrandId":13,"brandName":"DHC","clothingSortId":2,"clothingTypeId":100031,"clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png","clothingStockDTOS":[]}]
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

            private List<ProductListEntity> list;
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

            public List<ProductListEntity> getList() {
                return list;
            }



            public void setList(List<ProductListEntity> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

        }

        public static class SortListEntity {
            /**
             * clothingSortId : 1
             * clothingSortName : 新品
             */

            private int clothingSortId;
            private String clothingSortName;

            public int getClothingSortId() {
                return clothingSortId;
            }

            public void setClothingSortId(int clothingSortId) {
                this.clothingSortId = clothingSortId;
            }

            public String getClothingSortName() {
                return clothingSortName;
            }

            public void setClothingSortName(String clothingSortName) {
                this.clothingSortName = clothingSortName;
            }
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

        public static class ClothingStylesEntity {
            /**
             * styleId : 3
             * styleName : 风格3
             * styleImage : http://img-cdn.xykoo.cn/风格3/55859
             * styleSort : 3
             * createDate : 1528879620000
             * updateDate : 1528879621000
             * operator : 6
             */

            private boolean color;
            private int styleId;
            private String styleName;
            private String styleImage;
            private int styleSort;
            private long createDate;
            private long updateDate;
            private int operator;

            public boolean isColor() {
                return color;
            }

            public void setColor(boolean color) {
                this.color = color;
            }

            public int getStyleId() {
                return styleId;
            }

            public void setStyleId(int styleId) {
                this.styleId = styleId;
            }

            public String getStyleName() {
                return styleName;
            }

            public void setStyleName(String styleName) {
                this.styleName = styleName;
            }

            public String getStyleImage() {
                return styleImage;
            }

            public void setStyleImage(String styleImage) {
                this.styleImage = styleImage;
            }

            public int getStyleSort() {
                return styleSort;
            }

            public void setStyleSort(int styleSort) {
                this.styleSort = styleSort;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public int getOperator() {
                return operator;
            }

            public void setOperator(int operator) {
                this.operator = operator;
            }
        }
    }
}
