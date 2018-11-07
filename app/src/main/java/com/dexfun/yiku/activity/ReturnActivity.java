package com.dexfun.yiku.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DateTimePicker;
import cn.addapp.pickers.picker.TimePicker;

public class ReturnActivity extends BaseActivity {

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address_dt)
    TextView tvAddressDt;
    @BindView(R.id.iv_address)
    FrameLayout ivAddress;
    @BindView(R.id.btn_go)
    Button btnGo;
    @BindView(R.id.include_right_btn)
    View include_right_btn;
    int addressId = -1;
//    String time = "error";

    @Override
    public int getLayoutId() {
        return R.layout.activity_return;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("预约归还");
        include_right_btn.setVisibility(View.GONE);

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getDefaultAddress(data -> {
            if (data.getStatus() == 200) {

                addressId = data.getData().getAddressId();

                tvName.setText(data.getData().getConsignee());
                tvAddress.setText(data.getData().getRegion());
                tvAddressDt.setText(data.getData().getDetailedAddress());
                tvPhone.setText(data.getData().getContactNumber());
            }

        });
    }

    @Override
    protected void onRestart() {
        getData(null);
        super.onRestart();
    }


    @OnClick({R.id.iv_address, R.id.btn_go, R.id.btn_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_address:
                startActivity(new Intent(ReturnActivity.this, ReceiverAddressActivity.class));
                break;
            case R.id.btn_time:
//                DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
//                picker.setDateRangeStart(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//                picker.setDateRangeEnd(Calendar.getInstance().get(Calendar.YEAR), 12, 31);
//                picker.setWeightEnable(false);
//                picker.setTitleText("选择起始时间");
//                picker.setWheelModeEnable(false);
//                picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
//                    @Override
//                    public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
//                        TimePicker picker = new TimePicker(ReturnActivity.this, TimePicker.HOUR_24);
//                        picker.setTitleText("请选择终止时间");
//                        picker.setOnTimePickListener(new TimePicker.OnTimePickListener() {
//                            @Override
//                            public void onTimePicked(String s, String s1) {
//                                time = year + "-" + month + "-" + day + "!" + hour + ":" + minute + "-" + s + ":" + s1;
//                                tvDate.setText(time.replace("!", "--"));
//                            }
//                        });
//                        picker.show();
//
//                    }
//                });
//                picker.show();
//                Intent intent = new Intent(this, DateDialogClass.class);
//                try {
//                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
//                    startActivityForResult(intent, 222, activityOptionsCompat.toBundle());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    startActivityForResult(intent, 222);
//                }

                break;
            case R.id.btn_go:
//                if (time.equals("error")) {
//                    Toast.makeText(this, "请选择取件时间", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("请您确认取件地址是否正确，预约后无法更改信息")
                        .setPositiveButton("确定预约", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new HttpServiceImpl().creatYTOrder(getIntent().getStringExtra("id"), addressId, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                                    @Override
                                    public void onData(DefaultEntity data) {
                                        if (data.getStatus() == 200) {
                                            Toast.makeText(ReturnActivity.this, "成功", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(ReturnActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }).setNegativeButton("取消预约", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();

                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == 111) {
//            time = data.getStringExtra("key");
//            tvDate.setText(time.replace("!", "--"));
//        }
    }
}
