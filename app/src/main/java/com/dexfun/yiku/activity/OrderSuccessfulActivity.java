package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.MainClass;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemNewOrderAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.NewOrderEntity;
import com.dexfun.yiku.utils.GsonUtil;
import com.dexfun.yiku.widget.CustomListView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderSuccessfulActivity extends BaseActivity {


    @BindView(R.id.list)
    CustomListView list;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.jump_get)
    ImageView jumpGet;
    @BindView(R.id.ordid)
    TextView ordid;
    @BindView(R.id.time)
    TextView time;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_successful;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("下单成功");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        String stringExtra = getIntent().getStringExtra("key");
        NewOrderEntity newOrderEntity = GsonUtil.create().fromJson(stringExtra, NewOrderEntity.class);
        NewOrderEntity.DataEntity data = newOrderEntity.getData();
        String orderNo = data.getOrderNo();
        long createDate = data.getCreateDate();
        NewOrderEntity.DataEntity.AddressVoEntity addressVo = data.getAddressVo();
        List<NewOrderEntity.DataEntity.ClothingListEntity> clothingList = data.getClothingList();

        address.setText(addressVo.getDetailedAddress());
        phone.setText(addressVo.getConsignee() + "  " + addressVo.getContactNumber());
        ordid.setText("订单号：" + orderNo);
        time.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.SIMPLIFIED_CHINESE).format(createDate));
        list.setAdapter(new ItemNewOrderAdapter(this,clothingList));
    }


    @OnClick(R.id.to_order)
    void onToOrderClick() {
        startActivity(new Intent(this, PocketActivity.class));
        onBackPressed();
    }

    @OnClick(R.id.to_home)
    void onToHomeClick() {
        MainClass.finishActivityPassThis(HomeActivity.class);
        onBackPressed();
    }

    @OnClick(R.id.jump_get)
    public void onViewClicked() {
        startActivity(new Intent(OrderSuccessfulActivity.this, InviteActivity.class));
    }

}
