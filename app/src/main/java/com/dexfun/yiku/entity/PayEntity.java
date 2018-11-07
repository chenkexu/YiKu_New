package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Smile on 17/12/14.
 */

public class PayEntity extends DefaultEntity {
    /**
     * data : {"aliPay":"","appid":"wxb4188a08e56b21a0","noncestr":"1157281759","package":"Sign=WXPay","partnerid":"1437430302","prepayid":"wx20171214115729c31af6662a0332788094","sign":"4A8B72145669876EFB58902FFDB5499D","timestamp":"1513223848"}
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
        public String getAlipay() {
            return alipay;
        }

        public void setAlipay(String alipay) {
            this.alipay = alipay;
        }

        /**
         * aliPay :
         * appid : wxb4188a08e56b21a0
         * noncestr : 1157281759
         * package : Sign=WXPay
         * partnerid : 1437430302
         * prepayid : wx20171214115729c31af6662a0332788094
         * sign : 4A8B72145669876EFB58902FFDB5499D
         * timestamp : 1513223848
         */

        private String alipay;
        private String appid;
        private String noncestr;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String timestamp;



        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
