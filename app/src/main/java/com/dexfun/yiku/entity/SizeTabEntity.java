package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/5/22.
 */

public class SizeTabEntity extends DefaultEntity {
    /**
     * data : {"userSizeTableId":2,"userId":270,"bust":0,"theWaist":0,"hipline":0,"shoulderWidth":0,"createDate":1526972843000}
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
         * userSizeTableId : 2
         * userId : 270
         * bust : 0
         * theWaist : 0
         * hipline : 0
         * shoulderWidth : 0
         * createDate : 1526972843000
         */

        private int userSizeTableId;
        private int userId;
        private int bust;
        private int theWaist;
        private int hipline;
        private int shoulderWidth;
        private long createDate;

        public int getUserSizeTableId() {
            return userSizeTableId;
        }

        public void setUserSizeTableId(int userSizeTableId) {
            this.userSizeTableId = userSizeTableId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBust() {
            return bust;
        }

        public void setBust(int bust) {
            this.bust = bust;
        }

        public int getTheWaist() {
            return theWaist;
        }

        public void setTheWaist(int theWaist) {
            this.theWaist = theWaist;
        }

        public int getHipline() {
            return hipline;
        }

        public void setHipline(int hipline) {
            this.hipline = hipline;
        }

        public int getShoulderWidth() {
            return shoulderWidth;
        }

        public void setShoulderWidth(int shoulderWidth) {
            this.shoulderWidth = shoulderWidth;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }
    }
}
