package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

import butterknife.OnClick;

public class FAQActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_faq;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("常见问题");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.rentclothesrule)
    void rentClothesRule() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/rentalAgreement.html"));
    }

    @OnClick(R.id.backclothesrule)
    void backClothesRule() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/back.html"));
    }

    @OnClick(R.id.logisticsdistribution)
    void logisticsDistribution() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/Logistics.html"));
    }

    @OnClick(R.id.orderproblem)
    void orderProblem() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/order.html"));
    }

    @OnClick(R.id.qxfw)
    void qxfw() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/clean.html"));
    }


}
