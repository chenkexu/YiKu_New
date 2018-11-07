package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Smile on 18/4/11.
 */

public class StartEntity extends DefaultEntity {
    /**
     * data : {"imgUrl":"http://ssss.jpg","jumpUrl":"http://ssss.jpg","showTime":3,"status":1}
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
         * imgUrl : http://ssss.jpg
         * jumpUrl : http://ssss.jpg
         * showTime : 3
         * status : 1
         */

        private String imgUrl;
        private String jumpUrl;
        private int showTime;
        @SerializedName("status")
        private int statusX;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getShowTime() {
            return showTime;
        }

        public void setShowTime(int showTime) {
            this.showTime = showTime;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }
    }
}
