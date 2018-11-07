package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.SizeTabEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SizeTabActivity extends BaseActivity {

    @BindView(R.id.tv_jw)
    EditText tvJw;
    @BindView(R.id.tv_xw)
    EditText tvXw;
    @BindView(R.id.tv_yw)
    EditText tvYw;
    @BindView(R.id.tv_tw)
    EditText tvTw;

    @Override
    public int getLayoutId() {
        return R.layout.activity_size_tab;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("尺码资料");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserSizeTable(new HttpServiceImpl.OnObjectDataListener<SizeTabEntity>() {
            @Override
            public void onData(SizeTabEntity data) {
                if (data.getStatus() == 200) {
                    tvJw.setText(String.valueOf(data.getData().getShoulderWidth()));
                    tvXw.setText(String.valueOf(data.getData().getBust()));
                    tvYw.setText(String.valueOf(data.getData().getTheWaist()));
                    tvTw.setText(String.valueOf(data.getData().getHipline()));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        String xw = tvXw.getText().toString();
        String yw = tvYw.getText().toString();
        String tw = tvTw.getText().toString();
        String jw = tvJw.getText().toString();
//        boolean b = TextUtils.isEmpty(xw) ||
//                TextUtils.isEmpty(yw) ||
//                TextUtils.isEmpty(tw) ||
//                TextUtils.isEmpty(jw);
//        if (b){
//            Toast.makeText(this, "信息不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
        new HttpServiceImpl().addUserSizeTable(xw,yw, tw, jw, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
            @Override
            public void onData(DefaultEntity data) {

            }
        });
        super.onBackPressed();
    }
}
