package com.dexfun.yiku.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smile on 18/5/11.
 */

public class ArticlesHomePageEntity extends DefaultEntity {
    /**
     * msg : null
     * data : {"articleVOS":[{"articleId":"994518860865605632","userId":253,"clothingId":39,"userNickName":"衣库官方","headPhoto":"http://img-cdn.xykoo.cn/user/18515064016/headPortrait","articleContent":"衣库社区终于跟大家见面了，欢迎小仙女们来踩！","articleTime":1525946748000,"articleStatus":0,"articleImages":["http://img-cdn.xykoo.cn/communityProduct/994518860912005120"],"fabulous":[3600,259,3638,3639,3641,3642,3640,3643,3644,3645,3646,3647,3650,3651,253]}],"number":1,"articleLoopPicVOS":[{"articleLoopPicId":1,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg"},{"articleLoopPicId":2,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage3.png","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage3.png"},{"articleLoopPicId":3,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage2.png","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage2.png"}],"totalPages":1,"totalElements":1}
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
         * articleVOS : [{"articleId":"994518860865605632","userId":253,"clothingId":39,"userNickName":"衣库官方","headPhoto":"http://img-cdn.xykoo.cn/user/18515064016/headPortrait","articleContent":"衣库社区终于跟大家见面了，欢迎小仙女们来踩！","articleTime":1525946748000,"articleStatus":0,"articleImages":["http://img-cdn.xykoo.cn/communityProduct/994518860912005120"],"fabulous":[3600,259,3638,3639,3641,3642,3640,3643,3644,3645,3646,3647,3650,3651,253]}]
         * number : 1
         * articleLoopPicVOS : [{"articleLoopPicId":1,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg"},{"articleLoopPicId":2,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage3.png","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage3.png"},{"articleLoopPicId":3,"loopPicUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage2.png","loopPicLinkUrl":"http://img-cdn.xykoo.cn/appImg/startPage/startPage2.png"}]
         * totalPages : 1
         * totalElements : 1
         */

        private int number;
        private int totalPages;
        private int totalElements;
        private List<ArticleVOSEntity> articleVOS;
        private List<ArticleLoopPicVOSEntity> articleLoopPicVOS;
        /**
         * communityActivity : {"activityId":1,"activityTitle":"标题","activityLabel":"标签","activityExplain":"活动说明","activityStatus":1,"mainDiagram":"http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg","exampleDiagram":"http://img1.imgtn.bdimg.com/it/u=4054100184,7315927&fm=27&gp=0.jpg","createDate":1528968323000,"updateDate":1528968327000,"operator":1}
         */

        private CommunityActivityEntity communityActivity;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public List<ArticleVOSEntity> getArticleVOS() {
            return articleVOS;
        }

        public void setArticleVOS(List<ArticleVOSEntity> articleVOS) {
            this.articleVOS = articleVOS;
        }

        public List<ArticleLoopPicVOSEntity> getArticleLoopPicVOS() {
            return articleLoopPicVOS;
        }

        public void setArticleLoopPicVOS(List<ArticleLoopPicVOSEntity> articleLoopPicVOS) {
            this.articleLoopPicVOS = articleLoopPicVOS;
        }

        public CommunityActivityEntity getCommunityActivity() {
            return communityActivity;
        }

        public void setCommunityActivity(CommunityActivityEntity communityActivity) {
            this.communityActivity = communityActivity;
        }

        public static class ArticleVOSEntity {
            /**
             * articleId : 994518860865605632
             * userId : 253
             * clothingId : 39
             * userNickName : 衣库官方
             * headPhoto : http://img-cdn.xykoo.cn/user/18515064016/headPortrait
             * articleContent : 衣库社区终于跟大家见面了，欢迎小仙女们来踩！
             * articleTime : 1525946748000
             * articleStatus : 0
             * articleImages : ["http://img-cdn.xykoo.cn/communityProduct/994518860912005120"]
             * fabulous : [3600,259,3638,3639,3641,3642,3640,3643,3644,3645,3646,3647,3650,3651,253]
             */

            private String articleId;
            private int userId;
            private int clothingId;
            private String userNickName;
            private String headPhoto;
            private String articleContent;
            private long articleTime;
            private int articleStatus;
            private ArrayList<String> articleImages;
            private List<Integer> fabulous;

            public String getArticleId() {
                return articleId;
            }

            public void setArticleId(String articleId) {
                this.articleId = articleId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getClothingId() {
                return clothingId;
            }

            public void setClothingId(int clothingId) {
                this.clothingId = clothingId;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getHeadPhoto() {
                return headPhoto;
            }

            public void setHeadPhoto(String headPhoto) {
                this.headPhoto = headPhoto;
            }

            public String getArticleContent() {
                return articleContent;
            }

            public void setArticleContent(String articleContent) {
                this.articleContent = articleContent;
            }

            public long getArticleTime() {
                return articleTime;
            }

            public void setArticleTime(long articleTime) {
                this.articleTime = articleTime;
            }

            public int getArticleStatus() {
                return articleStatus;
            }

            public void setArticleStatus(int articleStatus) {
                this.articleStatus = articleStatus;
            }

            public ArrayList<String> getArticleImages() {
                return articleImages;
            }

            public void setArticleImages(ArrayList<String> articleImages) {
                this.articleImages = articleImages;
            }

            public List<Integer> getFabulous() {
                return fabulous;
            }

            public void setFabulous(List<Integer> fabulous) {
                this.fabulous = fabulous;
            }
        }

        public static class ArticleLoopPicVOSEntity {
            /**
             * articleLoopPicId : 1
             * loopPicUrl : http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg
             * loopPicLinkUrl : http://img-cdn.xykoo.cn/appImg/startPage/42421525919838_.pic_hd.jpg
             */

            private int articleLoopPicId;
            private String loopPicUrl;
            private String loopPicLinkUrl;

            public int getArticleLoopPicId() {
                return articleLoopPicId;
            }

            public void setArticleLoopPicId(int articleLoopPicId) {
                this.articleLoopPicId = articleLoopPicId;
            }

            public String getLoopPicUrl() {
                return loopPicUrl;
            }

            public void setLoopPicUrl(String loopPicUrl) {
                this.loopPicUrl = loopPicUrl;
            }

            public String getLoopPicLinkUrl() {
                return loopPicLinkUrl;
            }

            public void setLoopPicLinkUrl(String loopPicLinkUrl) {
                this.loopPicLinkUrl = loopPicLinkUrl;
            }
        }

        public static class CommunityActivityEntity {
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
}
