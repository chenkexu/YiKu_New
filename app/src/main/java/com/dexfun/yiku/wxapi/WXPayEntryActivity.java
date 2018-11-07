package com.dexfun.yiku.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;




import com.dexfun.yiku.Constant;
import com.dexfun.yiku.entity.PayMsgEvent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, Constant.LocalKey.APP_ID, false);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        // TODO: 17/6/12 不知道啥玩意 不管
        System.err.println(req.getType());
    }

    @Override
    public void onResp(BaseResp resp) {

        System.err.println(resp.errCode);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                EventBus.getDefault().post(new PayMsgEvent(true));
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                // TODO: 17/6/12 不做处理 用户可能会切换支付方式
                break;
            default:
//                EventBus.getDefault().post(new PayMsgEvent(false));
                break;
        }

        finish();
    }


}