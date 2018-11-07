package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/3/1.
 */

public class QQLoginEntity {
    /**
     * city : string
     * headimgurl : string
     * nickname : string
     * openid : string
     * sex : string
     */

    private String city;
    private String headimgurl;
    private String nickname;
    private String openid;
    private String sex;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
