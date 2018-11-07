package com.dexfun.yiku.entity;

/**
 * Created by Smile on 18/2/28.
 */

public class WeiChatEntity extends DefaultEntity {
    /**
     * access_token : 7_482W9XOdTTe-BbMAaYaAa2Is4fVYgDxYWhocD5ONA4ZMekQiWmFjwELqZK5-luc5UD2WryjhBFL0mqeLSTefQ75VC_W2hObogw6hMAJgieU
     * expires_in : 7200
     * refresh_token : 7_DPmqGCbtIaUo-2XkT486-BkR7_u_07BO8nP-trx9tpYdTD4Ry89fCMEdRq9ZTFh2zCzn1nWmp6Jh-cLID46PcVOz2lIzaRqw6yXqOPcSVNQ
     * openid : oxxn91LGnoxK1hrFNHdDV40oqXAU
     * scope : snsapi_userinfo
     * unionid : oMTz10XGpdQfRFlWFKvQB2H6Vsyw
     */

    private String access_token;
    private long expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
