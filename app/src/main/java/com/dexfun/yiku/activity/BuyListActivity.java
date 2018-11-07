package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemWalletDetailAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;

public class BuyListActivity extends BaseActivity {

    @BindView(R.id.list_detail)
    ListView listView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("支付记录");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getTransactionDetails(
                data -> listView.setAdapter(new ItemWalletDetailAdapter(BuyListActivity.this, data.getData())));
    }
}
