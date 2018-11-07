package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/1/22.
 */

public class VersionEntity extends DefaultEntity {
    /**
     * data : {"id":2,"appName":"衣库","serverFirstVersion":"1.0.0","serverNewVersion":"1.0.0","serverFlag":null,"lastForce":null,"updateUrl":null,"appVersion":2,"upgradeInfo":null,"createTime":1516610182000,"updateTime":1516610151000}
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
         * id : 2
         * appName : 衣库
         * serverFirstVersion : 1.0.0
         * serverNewVersion : 1.0.0
         * serverFlag : null
         * lastForce : null
         * updateUrl : null
         * appVersion : 2
         * upgradeInfo : null
         * createTime : 1516610182000
         * updateTime : 1516610151000
         */

        private int id;
        private String appName;
        private String serverFirstVersion;
        private String serverNewVersion;
        private String serverFlag;
        private String lastForce;
        private String updateUrl;
        private int appVersion;
        private String upgradeInfo;
        private long createTime;
        private long updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getServerFirstVersion() {
            return serverFirstVersion;
        }

        public void setServerFirstVersion(String serverFirstVersion) {
            this.serverFirstVersion = serverFirstVersion;
        }

        public String getServerNewVersion() {
            return serverNewVersion;
        }

        public void setServerNewVersion(String serverNewVersion) {
            this.serverNewVersion = serverNewVersion;
        }

        public String getServerFlag() {
            return serverFlag;
        }

        public void setServerFlag(String serverFlag) {
            this.serverFlag = serverFlag;
        }

        public String getLastForce() {
            return lastForce;
        }

        public void setLastForce(String lastForce) {
            this.lastForce = lastForce;
        }

        public String getUpdateUrl() {
            return updateUrl;
        }

        public void setUpdateUrl(String updateUrl) {
            this.updateUrl = updateUrl;
        }

        public int getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(int appVersion) {
            this.appVersion = appVersion;
        }

        public String getUpgradeInfo() {
            return upgradeInfo;
        }

        public void setUpgradeInfo(String upgradeInfo) {
            this.upgradeInfo = upgradeInfo;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
