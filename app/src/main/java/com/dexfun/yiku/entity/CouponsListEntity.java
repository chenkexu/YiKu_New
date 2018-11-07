package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/7/19.
 */

public class CouponsListEntity extends DefaultEntity {

    /**
     * msg : null
     * data : [{"couponName":"","couponDays":1,"couponType":1,"expiryTime":1532102399000,"couponStatus":3,"startTime":1530748800000,"couponId":390,"couponDescribe":""},{"couponName":"1","couponDays":5,"couponType":1,"expiryTime":1533052799000,"couponStatus":1,"startTime":1530403200000,"couponId":494,"couponDescribe":"2"},{"couponName":"1","couponAmount":150,"couponType":2,"expiryTime":1533052799000,"couponStatus":1,"startTime":1530403200000,"couponId":495,"couponDescribe":"2"},{"couponName":"1","couponAmount":500,"couponType":2,"expiryTime":1533052799000,"couponStatus":1,"startTime":1530403200000,"couponId":496,"couponDescribe":"2"},{"couponName":"1","couponAmount":5,"couponType":2,"expiryTime":1533052799000,"couponStatus":1,"startTime":1530403200000,"couponId":497,"couponDescribe":"2"}]
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
         * couponName :
         * couponDays : 1
         * couponType : 1
         * expiryTime : 1532102399000
         * couponStatus : 3
         * startTime : 1530748800000
         * couponId : 390
         * couponDescribe :
         * couponAmount : 150
         */

        private String couponName;
        private int couponDays;
        private int couponType;
        private long expiryTime;
        private int couponStatus;
        private long startTime;
        private int couponId;
        private String couponDescribe;
        private int couponAmount;

        public String getCouponName() {
            return couponName;
        }

        public void setCouponName(String couponName) {
            this.couponName = couponName;
        }

        public int getCouponDays() {
            return couponDays;
        }

        public void setCouponDays(int couponDays) {
            this.couponDays = couponDays;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public long getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(long expiryTime) {
            this.expiryTime = expiryTime;
        }

        public int getCouponStatus() {
            return couponStatus;
        }

        public void setCouponStatus(int couponStatus) {
            this.couponStatus = couponStatus;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public String getCouponDescribe() {
            return couponDescribe;
        }

        public void setCouponDescribe(String couponDescribe) {
            this.couponDescribe = couponDescribe;
        }

        public int getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(int couponAmount) {
            this.couponAmount = couponAmount;
        }
    }
}
