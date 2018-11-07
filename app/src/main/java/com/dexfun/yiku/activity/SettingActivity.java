package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.MainClass;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.base.BaseActivity;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.scavenging_caching)
    FrameLayout scavengingCaching;
    @BindView(R.id.caching_nb)
    TextView cachingNb;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("设置");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        long l = 0;
        File[] files = getCacheDir().listFiles();
        if (files == null) {
            files = new File("/data/data/com.dexfun.yiku/cache/").listFiles();
        }
        for (File file : files) {
            if (file.isFile()) {
                l += file.length();
            }
            if (file.isDirectory()) {
                for (File file1 : file.listFiles()) {
                    if (file1.isFile()) {
                        l += file1.length();
                    }
                }
            }

        }
        cachingNb.setText(String.format("%sM", l / 1024 / 1024));
    }


    @OnClick(R.id.scavenging_caching)
    public void onViewClicked() {
        File[] files = getCacheDir().listFiles();
        if (files == null) {
            files = new File("/data/data/com.dexfun.yiku/cache/").listFiles();
        }
        for (File file : files) {
            if (file.isFile()) {
                boolean delete = file.delete();
                System.out.println(delete);
            }
            if (file.isDirectory()) {
                for (File file1 : file.listFiles()) {
                    if (file1.isFile()) {
                        boolean delete = file1.delete();
                        System.out.println(delete);
                    }
                }
            }

        }
        Toast.makeText(this, "清除缓存成功", Toast.LENGTH_SHORT).show();
        cachingNb.setText("0M");
    }

    @OnClick(R.id.btn_logout)
    public void onLogOut() {
        UserClass.getInstance().rmToken();
        finish();
    }

    @OnClick(R.id.abt)
    public void abt() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    @OnClick(R.id.up)
    public void up() {
        startActivity(new Intent(this, UPActivity.class));
    }

    @OnClick(R.id.address_set)
    public void address_set() {
        if (UserClass.getInstance().isLogin(this))
        startActivity(new Intent(this, ReceiverAddressActivity.class));
    }

}
