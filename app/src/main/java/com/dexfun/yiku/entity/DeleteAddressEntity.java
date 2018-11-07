package com.dexfun.yiku.entity;

/**
 * Created by Up on 2017/12/24.
 */

public class DeleteAddressEntity {

    /**
     * status : 200
     * msg : 删除地址成功
     * data : null
     * success : true
     */

    private int status;
    private String msg;
    private Object data;
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
