package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.tencent.stat.StatService;

import butterknife.OnClick;

public class getAddCardActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_get_add_card;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("购买加衣券");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.getcard)
    void getcard() {
        PayDialogClass.setOnPayListener(new PayDialogClass.OnPayListener() {
            @Override
            public void onSuccess() {
                StatService.trackCustomKVEvent(getAddCardActivity.this, "PayCard", null);
                Toast.makeText(getAddCardActivity.this, "购买成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancel() {
                super.onCancel();
            }

            @Override
            public void onWait() {
                super.onWait();
            }
        });
        PayDialogClass.startPayClass(getAddCardActivity.this, 5, 2, 0);
    }
}
