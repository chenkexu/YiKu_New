package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/9/4.
 */

public class HotWearPageEntity extends  DefaultEntity {
    /**
     * data : {"number":1,"totalPage":1,"content":[{"hotWearId":77,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997680370388992","hotWearUrl":"https://mp.weixin.qq.com/s/lJmG9oPYojhNI1hiGYyE9A","status":1,"createDate":1534154375000,"operator":"3"},{"hotWearId":75,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997677690228736","hotWearUrl":"https://mp.weixin.qq.com/s/D6bHHvDrlQeSYjjnQKenVQ","status":1,"createDate":1533032396000,"operator":"3"},{"hotWearId":74,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997672044695552","hotWearUrl":"https://mp.weixin.qq.com/s/7SCSkE6NKhOBlTRpiuKEvQ","status":1,"createDate":1532600476000,"operator":"3"},{"hotWearId":72,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997667238023168","hotWearUrl":"https://mp.weixin.qq.com/s/gGB3QaoVr42EKjVfVN5FRA","status":1,"createDate":1528346393000,"operator":"6"},{"hotWearId":69,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997666281721856","hotWearUrl":"https://mp.weixin.qq.com/s/aUHhTiW1GcSCdQeQSAtvcw","status":1,"createDate":1527850025000,"operator":"3"}],"totalElements":5}
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
         * number : 1
         * totalPage : 1
         * content : [{"hotWearId":77,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997680370388992","hotWearUrl":"https://mp.weixin.qq.com/s/lJmG9oPYojhNI1hiGYyE9A","status":1,"createDate":1534154375000,"operator":"3"},{"hotWearId":75,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997677690228736","hotWearUrl":"https://mp.weixin.qq.com/s/D6bHHvDrlQeSYjjnQKenVQ","status":1,"createDate":1533032396000,"operator":"3"},{"hotWearId":74,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997672044695552","hotWearUrl":"https://mp.weixin.qq.com/s/7SCSkE6NKhOBlTRpiuKEvQ","status":1,"createDate":1532600476000,"operator":"3"},{"hotWearId":72,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997667238023168","hotWearUrl":"https://mp.weixin.qq.com/s/gGB3QaoVr42EKjVfVN5FRA","status":1,"createDate":1528346393000,"operator":"6"},{"hotWearId":69,"hotWearImg":"http://img-cdn.xykoo.cn/热门穿搭/1033997666281721856","hotWearUrl":"https://mp.weixin.qq.com/s/aUHhTiW1GcSCdQeQSAtvcw","status":1,"createDate":1527850025000,"operator":"3"}]
         * totalElements : 5
         */

        private int number;
        private int totalPage;
        private int totalElements;
        private List<ContentEntity> content;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity {
            /**
             * hotWearId : 77
             * hotWearImg : http://img-cdn.xykoo.cn/热门穿搭/1033997680370388992
             * hotWearUrl : https://mp.weixin.qq.com/s/lJmG9oPYojhNI1hiGYyE9A
             * status : 1
             * createDate : 1534154375000
             * operator : 3
             */

            private int hotWearId;
            private String hotWearImg;
            private String hotWearUrl;
            @SerializedName("status")
            private int statusX;
            private long createDate;
            private String operator;

            public int getHotWearId() {
                return hotWearId;
            }

            public void setHotWearId(int hotWearId) {
                this.hotWearId = hotWearId;
            }

            public String getHotWearImg() {
                return hotWearImg;
            }

            public void setHotWearImg(String hotWearImg) {
                this.hotWearImg = hotWearImg;
            }

            public String getHotWearUrl() {
                return hotWearUrl;
            }

            public void setHotWearUrl(String hotWearUrl) {
                this.hotWearUrl = hotWearUrl;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }
        }
    }
}
