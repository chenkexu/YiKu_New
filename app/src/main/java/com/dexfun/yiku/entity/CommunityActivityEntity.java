package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/6/14.
 */

public class CommunityActivityEntity extends DefaultEntity {
    /**
     * data : {"activityId":1,"activityTitle":"标题","activityLabel":"标签","activityExplain":"活动说明","activityStatus":1,"mainDiagram":"http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg","exampleDiagram":"http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg","createDate":1528968323000,"updateDate":1528968327000,"operator":1}
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
         * activityId : 1
         * activityTitle : 标题
         * activityLabel : 标签
         * activityExplain : 活动说明
         * activityStatus : 1
         * mainDiagram : http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg
         * exampleDiagram : http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg
         * createDate : 1528968323000
         * updateDate : 1528968327000
         * operator : 1
         */

        private int activityId;
        private String activityTitle;
        private String activityLabel;
        private String activityExplain;
        private int activityStatus;
        private String mainDiagram;
        private String exampleDiagram;
        private long createDate;
        private long updateDate;
        private int operator;

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public String getActivityTitle() {
            return activityTitle;
        }

        public void setActivityTitle(String activityTitle) {
            this.activityTitle = activityTitle;
        }

        public String getActivityLabel() {
            return activityLabel;
        }

        public void setActivityLabel(String activityLabel) {
            this.activityLabel = activityLabel;
        }

        public String getActivityExplain() {
            return activityExplain;
        }

        public void setActivityExplain(String activityExplain) {
            this.activityExplain = activityExplain;
        }

        public int getActivityStatus() {
            return activityStatus;
        }

        public void setActivityStatus(int activityStatus) {
            this.activityStatus = activityStatus;
        }

        public String getMainDiagram() {
            return mainDiagram;
        }

        public void setMainDiagram(String mainDiagram) {
            this.mainDiagram = mainDiagram;
        }

        public String getExampleDiagram() {
            return exampleDiagram;
        }

        public void setExampleDiagram(String exampleDiagram) {
            this.exampleDiagram = exampleDiagram;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public int getOperator() {
            return operator;
        }

        public void setOperator(int operator) {
            this.operator = operator;
        }
    }
}
