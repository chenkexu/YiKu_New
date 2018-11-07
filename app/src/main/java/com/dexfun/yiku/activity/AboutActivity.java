package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dexfun.yiku.BuildConfig;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Smile
 */
public class AboutActivity extends BaseActivity {

    @BindView(R.id.vs)
    TextView vs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("关于我们");
        vs.setText(String.format("%s版", BuildConfig.VERSION_NAME));
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.id_xieyi)
    void d() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/userAgreement.html"));

    }
}
