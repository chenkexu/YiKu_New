package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.adapter.test.SchoolListActivity2;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.LoginEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.RSACryptography;
import com.tencent.stat.StatService;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Up
 * @date 2017/12/10
 */

public class UpdatePhoneActivity2 extends BaseActivity {


    @BindView(R.id.pd_telephonenumber)
    TextView pdTelephonenumber;
    @BindView(R.id.pd_newtelephonenumber)
    EditText pdNewtelephonenumber;
    @BindView(R.id.pd_sendconde)
    TextView pdSendconde;
    @BindView(R.id.tv_code)
    EditText tvCode;
    @BindView(R.id.tv_code2)
    TextView tvCode2;
    @BindView(R.id.btn_go)
    Button btnGo;
    @BindView(R.id.include_left_btn)
    View includeLeftBtn;
    private CountDownTimer timer;
    String phone;
    Integer schoolId = 0;
    @Override
    public int getLayoutId() {
        return R.layout.activity_personalupdatephone2;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("绑定手机号");
        phone = getIntent().getStringExtra("phone");
        pdTelephonenumber.setText(phone);
        includeLeftBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.pd_sendconde, R.id.btn_go,R.id.tv_code2})
    public void onViewClicked(View view) {
        String string = pdNewtelephonenumber.getText().toString();
        switch (view.getId()) {
            case R.id.pd_sendconde:
                if (string.length() != 11) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }


                try {
                    new HttpServiceImpl().getVerifyCode(RSACryptography.encryptPhone(string), data -> {
                        if (data.getStatus() == 200) {
                            pdSendconde.setEnabled(false);
                            pdSendconde.setTextColor(getResources().getColor(R.color.lod));
                            startCountDownTime();
                        } else {
                            Toast.makeText(this, data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_go:
                new HttpServiceImpl().setPhone2(pdNewtelephonenumber.getText().toString(), tvCode.getText().toString(), schoolId, new HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN>() {
                    @Override
                    public void onData(LoginEntity.DSFLOGIN data) {
                        if (data.getStatus() == 200) {
                            StatService.trackCustomKVEvent(UpdatePhoneActivity2.this, "Register", null);
                            UserClass.getInstance().setToken(data.getData().getToken());
                            Toast.makeText(UpdatePhoneActivity2.this, "成功", Toast.LENGTH_SHORT).show();
                            pdTelephonenumber.setText(string);
                            startActivity(new Intent(UpdatePhoneActivity2.this, HomeActivity.class));
                            finish();
                        } else {
                            Toast.makeText(UpdatePhoneActivity2.this, "" + data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.tv_code2:
                startActivityForResult(new Intent(UpdatePhoneActivity2.this, SchoolListActivity2.class), 1118);
                break;
            default:
        }
    }

    private void startCountDownTime() {
        timer = new CountDownTimer((long) 60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                System.out.println(millisUntilFinished);
                pdSendconde.setText(String.format("%sS",
                        new DecimalFormat("0").format(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                timer.cancel();
                pdSendconde.setText("重新获取");
                pdSendconde.setEnabled(true);
                pdSendconde.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        };
        timer.start();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1118||resultCode==100) {
            schoolId = data.getIntExtra("schoolId", 0);
            tvCode2.setText(data.getStringExtra("name"));
        }
    }
}
