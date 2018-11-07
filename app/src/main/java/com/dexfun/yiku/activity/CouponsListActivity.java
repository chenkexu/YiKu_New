package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemWalletCardAdapter;
import com.dexfun.yiku.activity.adapter.ItemWalletCardAdapter2;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.CouponsListEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.fragment.HomeFragment;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CouponsListActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.tab_coup)
    TabLayout tab_coup;
    @BindView(R.id.btn_no)
    Button btnNo;
    ItemWalletCardAdapter2 itemWalletCardAdapter;
    int type = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_coupons_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("我的卡劵");
        if (getIntent().hasExtra("fromMe")) {
            btnNo.setVisibility(View.GONE);
        }
        tab_coup.addTab(tab_coup.newTab().setText("加时卡"));
        tab_coup.addTab(tab_coup.newTab().setText("优惠劵"));
        tab_coup.addTab(tab_coup.newTab().setText("加衣劵"));
//        tab_coup.setSelectedTabIndicatorColor(Color.parseColor("#FFF34520"));
        reflex(tab_coup);
        tab_coup.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    type = 3;
                    getData(null);
                } else if (tab.getPosition() == 1){
                    type = 1;
                    getData(null);
                }else if (tab.getPosition() == 2){
                    type = 2;
                    getData(null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CouponsListEntity.DataEntity item = itemWalletCardAdapter.getItem(position);
                if (item.getCouponStatus() == 1) {
                    if (item.getCouponType() == 2) {
                        if (getIntent().hasExtra("fromMe")) {
                            startActivity(new Intent(CouponsListActivity.this, BuyCardActivity.class).putExtra("id1", item.getCouponId()).putExtra("p1", itemWalletCardAdapter.getItem(position).getCouponAmount()));
                        } else {
                            setResult(10005, new Intent().putExtra("id", item.getCouponId()).putExtra("p", itemWalletCardAdapter.getItem(position).getCouponAmount()));
                            finish();
                        }
                    }else if (item.getCouponType() == 1){
                        new HttpServiceImpl().clipCoupons(item.getCouponId(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                            @Override
                            public void onData(DefaultEntity data) {
                                if (data.getStatus()==200){
                                    Toast.makeText(CouponsListActivity.this, "使用成功", Toast.LENGTH_SHORT).show();
                                    getData(null);
                                }
                            }
                        });
                    }

                } else if (item.getCouponStatus() == 3) {
                    Toast.makeText(CouponsListActivity.this, "已过期", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void reflex(final TabLayout tabLayout) {
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

                    int dp10 = dip2px(tabLayout.getContext(), 75);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static int dip2px(Context context, float dipValue) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);  //+0.5是为了向上取整
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserCouponsList(new HttpServiceImpl.OnObjectDataListener<CouponsListEntity>() {
            @Override
            public void onData(CouponsListEntity data) {
                if (data.getStatus() == 200) {
                    List<CouponsListEntity.DataEntity> listData = new ArrayList<>();
                    for (CouponsListEntity.DataEntity dataEntity : data.getData()) {
                        if (dataEntity.getCouponStatus() == type) {
                            listData.add(dataEntity);
                        }
                    }
                    if (listData.isEmpty()){
                        findViewById(R.id.sts).setVisibility(View.VISIBLE);
                    }else {
                        findViewById(R.id.sts).setVisibility(View.GONE);
                    }
                    itemWalletCardAdapter = new ItemWalletCardAdapter2(CouponsListActivity.this, listData);
                    list.setAdapter(itemWalletCardAdapter);
                }
            }
        });
    }

    @OnClick(R.id.btn_no)
    public void onViewClicked() {
        setResult(10005, new Intent().putExtra("id", 0).putExtra("p", 0));
        finish();
    }
}
