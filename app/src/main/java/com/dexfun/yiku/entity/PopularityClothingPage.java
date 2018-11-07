package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/9/5.
 */

public class PopularityClothingPage extends DefaultEntity {
    /**
     * data : {"number":1,"totalPages":4,"content":[{"clothingId":824,"clothingNo":"3040028","clothingName":"翻领学院风两件套","clothingExplain":"学院风格的小翻领独立白色上衣加背带裤，可谓是少女心满满了，而这两件也可以单独搭配，成为你的衣橱里的无限可能","adUrl":null,"clothingPrice":1023,"clothingStyle":0,"clothingBrandId":126,"brandName":"Moschino","clothingSortId":1,"clothingTypeId":100062,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/翻领学院风两件套/clothingImg0","clothingStockDTOS":[{"clothingId":824,"clothingStockId":3020,"clothingStockType":"均码","clothingStockNum":0,"clothingStockTotal":6}],"clothingStyleVOS":[{"styleId":30,"styleName":"休闲","styleImage":"http://img-cdn.xykoo.cn/休闲/18534"},{"styleId":32,"styleName":"度假","styleImage":"http://img-cdn.xykoo.cn/度假/11649"},{"styleId":34,"styleName":"学院","styleImage":"http://img-cdn.xykoo.cn/学院/75653"}],"clothingStatus":1,"clothingCreatedate":1536127639000,"leaseNumber":47,"starSameStyle":1},{"clothingId":1119,"clothingNo":"3020066","clothingName":"三色几何撞色半裙","clothingExplain":"通勤半裙，很有气质的一款，优雅又充满魅力，几何撞色，为这件半裙增加了更多的独特性，建议搭配雪纺面料的上衣","adUrl":null,"clothingPrice":1230,"clothingStyle":1,"clothingBrandId":117,"brandName":"GUESS","clothingSortId":1,"clothingTypeId":100060,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/三色几何撞色半裙/clothingImg0","clothingStockDTOS":[{"clothingId":1119,"clothingStockId":3404,"clothingStockType":"S","clothingStockNum":2,"clothingStockTotal":3},{"clothingId":1119,"clothingStockId":3405,"clothingStockType":"M","clothingStockNum":2,"clothingStockTotal":3}],"clothingStyleVOS":[{"styleId":30,"styleName":"休闲","styleImage":"http://img-cdn.xykoo.cn/休闲/18534"},{"styleId":31,"styleName":"通勤","styleImage":"http://img-cdn.xykoo.cn/通勤/19747"},{"styleId":32,"styleName":"度假","styleImage":"http://img-cdn.xykoo.cn/度假/11649"}],"clothingStatus":1,"clothingCreatedate":1535712834000,"leaseNumber":3,"starSameStyle":null}]}
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
         * number : 1
         * totalPages : 4
         * content : [{"clothingId":824,"clothingNo":"3040028","clothingName":"翻领学院风两件套","clothingExplain":"学院风格的小翻领独立白色上衣加背带裤，可谓是少女心满满了，而这两件也可以单独搭配，成为你的衣橱里的无限可能","adUrl":null,"clothingPrice":1023,"clothingStyle":0,"clothingBrandId":126,"brandName":"Moschino","clothingSortId":1,"clothingTypeId":100062,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/翻领学院风两件套/clothingImg0","clothingStockDTOS":[{"clothingId":824,"clothingStockId":3020,"clothingStockType":"均码","clothingStockNum":0,"clothingStockTotal":6}],"clothingStyleVOS":[{"styleId":30,"styleName":"休闲","styleImage":"http://img-cdn.xykoo.cn/休闲/18534"},{"styleId":32,"styleName":"度假","styleImage":"http://img-cdn.xykoo.cn/度假/11649"},{"styleId":34,"styleName":"学院","styleImage":"http://img-cdn.xykoo.cn/学院/75653"}],"clothingStatus":1,"clothingCreatedate":1536127639000,"leaseNumber":47,"starSameStyle":1},{"clothingId":1119,"clothingNo":"3020066","clothingName":"三色几何撞色半裙","clothingExplain":"通勤半裙，很有气质的一款，优雅又充满魅力，几何撞色，为这件半裙增加了更多的独特性，建议搭配雪纺面料的上衣","adUrl":null,"clothingPrice":1230,"clothingStyle":1,"clothingBrandId":117,"brandName":"GUESS","clothingSortId":1,"clothingTypeId":100060,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/三色几何撞色半裙/clothingImg0","clothingStockDTOS":[{"clothingId":1119,"clothingStockId":3404,"clothingStockType":"S","clothingStockNum":2,"clothingStockTotal":3},{"clothingId":1119,"clothingStockId":3405,"clothingStockType":"M","clothingStockNum":2,"clothingStockTotal":3}],"clothingStyleVOS":[{"styleId":30,"styleName":"休闲","styleImage":"http://img-cdn.xykoo.cn/休闲/18534"},{"styleId":31,"styleName":"通勤","styleImage":"http://img-cdn.xykoo.cn/通勤/19747"},{"styleId":32,"styleName":"度假","styleImage":"http://img-cdn.xykoo.cn/度假/11649"}],"clothingStatus":1,"clothingCreatedate":1535712834000,"leaseNumber":3,"starSameStyle":null}]
         */

        private int number;
        private int totalPages;
        private List<ContentEntity> content;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity {
            /**
             * clothingId : 824
             * clothingNo : 3040028
             * clothingName : 翻领学院风两件套
             * clothingExplain : 学院风格的小翻领独立白色上衣加背带裤，可谓是少女心满满了，而这两件也可以单独搭配，成为你的衣橱里的无限可能
             * adUrl : null
             * clothingPrice : 1023
             * clothingStyle : 0
             * clothingBrandId : 126
             * brandName : Moschino
             * clothingSortId : 1
             * clothingTypeId : 100062
             * clothingImgUrl : http://img-cdn.xykoo.cn/clothing/翻领学院风两件套/clothingImg0
             * clothingStockDTOS : [{"clothingId":824,"clothingStockId":3020,"clothingStockType":"均码","clothingStockNum":0,"clothingStockTotal":6}]
             * clothingStyleVOS : [{"styleId":30,"styleName":"休闲","styleImage":"http://img-cdn.xykoo.cn/休闲/18534"},{"styleId":32,"styleName":"度假","styleImage":"http://img-cdn.xykoo.cn/度假/11649"},{"styleId":34,"styleName":"学院","styleImage":"http://img-cdn.xykoo.cn/学院/75653"}]
             * clothingStatus : 1
             * clothingCreatedate : 1536127639000
             * leaseNumber : 47
             * starSameStyle : 1
             */

            private int clothingId;
            private String clothingNo;
            private String clothingName;
            private String clothingExplain;
            private Object adUrl;
            private int clothingPrice;
            private int clothingStyle;
            private int clothingBrandId;
            private String brandName;
            private int clothingSortId;
            private int clothingTypeId;
            private String clothingImgUrl;
            private int clothingStatus;
            private long clothingCreatedate;
            private int leaseNumber;
            private int starSameStyle;
            private List<ClothingStockDTOSEntity> clothingStockDTOS;
            private List<ClothingStyleVOSEntity> clothingStyleVOS;

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

            public int getLeaseNumber() {
                return leaseNumber;
            }

            public void setLeaseNumber(int leaseNumber) {
                this.leaseNumber = leaseNumber;
            }

            public int getStarSameStyle() {
                return starSameStyle;
            }

            public void setStarSameStyle(int starSameStyle) {
                this.starSameStyle = starSameStyle;
            }

            public List<ClothingStockDTOSEntity> getClothingStockDTOS() {
                return clothingStockDTOS;
            }

            public void setClothingStockDTOS(List<ClothingStockDTOSEntity> clothingStockDTOS) {
                this.clothingStockDTOS = clothingStockDTOS;
            }

            public List<ClothingStyleVOSEntity> getClothingStyleVOS() {
                return clothingStyleVOS;
            }

            public void setClothingStyleVOS(List<ClothingStyleVOSEntity> clothingStyleVOS) {
                this.clothingStyleVOS = clothingStyleVOS;
            }

            public static class ClothingStockDTOSEntity {
                /**
                 * clothingId : 824
                 * clothingStockId : 3020
                 * clothingStockType : 均码
                 * clothingStockNum : 0
                 * clothingStockTotal : 6
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

            public static class ClothingStyleVOSEntity {
                /**
                 * styleId : 30
                 * styleName : 休闲
                 * styleImage : http://img-cdn.xykoo.cn/休闲/18534
                 */

                private int styleId;
                private String styleName;
                private String styleImage;

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
            }
        }
    }
}
