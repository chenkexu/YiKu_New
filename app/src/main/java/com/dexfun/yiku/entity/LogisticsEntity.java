package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/1/4.
 */

public class LogisticsEntity extends DefaultEntity {
    /**
     * data : {"head":{"transType":4501,"transMessageId":"201801041814417584","code":"EX_CODE_OPENAPI_0200","message":"操作成功"},"body":[{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 14:57:08","acceptAddress":"北京海淀七街营业点","opcode":"8000","remark":"在官网\"运单资料&签收图\",可查看签收人信息","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 14:56:28","acceptAddress":"北京海淀七街营业点","opcode":"80","remark":"已签收,感谢使用顺丰,期待再次为您服务","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:52:34","acceptAddress":"北京海淀七街营业点","opcode":"204","remark":"快件交给徐少华，正在派送途中（联系电话：13810624535）","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:22:48","acceptAddress":"北京海淀七街营业点","opcode":"44","remark":"正在派送途中,请您准备签收(派件人:刘永彬,电话:0)","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:20:59","acceptAddress":"北京海淀七街营业点","opcode":"31","remark":"快件到达 【北京海淀七街营业点】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 09:45:34","acceptAddress":"北京顺义集散中心","opcode":"30","remark":"快件在【北京顺义集散中心】装车，已发往 【北京海淀七街营业点】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 05:23:13","acceptAddress":"北京顺义集散中心","opcode":"31","remark":"快件到达 【北京顺义集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 22:22:38","acceptAddress":"深圳总集散中心","opcode":"30","remark":"快件在【深圳总集散中心】装车，已发往下一站","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 22:22:38","acceptAddress":"深圳总集散中心","opcode":"31","remark":"快件到达 【深圳总集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 20:29:46","acceptAddress":"东莞大朗集散中心","opcode":"30","remark":"快件在【东莞大朗集散中心】装车，已发往 【深圳总集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 19:53:09","acceptAddress":"东莞大朗集散中心","opcode":"31","remark":"快件到达 【东莞大朗集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 18:02:55","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"30","remark":"快件在【东莞桥头正丰豪苑营业部】装车，已发往下一站","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 16:58:55","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"50","remark":"顺丰速运 已收取快件","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 16:55:00","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"54","remark":"顺丰速运 已收取快件","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null}]}
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
         * head : {"transType":4501,"transMessageId":"201801041814417584","code":"EX_CODE_OPENAPI_0200","message":"操作成功"}
         * body : [{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 14:57:08","acceptAddress":"北京海淀七街营业点","opcode":"8000","remark":"在官网\"运单资料&签收图\",可查看签收人信息","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 14:56:28","acceptAddress":"北京海淀七街营业点","opcode":"80","remark":"已签收,感谢使用顺丰,期待再次为您服务","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:52:34","acceptAddress":"北京海淀七街营业点","opcode":"204","remark":"快件交给徐少华，正在派送途中（联系电话：13810624535）","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:22:48","acceptAddress":"北京海淀七街营业点","opcode":"44","remark":"正在派送途中,请您准备签收(派件人:刘永彬,电话:0)","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 11:20:59","acceptAddress":"北京海淀七街营业点","opcode":"31","remark":"快件到达 【北京海淀七街营业点】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 09:45:34","acceptAddress":"北京顺义集散中心","opcode":"30","remark":"快件在【北京顺义集散中心】装车，已发往 【北京海淀七街营业点】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-21 05:23:13","acceptAddress":"北京顺义集散中心","opcode":"31","remark":"快件到达 【北京顺义集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 22:22:38","acceptAddress":"深圳总集散中心","opcode":"30","remark":"快件在【深圳总集散中心】装车，已发往下一站","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 22:22:38","acceptAddress":"深圳总集散中心","opcode":"31","remark":"快件到达 【深圳总集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 20:29:46","acceptAddress":"东莞大朗集散中心","opcode":"30","remark":"快件在【东莞大朗集散中心】装车，已发往 【深圳总集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 19:53:09","acceptAddress":"东莞大朗集散中心","opcode":"31","remark":"快件到达 【东莞大朗集散中心】","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 18:02:55","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"30","remark":"快件在【东莞桥头正丰豪苑营业部】装车，已发往下一站","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 16:58:55","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"50","remark":"顺丰速运 已收取快件","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null},{"orderId":null,"mailNo":"238836512256","acceptTime":"2017-12-20 16:55:00","acceptAddress":"东莞桥头正丰豪苑营业部","opcode":"54","remark":"顺丰速运 已收取快件","productCode":null,"productName":null,"consignorContName":null,"addresseeCompName":null}]
         */

        private HeadEntity head;
        private List<BodyEntity> body;

        public HeadEntity getHead() {
            return head;
        }

        public void setHead(HeadEntity head) {
            this.head = head;
        }

        public List<BodyEntity> getBody() {
            return body;
        }

        public void setBody(List<BodyEntity> body) {
            this.body = body;
        }

        public static class HeadEntity {
            /**
             * transType : 4501
             * transMessageId : 201801041814417584
             * code : EX_CODE_OPENAPI_0200
             * message : 操作成功
             */

            private int transType;
            private String transMessageId;
            private String code;
            private String message;

            public int getTransType() {
                return transType;
            }

            public void setTransType(int transType) {
                this.transType = transType;
            }

            public String getTransMessageId() {
                return transMessageId;
            }

            public void setTransMessageId(String transMessageId) {
                this.transMessageId = transMessageId;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        public static class BodyEntity {
            /**
             * orderId : null
             * mailNo : 238836512256
             * acceptTime : 2017-12-21 14:57:08
             * acceptAddress : 北京海淀七街营业点
             * opcode : 8000
             * remark : 在官网"运单资料&签收图",可查看签收人信息
             * productCode : null
             * productName : null
             * consignorContName : null
             * addresseeCompName : null
             */

            private Object orderId;
            private String mailNo;
            private String acceptTime;
            private String acceptAddress;
            private String opcode;
            private String remark;
            private Object productCode;
            private Object productName;
            private Object consignorContName;
            private Object addresseeCompName;

            public Object getOrderId() {
                return orderId;
            }

            public void setOrderId(Object orderId) {
                this.orderId = orderId;
            }

            public String getMailNo() {
                return mailNo;
            }

            public void setMailNo(String mailNo) {
                this.mailNo = mailNo;
            }

            public String getAcceptTime() {
                return acceptTime;
            }

            public void setAcceptTime(String acceptTime) {
                this.acceptTime = acceptTime;
            }

            public String getAcceptAddress() {
                return acceptAddress;
            }

            public void setAcceptAddress(String acceptAddress) {
                this.acceptAddress = acceptAddress;
            }

            public String getOpcode() {
                return opcode;
            }

            public void setOpcode(String opcode) {
                this.opcode = opcode;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public Object getProductCode() {
                return productCode;
            }

            public void setProductCode(Object productCode) {
                this.productCode = productCode;
            }

            public Object getProductName() {
                return productName;
            }

            public void setProductName(Object productName) {
                this.productName = productName;
            }

            public Object getConsignorContName() {
                return consignorContName;
            }

            public void setConsignorContName(Object consignorContName) {
                this.consignorContName = consignorContName;
            }

            public Object getAddresseeCompName() {
                return addresseeCompName;
            }

            public void setAddresseeCompName(Object addresseeCompName) {
                this.addresseeCompName = addresseeCompName;
            }
        }
    }
}
