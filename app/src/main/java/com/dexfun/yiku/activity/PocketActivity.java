package com.dexfun.yiku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemPocketAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.EnhanceTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static android.support.design.widget.TabLayout.GRAVITY_FILL;


public class PocketActivity extends BaseActivity {

    @BindView(R.id.tab_on)
    EnhanceTabLayout tabOn;
    @BindView(R.id.list_on)
    ListView listOn;
    @BindView(R.id.btn_go)
    Button btnGo;
    int orderStatus = 0;
    int index = 0, status = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pocket;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        setTitle("衣袋");

        index = getIntent().getIntExtra(Constant.LocalKey.INDEX, 0);

        ArrayList<String> title = new ArrayList<>();
        title.add("全部衣袋");
        title.add("待签收");
        title.add("待归还");
        title.add("已归还");


        for(int i=0;i<title.size();i++){
            tabOn.addTab(title.get(i));
        }


//        reflex(tabOn);
//        tabOn.addTab(tabOn.newTab().setText("全部衣袋"));
//        tabOn.addTab(tabOn.newTab().setText("待签收"));
//        tabOn.addTab(tabOn.newTab().setText("待归还"));
//        tabOn.addTab(tabOn.newTab().setText("已归还"));

        tabOn.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                if (null == tab.getText()) {
//                    Toast.makeText(PocketActivity.this, "BOOM!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                status = tab.getPosition();
//                String title = tab.getText().toString();
                switch (status){
                    case 0:
                        orderStatus = 0;
                        break;
                    case 1:
                        orderStatus = 9;
                        break;
                    case 2:
                        orderStatus = 4;
                        break;
                    case 3:
                        orderStatus = 5;
                        break;
                }
//                if ("全部衣袋".equals(title)) {
//                    orderStatus = 0;
//                } else if ("待签收".equals(title)) {
//                    orderStatus = 9;
//                } else if ("待归还".equals(title)) {
//                    orderStatus = 4;
//                } else if ("已归还".equals(title)) {
//                    orderStatus = 5;
//                }
                btnGo.setVisibility(View.GONE);
                getData(savedInstanceState);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        TabLayout tabLayout = tabOn.getTabLayout();
        TabLayout.Tab tabAt = tabLayout.getTabAt(index);
        if (null != tabAt) {
            tabAt.select();
        }
        tabLayout.setTabGravity(GRAVITY_FILL);
    }





    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().queryOrder(orderStatus, data -> {
            if (data.getStatus() == 200) {
                listOn.setAdapter(new ItemPocketAdapter(status, PocketActivity.this, data.getData()));
                if (orderStatus == 9 && data.getData().size() != 0) {
                    btnGo.setText("确认收货");
                    btnGo.setEnabled(true);
                    btnGo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    btnGo.setTextColor(getResources().getColor(R.color.white));
                    btnGo.setVisibility(View.VISIBLE);
                } else if (orderStatus == 4 && data.getData().size() != 0) {
                    btnGo.setText("预约归还");
//                    btnGo.setVisibility(View.VISIBLE);

                }
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (orderStatus == 9) {
                            if (data.getData().get(0).getOrderStatus() == 3) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(PocketActivity.this);
                                builder.setTitle("提示");
                                builder.setMessage("确认收货?");
                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        new HttpServiceImpl().setUpdateOrder(data.getData().get(0).getId(), 4, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                                            @Override
                                            public void onData(DefaultEntity data) {
                                                if (data.getStatus() == 200) {
                                                    getData(null);
                                                    Toast.makeText(PocketActivity.this, "确认成功", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(PocketActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).show();

                            } else {
                                Toast.makeText(PocketActivity.this, "发货后才能确认收货哦", Toast.LENGTH_SHORT).show();
                            }
                        } else if (orderStatus == 4) {
//                            Calendar instance = Calendar.getInstance();
//                            instance.set(2018, 2, 23);
//                            long timeInMillis = instance.getTimeInMillis();
//                            if (System.currentTimeMillis() < timeInMillis) {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(PocketActivity.this);
//                                builder.setTitle("提示");
//                                builder.setMessage("小仙女，快递小哥还没回来上班，衣服23号以后预约归还即可，此期间会员期会冻结，不会浪费哦");
//                                builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//
//                                    }
//                                }).show();
//                                return;
//                            }
//                            System.out.println(timeInMillis);
                            startActivity(new Intent(PocketActivity.this, ReturnActivity.class).putExtra("id", data.getData().get(0).getOrderNo()));
                        }
                    }
                });
            }

        });
    }

    @Override
    protected void onRestart() {
        getData(null);
        super.onRestart();
    }

    @OnClick(R.id.include_right_btn)
    void include_right_btxn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PocketActivity.this);
        builder.setTitle("提示");
        builder.setMessage("如果遇到特殊情况无法预约，需要您主动联系快递上门取件。\n" +
                "收件地址：山东省 青州市 丰收二路 衣库仓储中心\n" +
                "收件人信息：衣库APP   \n" +
                "收件人联系方式：156 1420 5108");
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }
}
