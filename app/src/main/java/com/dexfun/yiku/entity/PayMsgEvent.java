package com.dexfun.yiku.entity;

/**
 * Created by Smile on 17/6/25.
 */

public class PayMsgEvent {
    private boolean mMsg;

    public PayMsgEvent(boolean msg) {
        mMsg = msg;
    }

    public boolean isPay() {
        return mMsg;
    }
}
