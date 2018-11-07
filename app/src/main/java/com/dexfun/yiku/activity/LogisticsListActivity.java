package com.dexfun.yiku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

public class LogisticsListActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_logistics_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
setTitle("交易物流信息");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }
}
