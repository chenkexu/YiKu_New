package com.dexfun.yiku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

import butterknife.OnClick;

public class ZYWActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_zyw;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.zyw)
    void zyw(){
        finish();
    }
}
