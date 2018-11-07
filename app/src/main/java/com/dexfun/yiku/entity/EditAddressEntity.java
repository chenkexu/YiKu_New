package com.dexfun.yiku.entity;

/**
 * Created by Up on 2017/12/28.
 */

public class EditAddressEntity {

    /**
     * status : 200
     * msg : 修改成功
     * data : {"addressId":104,"consignee":"staaaing","contactNumber":"string","region":"string","detailedAddress":"string","defaultAddress":0}
     * success : true
     */

    private int status;
    private String msg;
    private DataBean data;
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * addressId : 104
         * consignee : staaaing
         * contactNumber : string
         * region : string
         * detailedAddress : string
         * defaultAddress : 0
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
}
