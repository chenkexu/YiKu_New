package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/9/11.
 */

public class QueryAddClothingVoucher extends DefaultEntity {
    /**
     * data : [{"addClothingId":12,"addNumber":1,"status":"未使用"},{"addClothingId":11,"addNumber":1,"status":"已使用"}]
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
         * addClothingId : 12
         * addNumber : 1
         * status : 未使用
         */

        private int addClothingId;
        private int addNumber;
        @SerializedName("status")
        private String statusX;

        public int getAddClothingId() {
            return addClothingId;
        }

        public void setAddClothingId(int addClothingId) {
            this.addClothingId = addClothingId;
        }

        public int getAddNumber() {
            return addNumber;
        }

        public void setAddNumber(int addNumber) {
            this.addNumber = addNumber;
        }

        public String getStatusX() {
            return statusX;
        }

        public void setStatusX(String statusX) {
            this.statusX = statusX;
        }
    }
}
