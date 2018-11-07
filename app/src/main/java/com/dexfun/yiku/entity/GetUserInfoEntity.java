package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 17/12/19.
 */

public class GetUserInfoEntity extends DefaultEntity {


    /**
     * msg : null
     * data : {"userInfo":{"userId":270,"photo":"http://img-cdn.xykoo.cn/touxiang.png","phone":"15911180155","nickname":"测试用户","gender":1,"isShare":1,"newUser":1},"rongToken":"FhSriIuDgcPSyOXWkyvlCfj1/xSbm1iM+Ll5z+GXEC0DI+lKHd2mipZTcivs+ex3GHGepmUyq9ELXXngFMrxzg==","cardInfo":{"cardId":null,"cardNum":"2018013043658","phone":null,"effective":2,"validity":"0","depositEffective":1,"cardType":1,"openingTime":null,"expirtTime":null,"daysRemaining":null,"couponVoList":[{"couponId":4,"couponName":"邀请奖励券","couponDays":5,"expiryTime":1577808000000,"couponStatus":1}]}}
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
         * userInfo : {"userId":270,"photo":"http://img-cdn.xykoo.cn/touxiang.png","phone":"15911180155","nickname":"测试用户","gender":1,"isShare":1,"newUser":1}
         * rongToken : FhSriIuDgcPSyOXWkyvlCfj1/xSbm1iM+Ll5z+GXEC0DI+lKHd2mipZTcivs+ex3GHGepmUyq9ELXXngFMrxzg==
         * cardInfo : {"cardId":null,"cardNum":"2018013043658","phone":null,"effective":2,"validity":"0","depositEffective":1,"cardType":1,"openingTime":null,"expirtTime":null,"daysRemaining":null,"couponVoList":[{"couponId":4,"couponName":"邀请奖励券","couponDays":5,"expiryTime":1577808000000,"couponStatus":1}]}
         */

        private UserInfoEntity userInfo;
        private String rongToken;
        private CardInfoEntity cardInfo;
        /**
         * school : {"schoolId":1,"province":"北京","city":"北京市","schoolName":"#其它院校"}
         */

        private SchoolEntity school;

        public UserInfoEntity getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoEntity userInfo) {
            this.userInfo = userInfo;
        }

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
        }

        public CardInfoEntity getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfoEntity cardInfo) {
            this.cardInfo = cardInfo;
        }

        public SchoolEntity getSchool() {
            return school;
        }

        public void setSchool(SchoolEntity school) {
            this.school = school;
        }

        public static class UserInfoEntity {
            /**
             * userId : 270
             * photo : http://img-cdn.xykoo.cn/touxiang.png
             * phone : 15911180155
             * nickname : 测试用户
             * gender : 1
             * isShare : 1
             * newUser : 1
             */

            private int userId;
            private String photo;
            private String phone;
            private String nickname;
            private int gender;
            private int isShare;
            private int newUser;
            private String inviteCode;

            public String getInviteCode() {
                return inviteCode;
            }

            public void setInviteCode(String inviteCode) {
                this.inviteCode = inviteCode;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getIsShare() {
                return isShare;
            }

            public void setIsShare(int isShare) {
                this.isShare = isShare;
            }

            public int getNewUser() {
                return newUser;
            }

            public void setNewUser(int newUser) {
                this.newUser = newUser;
            }
        }

        public static class CardInfoEntity {
            /**
             * cardId : null
             * cardNum : 2018013043658
             * phone : null
             * effective : 2
             * validity : 0
             * depositEffective : 1
             * cardType : 1
             * openingTime : null
             * expirtTime : null
             * daysRemaining : null
             * couponVoList : [{"couponId":4,"couponName":"邀请奖励券","couponDays":5,"expiryTime":1577808000000,"couponStatus":1}]
             */

            private Object cardId;
            private String cardNum;
            private Object phone;
            private int effective;
            private String validity;
            private int depositEffective;
            private int cardType;
            private Object openingTime;
            private Object expirtTime;
            private Object daysRemaining;
            private List<CouponVoListEntity> couponVoList;

            public Object getCardId() {
                return cardId;
            }

            public void setCardId(Object cardId) {
                this.cardId = cardId;
            }

            public String getCardNum() {
                return cardNum;
            }

            public void setCardNum(String cardNum) {
                this.cardNum = cardNum;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
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

            public Object getOpeningTime() {
                return openingTime;
            }

            public void setOpeningTime(Object openingTime) {
                this.openingTime = openingTime;
            }

            public Object getExpirtTime() {
                return expirtTime;
            }

            public void setExpirtTime(Object expirtTime) {
                this.expirtTime = expirtTime;
            }

            public Object getDaysRemaining() {
                return daysRemaining;
            }

            public void setDaysRemaining(Object daysRemaining) {
                this.daysRemaining = daysRemaining;
            }

            public List<CouponVoListEntity> getCouponVoList() {
                return couponVoList;
            }

            public void setCouponVoList(List<CouponVoListEntity> couponVoList) {
                this.couponVoList = couponVoList;
            }

            public static class CouponVoListEntity {
                /**
                 * couponId : 4
                 * couponName : 邀请奖励券
                 * couponDays : 5
                 * expiryTime : 1577808000000
                 * couponStatus : 1
                 */

                private int couponId;
                private String couponName;
                private int couponDays;
                private long expiryTime;
                private int couponStatus;

                public int getCouponType() {
                    return couponType;
                }

                public void setCouponType(int couponType) {
                    this.couponType = couponType;
                }

                private int couponType;

                public int getCouponId() {
                    return couponId;
                }

                public void setCouponId(int couponId) {
                    this.couponId = couponId;
                }

                public String getCouponName() {
                    return couponName;
                }

                public void setCouponName(String couponName) {
                    this.couponName = couponName;
                }

                public int getCouponDays() {
                    return couponDays;
                }

                public void setCouponDays(int couponDays) {
                    this.couponDays = couponDays;
                }

                public long getExpiryTime() {
                    return expiryTime;
                }

                public void setExpiryTime(long expiryTime) {
                    this.expiryTime = expiryTime;
                }

                public int getCouponStatus() {
                    return couponStatus;
                }

                public void setCouponStatus(int couponStatus) {
                    this.couponStatus = couponStatus;
                }
            }
        }

        public static class SchoolEntity {
            /**
             * schoolId : 1
             * province : 北京
             * city : 北京市
             * schoolName : #其它院校
             */

            private int schoolId;
            private String province;
            private String city;
            private String schoolName;

            public int getSchoolId() {
                return schoolId;
            }

            public void setSchoolId(int schoolId) {
                this.schoolId = schoolId;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getSchoolName() {
                return schoolName;
            }

            public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
            }
        }
    }
}
