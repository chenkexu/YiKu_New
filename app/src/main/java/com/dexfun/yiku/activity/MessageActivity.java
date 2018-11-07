package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {

    @BindView(R.id.vi_msg)
    LinearLayout viMsg;
    @BindView(R.id.vi_logistics)
    LinearLayout viLogistics;

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("消息");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }


    @OnClick({R.id.vi_msg, R.id.vi_logistics, R.id.vi_hd_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vi_msg:
                startActivity(new Intent(MessageActivity.this, SystemActivity.class));
                break;
            case R.id.vi_hd_msg:
                startActivity(new Intent(MessageActivity.this, ActiveActivity.class));
                break;
            case R.id.vi_logistics:
                startActivity(new Intent(MessageActivity.this, LogisticsListActivity.class));
                break;
            default:
        }
    }
}
