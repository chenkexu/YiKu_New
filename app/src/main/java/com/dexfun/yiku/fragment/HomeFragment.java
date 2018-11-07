package com.dexfun.yiku.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.MessageActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.fragment.home.TabAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_view_pager)
    ViewPager mainViewPager;
    private Fragment mContentFragment = new Fragment();
    private ArrayList<String> title;
    private ArrayList<Fragment> fragment;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        fragment = new ArrayList<>();
        MainFragment mainFragment = new MainFragment();
        CommunityFragment communityFragment = new CommunityFragment();


        fragment.add(mainFragment);
        fragment.add(communityFragment);
//        mainTab.setTabMode(TabLayout.MODE_FIXED);
        title = new ArrayList<>();
        title.add("推荐");
        title.add("晒图");
        mainTab.addTab(mainTab.newTab().setText(title.get(0)));
        mainTab.addTab(mainTab.newTab().setText(title.get(1)));
        switchContent(fragment.get(0));
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchContent(fragment.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mainViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), fragment, title));
        mainTab.post(() -> reflex(mainTab));
        mainTab.setupWithViewPager(mainViewPager);

    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {

    }

    @OnClick(R.id.vi_msg)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), MessageActivity.class));
    }

    //改变Tab底线的长度，根据字的长度
//    public void reflex(final TabLayout tabLayout) {
//        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
//        tabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //拿到tabLayout的mTabStrip属性
//                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
//
//                    int dp10 = dip2px(tabLayout.getContext(), 10);
//
//                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
//                        View tabView = mTabStrip.getChildAt(i);
//
//                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
//                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
//                        mTextViewField.setAccessible(true);
//
//                        TextView mTextView = (TextView) mTextViewField.get(tabView);
//
//                        tabView.setPadding(0, 0, 0, 0);
//
//                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
//                        int width = 0;
//                        width = mTextView.getWidth();
//                        if (width == 0) {
//                            mTextView.measure(0, 0);
//                            width = mTextView.getMeasuredWidth();
//                        }
//
//                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
//                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
//                        params.width = width;
//                        params.leftMargin = dp10;
//                        params.rightMargin = dp10;
//                        tabView.setLayoutParams(params);
//
//                        tabView.invalidate();
//                    }
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

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

    private void switchContent(Fragment to) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (mContentFragment != to) {
            if (!to.isAdded()) {
                transaction.hide(mContentFragment).add(mainViewPager.getId(), to).commitAllowingStateLoss();
            } else {
                transaction.hide(mContentFragment).show(to).commitAllowingStateLoss();
            }
            mContentFragment = to;
        } else {
            transaction.replace(mainViewPager.getId(), to).commitAllowingStateLoss();
        }
    }

}
