package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/9/5.
 */

public class SuitWithPage extends DefaultEntity {

    /**
     * data : {"number":1,"totalPage":2,"content":[{"suitWithId":55,"imgUrl":"http://img-cdn.xykoo.cn/suitWith/img/20180905105346","linkUrl":"http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=null","updateDate":1536116041000,"adminId":6},{"suitWithId":54,"imgUrl":"http://img-cdn.xykoo.cn/suitWith/img/20180905105311","linkUrl":"http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=null","updateDate":1536116006000,"adminId":6}],"totalElements":4}
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
         * totalPage : 2
         * content : [{"suitWithId":55,"imgUrl":"http://img-cdn.xykoo.cn/suitWith/img/20180905105346","linkUrl":"http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=null","updateDate":1536116041000,"adminId":6},{"suitWithId":54,"imgUrl":"http://img-cdn.xykoo.cn/suitWith/img/20180905105311","linkUrl":"http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=null","updateDate":1536116006000,"adminId":6}]
         * totalElements : 4
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
             * suitWithId : 55
             * imgUrl : http://img-cdn.xykoo.cn/suitWith/img/20180905105346
             * linkUrl : http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=null
             * updateDate : 1536116041000
             * adminId : 6
             */

            private int suitWithId;
            private String imgUrl;
            private String linkUrl;
            private long updateDate;
            private int adminId;

            public int getSuitWithId() {
                return suitWithId;
            }

            public void setSuitWithId(int suitWithId) {
                this.suitWithId = suitWithId;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public int getAdminId() {
                return adminId;
            }

            public void setAdminId(int adminId) {
                this.adminId = adminId;
            }
        }
    }
}
