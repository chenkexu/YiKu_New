package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/1/2.
 */

public class DefaultAddressEntity extends DefaultEntity{

    /**
     * data : {"addressId":68,"consignee":"64646","contactNumber":"34661","region":"北京市-北京市-东城区","detailedAddress":"niming","defaultAddress":1}
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
         * addressId : 68
         * consignee : 64646
         * contactNumber : 34661
         * region : 北京市-北京市-东城区
         * detailedAddress : niming
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
}
