package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/8/13.
 */

public class AccountPEntity extends DefaultEntity {
    /**
     * msg : null
     * data : {"capital":0,"type":1}
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
         * capital : 0
         * type : 1
         */

        private int capital;
        private int type;

        public int getCapital() {
            return capital;
        }

        public void setCapital(int capital) {
            this.capital = capital;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
