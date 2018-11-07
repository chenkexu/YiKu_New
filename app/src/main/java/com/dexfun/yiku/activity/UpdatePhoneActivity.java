package com.dexfun.yiku.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.MatcherUtil;
import com.dexfun.yiku.utils.RSACryptography;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Up on 2017/12/10.
 */

public class UpdatePhoneActivity extends BaseActivity {


    @BindView(R.id.pd_telephonenumber)
    TextView pdTelephonenumber;
    @BindView(R.id.pd_newtelephonenumber)
    EditText pdNewtelephonenumber;
    @BindView(R.id.pd_sendconde)
    TextView pdSendconde;
    @BindView(R.id.tv_code)
    EditText tvCode;
    @BindView(R.id.btn_go)
    Button btnGo;
    private CountDownTimer timer;
    String phone;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personalupdatephone;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("修改手机号");
        phone = getIntent().getStringExtra("phone");
        pdTelephonenumber.setText(phone);
        if (tvCode.length() == 0) {
            btnGo.setBackgroundColor(Color.parseColor("#FFF34520"));
        } else {
            btnGo.setBackgroundColor(Color.parseColor("#FFDDDDDD"));
        }
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.pd_sendconde, R.id.btn_go})
    public void onViewClicked(View view) {
        String string = pdNewtelephonenumber.getText().toString();
        switch (view.getId()) {
            case R.id.pd_sendconde:
                if (string.length() != 11) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }


                try {
                    new HttpServiceImpl().getVerificationCode(RSACryptography.encryptPhone(string), data -> {
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
                new HttpServiceImpl().setPhone(pdNewtelephonenumber.getText().toString(), tvCode.getText().toString(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                    @Override
                    public void onData(DefaultEntity data) {
                        if (data.getStatus() == 200) {
                            Toast.makeText(UpdatePhoneActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            pdTelephonenumber.setText(string);
                            setResult(602, new Intent().putExtra("phone", string));
                        } else {
                            Toast.makeText(UpdatePhoneActivity.this, "" + data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
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
        super.onBackPressed();
    }
}
