package com.dexfun.yiku.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.utils.AnimatorUtils;
import com.dexfun.yiku.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_go)
    Button btnGo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        SharedPreferencesUtil.getInstance().put(Constant.LocalKey.IS_ONE_START, false);
        ImageView imageView0 = new ImageView(this);
        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);

        imageView0.setImageResource(R.mipmap.ydy1);
        imageView1.setImageResource(R.mipmap.ydy2);
        imageView2.setImageResource(R.mipmap.ydy3);
        imageView3.setImageResource(R.mipmap.ydy4);
        imageView0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        List<View> viewList = new ArrayList<>();
        viewList.add(imageView0);
        viewList.add(imageView1);
        viewList.add(imageView2);
        viewList.add(imageView3);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };
        viewpager.setAdapter(pagerAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    viewpager.post(() -> AnimatorUtils.showGo(btnGo));
                } else {
                    AnimatorUtils.hideGo(btnGo);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

}
