package com.dexfun.yiku.utils;

import com.dexfun.yiku.entity.DefaultEntity;

/**
 * Created by Smile on 18/10/10.
 */

public class CKENTITY extends DefaultEntity {
    /**
     * msg : null
     * data : {"cardNum":"","surplusNumber":0}
     * success : true
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * cardNum :
         * surplusNumber : 0
         */

        private String cardNum;
        private int surplusNumber;

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public int getSurplusNumber() {
            return surplusNumber;
        }

        public void setSurplusNumber(int surplusNumber) {
            this.surplusNumber = surplusNumber;
        }
    }
}
