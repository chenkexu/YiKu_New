package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.DemoIntentService;
import com.dexfun.yiku.DemoPushService;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.MainClass;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.adapter.test.SchoolListActivity2;
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

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.input_phone)
    EditText inputPhone;
    @BindView(R.id.get_code)
    TextView getCode;
    @BindView(R.id.input_code)
    EditText inputCode;
    @BindView(R.id.input_yqm)
    TextView inputYqm;
    @BindView(R.id.btn_register)
    TextView btnLogin;
    private CountDownTimer timer;

    Integer schoolId = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.get_code, R.id.btn_register, R.id.input_yqm})
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
            case R.id.btn_register:
                String code = inputCode.getText().toString();

                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                new HttpServiceImpl().register(phone, code, schoolId, new HttpServiceImpl.OnObjectDataListener<LoginEntity>() {
                    @Override
                    public void onData(LoginEntity data) {
                        if (data.getStatus() == 200) {
                            StatService.trackCustomKVEvent(RegisterActivity.this, "Register", null);
                            UserClass.getInstance().setToken(data.getData());
                            MainClass.finishActivity(LoginActivity.class);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.input_yqm:
                startActivityForResult(new Intent(RegisterActivity.this, SchoolListActivity2.class), 1118);
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
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1118||resultCode==100) {
            schoolId = data.getIntExtra("schoolId", 0);
            inputYqm.setText(data.getStringExtra("name"));
        }
    }
}
