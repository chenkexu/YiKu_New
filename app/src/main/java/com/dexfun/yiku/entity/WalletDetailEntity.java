package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/28.
 */

public class WalletDetailEntity {
    /**
     * data : [{"classification":3,"transactionType":1,"paymentMethod":1,"transactionNumber":"2017122021001004540205403251","transactionAmount":0.02,"tradingTime":1513737364000},{"classification":2,"transactionType":1,"paymentMethod":1,"transactionNumber":"2017122021001004540205239046","transactionAmount":0.01,"tradingTime":1513737374000},{"classification":2,"transactionType":1,"paymentMethod":1,"transactionNumber":"2017122021001004540205869741","transactionAmount":0.01,"tradingTime":1513737704000}]
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
         * classification : 3
         * transactionType : 1
         * paymentMethod : 1
         * transactionNumber : 2017122021001004540205403251
         * transactionAmount : 0.02
         * tradingTime : 1513737364000
         */

        private int classification;
        private int transactionType;
        private int paymentMethod;
        private String transactionNumber;
        private double transactionAmount;
        private long tradingTime;

        public int getClassification() {
            return classification;
        }

        public void setClassification(int classification) {
            this.classification = classification;
        }

        public int getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(int transactionType) {
            this.transactionType = transactionType;
        }

        public int getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(int paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getTransactionNumber() {
            return transactionNumber;
        }

        public void setTransactionNumber(String transactionNumber) {
            this.transactionNumber = transactionNumber;
        }

        public double getTransactionAmount() {
            return transactionAmount;
        }

        public void setTransactionAmount(double transactionAmount) {
            this.transactionAmount = transactionAmount;
        }

        public long getTradingTime() {
            return tradingTime;
        }

        public void setTradingTime(long tradingTime) {
            this.tradingTime = tradingTime;
        }
    }
}
