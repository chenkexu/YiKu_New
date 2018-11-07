package com.dexfun.yiku.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.DemoIntentService;
import com.dexfun.yiku.DemoPushService;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.LoginActivity;
import com.dexfun.yiku.activity.UpdatePhoneActivity2;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.LoginEntity;
import com.dexfun.yiku.entity.PayMsgEvent;
import com.dexfun.yiku.entity.WeiChatEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.igexin.sdk.PushManager;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.stat.StatService;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initData();
    }

    private void initData() {
        api = WXAPIFactory.createWXAPI(this, Constant.LocalKey.APP_ID, false);
        api.registerApp(Constant.LocalKey.APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq req) {
        System.out.println(req);
    }

    @Override
    public void onResp(BaseResp resp) {
        System.out.println(resp);
        String result = null;
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK: {
                switch (resp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        result = "登录成功";
                        //拿到了微信返回的code,立马再去请求access_token
                        String code = ((SendAuth.Resp) resp).code;

                        System.out.println(code);
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求
                        new HttpServiceImpl().getAccessToken(code, data -> {
                            if (data.getStatus() == 200) {
                                new HttpServiceImpl().getWeiChatInfo(data.getAccess_token(), data1 -> {
                                    if (data1.contains("error")) {
                                        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                                    } else {
                                        JSONObject userId = null;
                                        try {
                                            JSONObject jsonObject = new JSONObject(data1);
                                            userId = jsonObject.put("userId", Integer.valueOf(UserClass.getInstance().getUserid()));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            try {
                                                userId = new JSONObject(data1);
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                        new HttpServiceImpl().login(userId.toString(), new HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN>() {
                                            @Override
                                            public void onData(LoginEntity.DSFLOGIN data) {
                                                if (data.getStatus() == 200) {
                                                    UserClass.getInstance().setToken(data.getData().getToken());
                                                    PushManager.getInstance().initialize(WXEntryActivity.this, DemoPushService.class);
                                                    PushManager.getInstance().registerPushIntentService(WXEntryActivity.this, DemoIntentService.class);
                                                    new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
                                                        @Override
                                                        public void onData(GetUserInfoEntity data) {
                                                            if (data.getStatus() == 200) {
                                                                StatService.trackCustomKVEvent(WXEntryActivity.this, "Login", null);

                                                                if (TextUtils.isEmpty(data.getData().getUserInfo().getPhone())) {
                                                                    startActivity(new Intent(WXEntryActivity.this, UpdatePhoneActivity2.class));
                                                                    finish();
                                                                } else {
                                                                    startActivity(new Intent(WXEntryActivity.this, HomeActivity.class));
                                                                    finish();
                                                                }

                                                            }
                                                        }
                                                    });

                                                }
                                            }
                                        });
                                    }
                                });
                            } else {
                                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case RETURN_MSG_TYPE_SHARE:
                        result = "分享成功";
                        new HttpServiceImpl().shareInfo(data -> {

                        });
                        break;
                    default:
                }
            }
            break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = "分享取消";
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result = "分享被拒绝";
                break;
            default:
                result = "分享返回";
                break;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        this.finish();
    }
}