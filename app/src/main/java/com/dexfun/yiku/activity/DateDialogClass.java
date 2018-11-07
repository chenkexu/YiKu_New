package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.utils.UiUtils;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Smile on 17/12/14.
 */

public class DateDialogClass extends BaseActivity {
    public static final String TYPE = "type";
    @BindView(R.id.date_jt)
    RadioButton dateJt;
    @BindView(R.id.date_mt)
    RadioButton dateMt;
    @BindView(R.id.date_10_12)
    RadioButton date1012;
    @BindView(R.id.date_12_14)
    RadioButton date1214;
    @BindView(R.id.date_14_16)
    RadioButton date1416;
    @BindView(R.id.group_1)
    RadioGroup group1;
    @BindView(R.id.group_2)
    RadioGroup group2;

    private boolean dd = false;
    private String time = "error";

    @Override
    public int getLayoutId() {
        UiUtils.setStatusBarLightMode(this);
        return R.layout.view_date;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(300);
            slide.setSlideEdge(Gravity.BOTTOM);
            getWindow().setEnterTransition(slide);
        }

    }

    @Override
    public void getData(Bundle savedInstanceState) {

        dateJt.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                buttonView.setTextColor(getResources().getColor(R.color.white));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        });
        dateMt.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                buttonView.setTextColor(getResources().getColor(R.color.white));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        });
        date1012.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                time = "%s10:00:00!%s12:00:00";
                buttonView.setTextColor(getResources().getColor(R.color.white));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        });
        date1214.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                time = "%s12:00:00!%s14:00:00";
                buttonView.setTextColor(getResources().getColor(R.color.white));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        });
        date1416.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                time = "%s14:00:00!%s16:00:00";
                buttonView.setTextColor(getResources().getColor(R.color.white));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        });
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!date1012.isChecked()) {
                    date1012.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                if (!date1214.isChecked()) {
                    date1214.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                if (!date1416.isChecked()) {
                    date1416.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                if (checkedId == dateJt.getId()) {
                    dd = false;
                    Calendar instance = Calendar.getInstance();
                    int i = instance.get(Calendar.HOUR_OF_DAY);
                    System.out.println(i);
                    if (i >= 12) {
                        date1012.setEnabled(false);
                        date1012.setChecked(false);
                        date1012.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                    if (i >= 14) {
                        date1214.setEnabled(false);
                        date1214.setChecked(false);
                        date1214.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                    if (i >= 16) {
                        dateJt.post(new Runnable() {
                            @Override
                            public void run() {
                                dateMt.setChecked(true);
                                dateJt.setEnabled(false);
                                dateJt.setTextColor(getResources().getColor(R.color.colorAccent));
                            }
                        });
                        date1416.setEnabled(false);
                        date1416.setChecked(false);
                        date1416.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                } else {
                    dd = true;
                    date1012.setChecked(false);
                    date1214.setChecked(false);
                    date1416.setChecked(false);

                    date1012.setEnabled(true);
                    date1214.setEnabled(true);
                    date1416.setEnabled(true);
                }
            }
        });
        dateJt.setChecked(true);

    }

    @OnClick({R.id.tv_close, R.id.btn_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_close:
                finish();
                break;
            case R.id.btn_go:
                if (time.equals("error")) {
                    Toast.makeText(this, "请选择时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                Calendar instance = Calendar.getInstance();
                if (dd) {
                    instance.add(Calendar.DAY_OF_MONTH, 1);
                }
                String i = instance.get(Calendar.YEAR) + "-" + (instance.get(Calendar.MONTH) + 1) + "-" + instance.get(Calendar.DAY_OF_MONTH) + "-";
                String format = String.format(time, i, i);
                System.out.println(format);

                setResult(111, new Intent().putExtra("key", format));
                finish();
                break;
            default:
        }
    }
}
