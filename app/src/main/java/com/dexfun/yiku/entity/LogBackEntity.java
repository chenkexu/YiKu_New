package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/6/1.
 */

public class LogBackEntity extends DefaultEntity {
    /**
     * data : {"data":[{"traces":[{"desc":"【郑州市】  【郑州鑫泰】（0371-55290615） 的 李坤 （13598328971） 已揽收","dispOrRecMan":"李坤","dispOrRecManCode":"","dispOrRecManPhone":"13598328971","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 14:50:16","scanProv":"河南","scanSite":"郑州鑫泰","scanSiteCode":"37101","scanSitePhone":"0371-55290615","scanType":"收件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州合盛】 发往 【潍坊中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊中转部","preOrNextSiteCode":"53600","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 22:38:19","scanProv":"河南","scanSite":"郑州合盛","scanSiteCode":"37188","scanSitePhone":"0371-55095311、0371-55895311","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件离开 【潍坊中转部】 发往 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊青州","preOrNextSiteCode":"53611","preOrNextSitePhone":"0536-3280087、0536-3298010、13563639876","remark":"","scanCity":"潍坊市","scanDate":"2018-05-31 21:10:00","scanProv":"山东","scanSite":"潍坊中转部","scanSiteCode":"53600","scanSitePhone":"","scanType":"发件","signMan":""},{"desc":"【郑州市】  快件到达 【郑州中转】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:39:19","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"到件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州中转】 发往 【温州中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"温州市","preOrNextProv":"浙江","preOrNextSite":"温州中转部","preOrNextSiteCode":"57700","preOrNextSitePhone":"0577-28614016","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:41:52","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件到达 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 06:55:13","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"到件","signMan":""},{"desc":"【潍坊市】  【潍坊青州】 的偶园石头（18953627650） 正在第1次派件, 请保持电话畅通,并耐心等待","dispOrRecMan":"偶园石头","dispOrRecManCode":"","dispOrRecManPhone":"18953627650","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:33:33","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"派件","signMan":""},{"desc":"【潍坊市】  快件已在 【潍坊青州】 签收,签收人: 本人, 感谢使用中通快递,期待再次为您服务!","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:45:02","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"签收","signMan":"本人"}],"billCode":"633186451144"}],"msg":"","status":true}
     * success : true
     */

    private DataEntityX data;
    private boolean success;

    public DataEntityX getData() {
        return data;
    }

    public void setData(DataEntityX data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntityX {
        /**
         * data : [{"traces":[{"desc":"【郑州市】  【郑州鑫泰】（0371-55290615） 的 李坤 （13598328971） 已揽收","dispOrRecMan":"李坤","dispOrRecManCode":"","dispOrRecManPhone":"13598328971","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 14:50:16","scanProv":"河南","scanSite":"郑州鑫泰","scanSiteCode":"37101","scanSitePhone":"0371-55290615","scanType":"收件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州合盛】 发往 【潍坊中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊中转部","preOrNextSiteCode":"53600","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 22:38:19","scanProv":"河南","scanSite":"郑州合盛","scanSiteCode":"37188","scanSitePhone":"0371-55095311、0371-55895311","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件离开 【潍坊中转部】 发往 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊青州","preOrNextSiteCode":"53611","preOrNextSitePhone":"0536-3280087、0536-3298010、13563639876","remark":"","scanCity":"潍坊市","scanDate":"2018-05-31 21:10:00","scanProv":"山东","scanSite":"潍坊中转部","scanSiteCode":"53600","scanSitePhone":"","scanType":"发件","signMan":""},{"desc":"【郑州市】  快件到达 【郑州中转】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:39:19","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"到件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州中转】 发往 【温州中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"温州市","preOrNextProv":"浙江","preOrNextSite":"温州中转部","preOrNextSiteCode":"57700","preOrNextSitePhone":"0577-28614016","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:41:52","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件到达 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 06:55:13","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"到件","signMan":""},{"desc":"【潍坊市】  【潍坊青州】 的偶园石头（18953627650） 正在第1次派件, 请保持电话畅通,并耐心等待","dispOrRecMan":"偶园石头","dispOrRecManCode":"","dispOrRecManPhone":"18953627650","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:33:33","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"派件","signMan":""},{"desc":"【潍坊市】  快件已在 【潍坊青州】 签收,签收人: 本人, 感谢使用中通快递,期待再次为您服务!","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:45:02","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"签收","signMan":"本人"}],"billCode":"633186451144"}]
         * msg :
         * status : true
         */

        @SerializedName("msg")
        private String msgX;
        @SerializedName("status")
        private boolean statusX;
        private List<DataEntity> data;

        public String getMsgX() {
            return msgX;
        }

        public void setMsgX(String msgX) {
            this.msgX = msgX;
        }

        public boolean isStatusX() {
            return statusX;
        }

        public void setStatusX(boolean statusX) {
            this.statusX = statusX;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public static class DataEntity {
            /**
             * traces : [{"desc":"【郑州市】  【郑州鑫泰】（0371-55290615） 的 李坤 （13598328971） 已揽收","dispOrRecMan":"李坤","dispOrRecManCode":"","dispOrRecManPhone":"13598328971","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 14:50:16","scanProv":"河南","scanSite":"郑州鑫泰","scanSiteCode":"37101","scanSitePhone":"0371-55290615","scanType":"收件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州合盛】 发往 【潍坊中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊中转部","preOrNextSiteCode":"53600","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-05-30 22:38:19","scanProv":"河南","scanSite":"郑州合盛","scanSiteCode":"37188","scanSitePhone":"0371-55095311、0371-55895311","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件离开 【潍坊中转部】 发往 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"潍坊市","preOrNextProv":"山东","preOrNextSite":"潍坊青州","preOrNextSiteCode":"53611","preOrNextSitePhone":"0536-3280087、0536-3298010、13563639876","remark":"","scanCity":"潍坊市","scanDate":"2018-05-31 21:10:00","scanProv":"山东","scanSite":"潍坊中转部","scanSiteCode":"53600","scanSitePhone":"","scanType":"发件","signMan":""},{"desc":"【郑州市】  快件到达 【郑州中转】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:39:19","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"到件","signMan":""},{"desc":"【郑州市】  快件离开 【郑州中转】 发往 【温州中转部】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"T","preOrNextCity":"温州市","preOrNextProv":"浙江","preOrNextSite":"温州中转部","preOrNextSiteCode":"57700","preOrNextSitePhone":"0577-28614016","remark":"","scanCity":"郑州市","scanDate":"2018-06-01 03:41:52","scanProv":"河南","scanSite":"郑州中转","scanSiteCode":"37100","scanSitePhone":"0371-63333286","scanType":"发件","signMan":""},{"desc":"【潍坊市】  快件到达 【潍坊青州】","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 06:55:13","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"到件","signMan":""},{"desc":"【潍坊市】  【潍坊青州】 的偶园石头（18953627650） 正在第1次派件, 请保持电话畅通,并耐心等待","dispOrRecMan":"偶园石头","dispOrRecManCode":"","dispOrRecManPhone":"18953627650","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:33:33","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"派件","signMan":""},{"desc":"【潍坊市】  快件已在 【潍坊青州】 签收,签收人: 本人, 感谢使用中通快递,期待再次为您服务!","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"潍坊市","scanDate":"2018-06-01 12:45:02","scanProv":"山东","scanSite":"潍坊青州","scanSiteCode":"53611","scanSitePhone":"0536-3280087、0536-3298010、13563639876","scanType":"签收","signMan":"本人"}]
             * billCode : 633186451144
             */

            private String billCode;
            private List<TracesEntity> traces;

            public String getBillCode() {
                return billCode;
            }

            public void setBillCode(String billCode) {
                this.billCode = billCode;
            }

            public List<TracesEntity> getTraces() {
                return traces;
            }

            public void setTraces(List<TracesEntity> traces) {
                this.traces = traces;
            }

            public static class TracesEntity {
                /**
                 * desc : 【郑州市】  【郑州鑫泰】（0371-55290615） 的 李坤 （13598328971） 已揽收
                 * dispOrRecMan : 李坤
                 * dispOrRecManCode :
                 * dispOrRecManPhone : 13598328971
                 * isCenter : F
                 * preOrNextCity :
                 * preOrNextProv :
                 * preOrNextSite :
                 * preOrNextSiteCode :
                 * preOrNextSitePhone :
                 * remark :
                 * scanCity : 郑州市
                 * scanDate : 2018-05-30 14:50:16
                 * scanProv : 河南
                 * scanSite : 郑州鑫泰
                 * scanSiteCode : 37101
                 * scanSitePhone : 0371-55290615
                 * scanType : 收件
                 * signMan :
                 */

                private String desc;
                private String dispOrRecMan;
                private String dispOrRecManCode;
                private String dispOrRecManPhone;
                private String isCenter;
                private String preOrNextCity;
                private String preOrNextProv;
                private String preOrNextSite;
                private String preOrNextSiteCode;
                private String preOrNextSitePhone;
                private String remark;
                private String scanCity;
                private String scanDate;
                private String scanProv;
                private String scanSite;
                private String scanSiteCode;
                private String scanSitePhone;
                private String scanType;
                private String signMan;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDispOrRecMan() {
                    return dispOrRecMan;
                }

                public void setDispOrRecMan(String dispOrRecMan) {
                    this.dispOrRecMan = dispOrRecMan;
                }

                public String getDispOrRecManCode() {
                    return dispOrRecManCode;
                }

                public void setDispOrRecManCode(String dispOrRecManCode) {
                    this.dispOrRecManCode = dispOrRecManCode;
                }

                public String getDispOrRecManPhone() {
                    return dispOrRecManPhone;
                }

                public void setDispOrRecManPhone(String dispOrRecManPhone) {
                    this.dispOrRecManPhone = dispOrRecManPhone;
                }

                public String getIsCenter() {
                    return isCenter;
                }

                public void setIsCenter(String isCenter) {
                    this.isCenter = isCenter;
                }

                public String getPreOrNextCity() {
                    return preOrNextCity;
                }

                public void setPreOrNextCity(String preOrNextCity) {
                    this.preOrNextCity = preOrNextCity;
                }

                public String getPreOrNextProv() {
                    return preOrNextProv;
                }

                public void setPreOrNextProv(String preOrNextProv) {
                    this.preOrNextProv = preOrNextProv;
                }

                public String getPreOrNextSite() {
                    return preOrNextSite;
                }

                public void setPreOrNextSite(String preOrNextSite) {
                    this.preOrNextSite = preOrNextSite;
                }

                public String getPreOrNextSiteCode() {
                    return preOrNextSiteCode;
                }

                public void setPreOrNextSiteCode(String preOrNextSiteCode) {
                    this.preOrNextSiteCode = preOrNextSiteCode;
                }

                public String getPreOrNextSitePhone() {
                    return preOrNextSitePhone;
                }

                public void setPreOrNextSitePhone(String preOrNextSitePhone) {
                    this.preOrNextSitePhone = preOrNextSitePhone;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getScanCity() {
                    return scanCity;
                }

                public void setScanCity(String scanCity) {
                    this.scanCity = scanCity;
                }

                public String getScanDate() {
                    return scanDate;
                }

                public void setScanDate(String scanDate) {
                    this.scanDate = scanDate;
                }

                public String getScanProv() {
                    return scanProv;
                }

                public void setScanProv(String scanProv) {
                    this.scanProv = scanProv;
                }

                public String getScanSite() {
                    return scanSite;
                }

                public void setScanSite(String scanSite) {
                    this.scanSite = scanSite;
                }

                public String getScanSiteCode() {
                    return scanSiteCode;
                }

                public void setScanSiteCode(String scanSiteCode) {
                    this.scanSiteCode = scanSiteCode;
                }

                public String getScanSitePhone() {
                    return scanSitePhone;
                }

                public void setScanSitePhone(String scanSitePhone) {
                    this.scanSitePhone = scanSitePhone;
                }

                public String getScanType() {
                    return scanType;
                }

                public void setScanType(String scanType) {
                    this.scanType = scanType;
                }

                public String getSignMan() {
                    return signMan;
                }

                public void setSignMan(String signMan) {
                    this.signMan = signMan;
                }
            }
        }
    }
}
