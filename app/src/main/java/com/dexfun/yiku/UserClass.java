package com.dexfun.yiku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.activity.LoginActivity;
import com.dexfun.yiku.activity.UpdatePhoneActivity2;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.LoginEntity;
import com.dexfun.yiku.entity.QQLoginEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.GsonUtil;
import com.dexfun.yiku.utils.RSACryptography;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.igexin.sdk.PushManager;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.stat.StatService;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

import static io.rong.imkit.utils.SystemUtils.getCurProcessName;

/**
 * Created by Smile on 17/11/2.
 */

public class UserClass {

    private static String token = "error";
    private static String rToken = "rToken";
    private static String userName = "userName";
//    @BindView(R.id.close)
//    ImageView close;
//    @BindView(R.id.input_phone)
//    EditText inputPhone;
//    @BindView(R.id.clear)
//    TextView clear;
//    @BindView(R.id.qq)
//    ImageView qq;
//    @BindView(R.id.WeChat)
//    ImageView WeChat;
//    @BindView(R.id.xiayibu)
//    ImageView xiayibu;
//    @BindView(R.id.close1)
//    ImageView close1;
//    @BindView(R.id.my_phone)
//    TextView myPhone;
//    @BindView(R.id.send)
//    TextView send;
//    @BindView(R.id.code)
//    EditText code;
//    @BindView(R.id.brack)
//    TextView brack;
//    private PopupWindow popupWindow;
//    private PopupWindow popupWindow1;
//    private View inflate;
//    private View register;
//    Context context1;
//    private CountDownTimer timer;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        UserClass.userid = userid;
        SharedPreferencesUtil.getInstance().put(Constant.User.USER_ID, userid);
    }

    private static String userid = "userid";

    public static UserClass getInstance() {
        return new UserClass();
    }

    private UserClass() {
        token = SharedPreferencesUtil.getInstance().getString(Constant.User.TOKEN_KEY, "error");
        rToken = SharedPreferencesUtil.getInstance().getString(Constant.User.R_TOKEN_KEY, "rToken");
        userName = SharedPreferencesUtil.getInstance().getString(Constant.User.USER_NAME, "userName");
        userid = SharedPreferencesUtil.getInstance().getString(Constant.User.USER_ID, "0");
    }

    public void setToken(String token) {
        UserClass.token = token;
        SharedPreferencesUtil.getInstance().put(Constant.User.TOKEN_KEY, token);
    }

    public static void setrToken(String rToken) {
        UserClass.rToken = rToken;
        SharedPreferencesUtil.getInstance().put(Constant.User.R_TOKEN_KEY, rToken);
    }

    public static void setUserName(String userName) {
        UserClass.userName = userName;
        SharedPreferencesUtil.getInstance().put(Constant.User.USER_NAME, userName);
    }

    public String getToken() {
        return token;
    }

    public static String getrToken() {
        return rToken;
    }

    public static String getUserName() {
        return userName;
    }

    public void rmToken() {
        SharedPreferencesUtil.getInstance().put(Constant.User.TOKEN_KEY, "error");
        SharedPreferencesUtil.getInstance().put(Constant.User.R_TOKEN_KEY, "rToken");
        SharedPreferencesUtil.getInstance().put(Constant.User.USER_NAME, "userName");
        SharedPreferencesUtil.getInstance().put(Constant.User.USER_ID, "0");
    }

    public static void connect(String token) {

        if (MainClass.getInstance().getApplicationInfo().packageName.equals(getCurProcessName(MainClass.getInstance().getApplicationContext()))) {
            System.out.println("token = [" + token + "]");
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                            2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {
                    System.err.println("UserClass.onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    System.err.println("userid = [" + userid + "]");
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    System.err.println("errorCode = [" + errorCode + "]");
                }
            });
        } else {
            System.out.println("UserClass.connect");
        }
    }


    public boolean isLogin(Context context) {
        if (getToken().length() < 20 || getToken().contains("error")) {
            context.startActivity(new Intent(context, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            register = LayoutInflater.from(context).inflate(R.layout.login, null);
//            popupWindow = new PopupWindow(register, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            popupWindow.showAtLocation(register, Gravity.CENTER, 0, 0);
//            inflate = LayoutInflater.from(context).inflate(R.layout.long1, null);
//            popupWindow1 = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            context1 = context;
            return false;
        }
        return true;
    }

    public boolean isLogin2(Context context) {
        if (getToken().length() < 20 || getToken().contains("error")) {
            return false;
        }
        return true;
    }

//    String input_phone1 = inputPhone.getText().toString();
//    String myPhone1 = myPhone.getText().toString();
//    Tencent mTencent;
//    IUiListener loginListener;
//    @OnClick({R.id.close, R.id.input_phone, R.id.clear, R.id.qq, R.id.WeChat, R.id.xiayibu, R.id.close1, R.id.my_phone, R.id.send, R.id.code, R.id.brack})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.close:
//                popupWindow.dismiss();
//                break;
//            case R.id.input_phone:
//                break;
//            case R.id.clear:
//                inputPhone.setText("");
//                break;
//            case R.id.qq:
////                mTencent = Tencent.createInstance("1106544375", context1);
////                loginListener = new IUiListener() {
////                    @Override
////                    public void onComplete(Object o) {
////                        System.out.println(o.toString());
////                        mTencent.setOpenId("1106544375");
////                        try {
////                            JSONObject jsonObject = new JSONObject(o.toString());
////                            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
////                            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
////                            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
////                            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
////                                    && !TextUtils.isEmpty(openId)) {
////                                mTencent.setAccessToken(token, expires);
////                                mTencent.setOpenId(openId);
////                            }
////                        } catch (Exception e) {
////                        }
////                        Toast.makeText(context1, "登陆成功", Toast.LENGTH_SHORT).show();
////                        UserInfo mInfo = new UserInfo(context1, mTencent.getQQToken());
////                        mInfo.getUserInfo(new IUiListener() {
////                            @Override
////                            public void onComplete(Object o) {
////                                System.out.println(o.toString());
////                                QQLoginEntity qqLoginEntity = new QQLoginEntity();
////                                JSONObject jsonObject = null;
////                                try {
////                                    jsonObject = new JSONObject(o.toString());
////                                } catch (JSONException e) {
////                                    e.printStackTrace();
////                                }
////                                String city = jsonObject.optString("city");
////                                String gender = jsonObject.optString("gender");
////                                String nickname = jsonObject.optString("nickname");
////                                String figureurl_2 = jsonObject.optString("figureurl_2");
////                                qqLoginEntity.setCity(city);
////                                qqLoginEntity.setSex(gender);
////                                qqLoginEntity.setOpenid(mTencent.getOpenId());
////                                qqLoginEntity.setNickname(nickname);
////                                qqLoginEntity.setHeadimgurl(figureurl_2);
////                                String s = GsonUtil.create().toJson(qqLoginEntity);
////                                new HttpServiceImpl().login2(s, new HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN>() {
////                                    @Override
////                                    public void onData(LoginEntity.DSFLOGIN data) {
////                                        if (data.getStatus() == 200) {
////                                            UserClass.getInstance().setToken(data.getData().getToken());
////                                            PushManager.getInstance().initialize(context1, DemoPushService.class);
////                                            PushManager.getInstance().registerPushIntentService(context1, DemoIntentService.class);
////                                            new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
////                                                @Override
////                                                public void onData(GetUserInfoEntity data) {
////                                                    if (data.getStatus() == 200) {
////                                                        StatService.trackCustomKVEvent(context1, "Login", null);
////                                                        if (TextUtils.isEmpty(data.getData().getUserInfo().getPhone())) {
////                                                            context1.startActivity(new Intent(context1, UpdatePhoneActivity2.class));
//////                                                            finish();
////                                                        } else {
////                                                            context1.startActivity(new Intent(context1, HomeActivity.class));
//////                                                            finish();
////                                                        }
////
////                                                    }
////                                                }
////                                            });
////
////                                        }
////                                    }
////                                });
////                            }
////
////                            @Override
////                            public void onError(UiError uiError) {
////
////                            }
////
////                            @Override
////                            public void onCancel() {
////
////                            }
////                        });
////                    }
////
////                    @Override
////                    public void onError(UiError uiError) {
////                        System.out.println(uiError.errorMessage);
////                        System.out.println(uiError.errorDetail);
////                        System.out.println(uiError.errorCode);
////                        System.out.println("LoginActivity.onError");
////                    }
////
////                    @Override
////                    public void onCancel() {
////                        System.out.println("LoginActivity.onCancel-");
////                    }
////                };
////                mTencent.logout(context1);
////                if (!mTencent.isSessionValid()) {
////                    mTencent.login((Activity) context1, "get_user_info", loginListener);
////
////                }
//                break;
//            case R.id.WeChat:
//                break;
//            case R.id.xiayibu:
//                popupWindow.dismiss();
//                popupWindow1.showAtLocation(inflate, Gravity.CENTER, 0, 0);
//                break;
//            case R.id.close1:
//                popupWindow1.dismiss();
//                break;
//            case R.id.my_phone:
//                myPhone.setText(input_phone1);
//                break;
//            case R.id.send:
////                try {
////                    if (TextUtils.isEmpty(myPhone1)) {
////                        Toast.makeText(context1, "手机号不能为空", Toast.LENGTH_SHORT).show();
////                        return;
////                    }
////                    new HttpServiceImpl().getVerifyCode(RSACryptography.encryptPhone(myPhone1), data -> {
////                        if (data.getStatus() == 200) {
////                            send.setEnabled(false);
////                        } else {
////                            Toast.makeText(context1, data.getMsg(), Toast.LENGTH_SHORT).show();
////                        }
////                    });
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////                startCountDownTime();
////                send.setEnabled(false);
//                break;
//            case R.id.code:
//                break;
//            case R.id.brack:
//                popupWindow1.dismiss();
//                popupWindow.showAtLocation(register, Gravity.CENTER, 0, 0);
//                break;
//        }
//    }

//    private void startCountDownTime() {
//        timer = new CountDownTimer((long) 60 * 1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
////                System.out.println(millisUntilFinished);
//                send.setText(String.format("%sS",
//                        new DecimalFormat("0").format(millisUntilFinished / 1000)));
//            }
//
//            @Override
//            public void onFinish() {
//                timer.cancel();
//                send.setText("重新获取");
//                send.setEnabled(true);
//            }
//        };
//        timer.start();
//    }

}
