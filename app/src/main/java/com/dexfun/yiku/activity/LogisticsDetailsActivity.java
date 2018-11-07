package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemTimelineAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.LogisticsEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogisticsDetailsActivity extends BaseActivity {

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
        new HttpServiceImpl().getSFTrack(getIntent().getStringExtra("id"), new HttpServiceImpl.OnObjectDataListener<LogisticsEntity>() {
            @Override
            public void onData(LogisticsEntity data) {
                if (data.getStatus() != 200) {
                    Toast.makeText(LogisticsDetailsActivity.this, "暂无物流信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                listLogistics.setAdapter(new ItemTimelineAdapter(LogisticsDetailsActivity.this, data.getData().getBody()));
                String opcode = data.getData().getBody().get(0).getOpcode();
                String transMessageId = data.getData().getBody().get(0).getMailNo();
                tvId.setText(transMessageId);
            }
        });

    }

}

