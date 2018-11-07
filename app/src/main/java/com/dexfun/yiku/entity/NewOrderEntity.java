package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/9/19.
 */

public class NewOrderEntity extends DefaultEntity {
    /**
     * data : {"orderNo":"201809191537344668876","createDate":1537344668876,"clothingList":[{"clothingName":"INS韩版棉麻料连衣裙","clothingModel":"均码","clothingPrice":672}],"addressVo":{"consignee":"测试号","contactNumber":"13716129866","region":"北京市-北京市-海淀区","detailedAddress":"创业中路36号 (请勿发货 测试单)"}}
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
         * orderNo : 201809191537344668876
         * createDate : 1537344668876
         * clothingList : [{"clothingName":"INS韩版棉麻料连衣裙","clothingModel":"均码","clothingPrice":672}]
         * addressVo : {"consignee":"测试号","contactNumber":"13716129866","region":"北京市-北京市-海淀区","detailedAddress":"创业中路36号 (请勿发货 测试单)"}
         */

        private String orderNo;
        private long createDate;
        private AddressVoEntity addressVo;
        private List<ClothingListEntity> clothingList;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public AddressVoEntity getAddressVo() {
            return addressVo;
        }

        public void setAddressVo(AddressVoEntity addressVo) {
            this.addressVo = addressVo;
        }

        public List<ClothingListEntity> getClothingList() {
            return clothingList;
        }

        public void setClothingList(List<ClothingListEntity> clothingList) {
            this.clothingList = clothingList;
        }

        public static class AddressVoEntity {
            /**
             * consignee : 测试号
             * contactNumber : 13716129866
             * region : 北京市-北京市-海淀区
             * detailedAddress : 创业中路36号 (请勿发货 测试单)
             */

            private String consignee;
            private String contactNumber;
            private String region;
            private String detailedAddress;

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
        }

        public static class ClothingListEntity {
            /**
             * clothingName : INS韩版棉麻料连衣裙
             * clothingModel : 均码
             * clothingPrice : 672
             */

            private String clothingName;
            private String clothingModel;
            private int clothingPrice;

            public String getClothingName() {
                return clothingName;
            }

            public void setClothingName(String clothingName) {
                this.clothingName = clothingName;
            }

            public String getClothingModel() {
                return clothingModel;
            }

            public void setClothingModel(String clothingModel) {
                this.clothingModel = clothingModel;
            }

            public int getClothingPrice() {
                return clothingPrice;
            }

            public void setClothingPrice(int clothingPrice) {
                this.clothingPrice = clothingPrice;
            }
        }
    }
}
