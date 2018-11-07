package com.dexfun.yiku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

public class SystemActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_system;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
setTitle("系统通知");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }
}
