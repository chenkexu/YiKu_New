package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.DemoIntentService;
import com.dexfun.yiku.DemoPushService;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.LoginEntity;
import com.dexfun.yiku.entity.QQLoginEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.GsonUtil;
import com.dexfun.yiku.utils.RSACryptography;
import com.igexin.sdk.PushManager;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.stat.StatService;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.input_phone)
    EditText inputPhone;
    @BindView(R.id.get_code)
    TextView getCode;
    @BindView(R.id.input_code)
    EditText inputCode;
    @BindView(R.id.btn_login)
    TextView btnLogin;
    private CountDownTimer timer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    Tencent mTencent;
    IUiListener loginListener;

    @OnClick({R.id.get_code, R.id.btn_login, R.id.btn_wx_login, R.id.btn_qq_login, R.id.btn_register})
    public void onViewClicked(View view) {
        String phone = inputPhone.getText().toString();
        switch (view.getId()) {
            case R.id.get_code:
                try {
                    if (TextUtils.isEmpty(phone)) {
                        Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    new HttpServiceImpl().getVerifyCode(RSACryptography.encryptPhone(phone), data -> {
                        if (data.getStatus() == 200) {
                            getCode.setEnabled(false);
                            getCode.setTextColor(getResources().getColor(R.color.lod));
                        } else {
                            Toast.makeText(this, data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startCountDownTime();
                getCode.setEnabled(false);
                getCode.setTextColor(getResources().getColor(R.color.lod));
                break;
            case R.id.btn_login:
                String code = inputCode.getText().toString();
                new HttpServiceImpl().doLogin(phone, code, data -> {
                    if (data.getStatus() == 200) {
                        StatService.trackCustomKVEvent(this, "Login", null);
                        UserClass.getInstance().setToken(data.getData());
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
                        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
                        finish();
                    } else {
                        Toast.makeText(this, data.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.btn_wx_login:
                IWXAPI wxapi = WXAPIFactory.createWXAPI(this, Constant.LocalKey.APP_ID, false);
                wxapi.registerApp(Constant.LocalKey.APP_ID);
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                wxapi.sendReq(req);
                break;
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.btn_qq_login:
                mTencent = Tencent.createInstance("1106544375", getApplicationContext());
                loginListener = new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        System.out.println(o.toString());
                        System.out.println("LoginActivity.onComplete");
                        mTencent.setOpenId("1106544375");
                        try {
                            JSONObject jsonObject = new JSONObject(o.toString());
                            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
                            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
                            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
                            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                                    && !TextUtils.isEmpty(openId)) {
                                mTencent.setAccessToken(token, expires);
                                mTencent.setOpenId(openId);
                            }
                        } catch (Exception e) {
                        }
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        UserInfo mInfo = new UserInfo(LoginActivity.this, mTencent.getQQToken());
                        mInfo.getUserInfo(new IUiListener() {
                            @Override
                            public void onComplete(Object o) {
                                System.out.println(o.toString());
                                QQLoginEntity qqLoginEntity = new QQLoginEntity();
                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(o.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String city = jsonObject.optString("city");
                                String gender = jsonObject.optString("gender");
                                String nickname = jsonObject.optString("nickname");
                                String figureurl_2 = jsonObject.optString("figureurl_2");
                                qqLoginEntity.setCity(city);
                                qqLoginEntity.setSex(gender);
                                qqLoginEntity.setOpenid(mTencent.getOpenId());
                                qqLoginEntity.setNickname(nickname);
                                qqLoginEntity.setHeadimgurl(figureurl_2);
                                String s = GsonUtil.create().toJson(qqLoginEntity);
                                new HttpServiceImpl().login2(s, new HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN>() {
                                    @Override
                                    public void onData(LoginEntity.DSFLOGIN data) {
                                        if (data.getStatus() == 200) {
                                            UserClass.getInstance().setToken(data.getData().getToken());
                                            PushManager.getInstance().initialize(LoginActivity.this, DemoPushService.class);
                                            PushManager.getInstance().registerPushIntentService(LoginActivity.this, DemoIntentService.class);
                                            new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
                                                @Override
                                                public void onData(GetUserInfoEntity data) {
                                                    if (data.getStatus() == 200) {
                                                        StatService.trackCustomKVEvent(LoginActivity.this, "Login", null);
                                                        if (TextUtils.isEmpty(data.getData().getUserInfo().getPhone())) {
                                                            startActivity(new Intent(LoginActivity.this, UpdatePhoneActivity2.class));
                                                            finish();
                                                        } else {
                                                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                                            finish();
                                                        }

                                                    }
                                                }
                                            });

                                        }
                                    }
                                });
                            }

                            @Override
                            public void onError(UiError uiError) {

                            }

                            @Override
                            public void onCancel() {

                            }
                        });
                    }

                    @Override
                    public void onError(UiError uiError) {
                        System.out.println(uiError.errorMessage);
                        System.out.println(uiError.errorDetail);
                        System.out.println(uiError.errorCode);
                        System.out.println("LoginActivity.onError");
                    }

                    @Override
                    public void onCancel() {
                        System.out.println("LoginActivity.onCancel-");
                    }
                };
                mTencent.logout(this);
                if (!mTencent.isSessionValid()) {
                    mTencent.login(this, "get_user_info", loginListener);

                }
                break;
            default:

        }
    }

    private void startCountDownTime() {
        timer = new CountDownTimer((long) 60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                System.out.println(millisUntilFinished);
                getCode.setText(String.format("%sS",
                        new DecimalFormat("0").format(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                timer.cancel();
                getCode.setText("重新获取");
                getCode.setEnabled(true);
                getCode.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        };
        timer.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }


}
