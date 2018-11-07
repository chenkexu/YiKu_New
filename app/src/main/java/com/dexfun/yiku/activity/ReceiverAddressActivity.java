package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemReceiverAddressAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AllAddressEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Up on 2017/12/6.
 */

public class ReceiverAddressActivity extends BaseActivity {
    @BindView(R.id.receiverAddress_recycler)
    ListView receiverAddressRecycler;
    @BindView(R.id.receiverAddress_btn)
    Button receiverAddressBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_receiver_address;

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("收货地址");

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getAllAddress(new HttpServiceImpl.OnObjectDataListener<AllAddressEntity>() {
            @Override
            public void onData(AllAddressEntity data) {
                List<AllAddressEntity.DataBean> data1 = data.getData();
                if (null==data1)return;
                receiverAddressRecycler.setAdapter(new ItemReceiverAddressAdapter(ReceiverAddressActivity.this,  data1));
            }
        });
    }

    @OnClick(R.id.receiverAddress_btn)
    void receiverAddressBtn() {
        startActivity(new Intent(this, AddAddressActivity.class));
    }

    @Override
    protected void onRestart() {
        getData(null);
        super.onRestart();
    }


}
