package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/19.
 */

public class OrderEntity extends DefaultEntity {

    /**
     * data : [{"orderNo":"2017122068859","orderStatus":1,"sendTime":"","createTime":"2017-12-20","addressVo":{"addressId":65,"consignee":"隔壁小王","contactNumber":"15911180155","region":"北京市 海淀区","detailedAddress":"中关村创业大厦","defaultAddress":1},"orderDetailsVoList":[{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingBrandName":"Chanel","clothingStockType":"XL","clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png"}]}]
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
         * orderNo : 2017122068859
         * orderStatus : 1
         * sendTime :
         * createTime : 2017-12-20
         * addressVo : {"addressId":65,"consignee":"隔壁小王","contactNumber":"15911180155","region":"北京市 海淀区","detailedAddress":"中关村创业大厦","defaultAddress":1}
         * orderDetailsVoList : [{"clothingId":2,"clothingName":"测试裤子","clothingPrice":55.22,"clothingBrandName":"Chanel","clothingStockType":"XL","clothingImgUrl":"https://www.dexfun.com/img/logo200x200.png"}]
         */

        private int id;
        private String orderNo;
        private int orderStatus;
        private String sendTime;
        private String createTime;
        private AddressVoEntity addressVo;
        private List<OrderDetailsVoListEntity> orderDetailsVoList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public AddressVoEntity getAddressVo() {
            return addressVo;
        }

        public void setAddressVo(AddressVoEntity addressVo) {
            this.addressVo = addressVo;
        }

        public List<OrderDetailsVoListEntity> getOrderDetailsVoList() {
            return orderDetailsVoList;
        }

        public void setOrderDetailsVoList(List<OrderDetailsVoListEntity> orderDetailsVoList) {
            this.orderDetailsVoList = orderDetailsVoList;
        }

        public static class AddressVoEntity {
            /**
             * addressId : 65
             * consignee : 隔壁小王
             * contactNumber : 15911180155
             * region : 北京市 海淀区
             * detailedAddress : 中关村创业大厦
             * defaultAddress : 1
             */

            private int addressId;
            private String consignee;
            private String contactNumber;
            private String region;
            private String detailedAddress;
            private int defaultAddress;

            public int getAddressId() {
                return addressId;
            }

            public void setAddressId(int addressId) {
                this.addressId = addressId;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getContactNumber() {
                return contactNumber;
            }

            public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getDetailedAddress() {
                return detailedAddress;
            }

            public void setDetailedAddress(String detailedAddress) {
                this.detailedAddress = detailedAddress;
            }

            public int getDefaultAddress() {
                return defaultAddress;
            }

            public void setDefaultAddress(int defaultAddress) {
                this.defaultAddress = defaultAddress;
            }
        }

        public static class OrderDetailsVoListEntity {
            /**
             * clothingId : 2
             * clothingName : 测试裤子
             * clothingPrice : 55.22
             * clothingBrandName : Chanel
             * clothingStockType : XL
             * clothingImgUrl : https://www.dexfun.com/img/logo200x200.png
             */

            private int clothingId;
            private int classify;
            private String clothingName;
            private double clothingPrice;
            private String clothingBrandName;
            private String clothingStockType;
            private String clothingImgUrl;

            public int getClassify() {
                return classify;
            }

            public void setClassify(int classify) {
                this.classify = classify;
            }

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

            public String getClothingBrandName() {
                return clothingBrandName;
            }

            public void setClothingBrandName(String clothingBrandName) {
                this.clothingBrandName = clothingBrandName;
            }

            public String getClothingStockType() {
                return clothingStockType;
            }

            public void setClothingStockType(String clothingStockType) {
                this.clothingStockType = clothingStockType;
            }

            public String getClothingImgUrl() {
                return clothingImgUrl;
            }

            public void setClothingImgUrl(String clothingImgUrl) {
                this.clothingImgUrl = clothingImgUrl;
            }
        }
    }
}
