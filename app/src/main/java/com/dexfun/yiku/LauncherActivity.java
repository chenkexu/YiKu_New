package com.dexfun.yiku;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dexfun.yiku.activity.ViewPagerActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.StartEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import butterknife.BindView;

public class LauncherActivity extends BaseActivity {

    @BindView(R.id.skip_btn)
    Button mSkipButton;
    @BindView(R.id.launcher_image)
    ImageView mContentImage;

    private CountDownTimer timer;

    private String id = "null";


    @Override
    public int getLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setTheme(R.style.AppTheme_NoActionBar);
        return R.layout.activity_launcher;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(getIntent().getAction()) && getIntent().getAction().equals(Intent.ACTION_VIEW)) {
            Uri data = getIntent().getData();
            if (null != data) {
                id = data.getQueryParameter("id");
                Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
            }
        }
        mSkipButton.setOnClickListener(view -> {
            mSkipButton.setEnabled(false);
            timer.onFinish();
        });
    }

    String url;

    @Override
    public void getData(Bundle savedInstanceState) {

        mContentImage.postDelayed(new Runnable() {
            @Override
            public void run() {
                startCountDownTime();
            }
        },1000);
        new HttpServiceImpl().getStartImg(new HttpServiceImpl.OnObjectDataListener<StartEntity>() {
            @Override
            public void onData(StartEntity data) {
                if (data.getStatus() == 200) {
                    url = data.getData().getJumpUrl();
                    Picasso.get().load(data.getData().getImgUrl()).into(mContentImage);
                }
            }
        });

        mContentImage.setOnClickListener(v -> {
            if (timer != null) {
                timer.cancel();
            }
            startNext();
            startActivity(new Intent(this, WebViewActivity.class).putExtra("url", url));
        });

    }
//
//    @OnClick(R.id.launcher_image)
//    void jp() {
//
//    }

    private void startCountDownTime() {
        timer = new CountDownTimer((long) 3500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mSkipButton.setVisibility(View.VISIBLE);
                mSkipButton.setText(String.format("%s 跳过",
                        new DecimalFormat("0").format(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                timer.cancel();
                startNext();
            }
        };
        timer.start();
    }


    @SuppressLint("WrongConstant")
    private void startNext() {
        if (SharedPreferencesUtil.getInstance().getBoolean(Constant.LocalKey.IS_ONE_START, true)) {
            startActivity(new Intent(this, ViewPagerActivity.class));
            finish();
        } else {
            startActivity(new Intent(LauncherActivity.this, HomeActivity.class).putExtra("id", id));
            finish();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }
}
