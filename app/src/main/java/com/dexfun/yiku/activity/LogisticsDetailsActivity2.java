package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemTimelineAdapter;
import com.dexfun.yiku.activity.adapter.ItemTimelineAdapter2;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.LogBackEntity;
import com.dexfun.yiku.entity.LogisticsEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;

import butterknife.BindView;

public class LogisticsDetailsActivity2 extends BaseActivity {

    @BindView(R.id.list_logistics)
    CustomListView listLogistics;
    @BindView(R.id.tv_st)
    TextView tvSt;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_logistics_details;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("物流信息");
        listLogistics.setFocusable(false);
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getExpressTrack(getIntent().getStringExtra("id"), new HttpServiceImpl.OnObjectDataListener<LogBackEntity>() {
            @Override
            public void onData(LogBackEntity data) {
                if (data.getStatus() == 200) {
                    LogBackEntity.DataEntityX data1 = data.getData();
                    if (data1!=null){
                        listLogistics.setAdapter(new ItemTimelineAdapter2(LogisticsDetailsActivity2.this, data.getData().getData().get(0).getTraces()));
                        String opcode = data.getData().getData().get(0).getBillCode();
                        String tvPhonex = data.getData().getData().get(0).getTraces().get(0).getDispOrRecManPhone();
                        tvId.setText("运单编号："+opcode);
                        tvPhone.setText("快递员电话："+tvPhonex);
                    }else {
                        Toast.makeText(LogisticsDetailsActivity2.this, "暂无物流信息", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

            }
        });

    }

}

