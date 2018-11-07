package com.dexfun.yiku.entity;

/**
 * Created by Smile on 17/12/27.
 */

public class WalletEntity extends DefaultEntity {
    /**
     * data : {"cardNum":"会员编号","effective":1,"validity":"77","depositEffective":3,"cardType":0}
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
         * cardNum : 会员编号
         * effective : 1
         * validity : 77
         * depositEffective : 3
         * cardType : 0
         */

        private String cardNum;
        private int effective;
        private String validity;
        private int depositEffective;
        private int cardType;

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public int getEffective() {
            return effective;
        }

        public void setEffective(int effective) {
            this.effective = effective;
        }

        public String getValidity() {
            return validity;
        }

        public void setValidity(String validity) {
            this.validity = validity;
        }

        public int getDepositEffective() {
            return depositEffective;
        }

        public void setDepositEffective(int depositEffective) {
            this.depositEffective = depositEffective;
        }

        public int getCardType() {
            return cardType;
        }

        public void setCardType(int cardType) {
            this.cardType = cardType;
        }
    }
}
