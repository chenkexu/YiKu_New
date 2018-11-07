package com.dexfun.yiku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

/**
 * @author Smile
 */
public class ActiveActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_active;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("活动消息");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }
}
