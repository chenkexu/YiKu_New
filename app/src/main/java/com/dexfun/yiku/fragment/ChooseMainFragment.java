package com.dexfun.yiku.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.ZYWActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.fragment.home.TabAdapter;
import com.dexfun.yiku.utils.SharedPreferencesUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;

public class ChooseMainFragment extends BaseFragment {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_view_pager)
    ViewPager mainViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_choose_main;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new ChooseFragment());
        fragment.add(new OrnamentsFragment());
//        fragment.add(new BrandListFragmernt());
        mainTab.setTabMode(TabLayout.MODE_FIXED);
        ArrayList<String> title = new ArrayList<>();
        title.add("服装");
        title.add("配饰");
//        title.add("品牌");
        mainTab.post(() -> reflex(mainTab));
        mainTab.addTab(mainTab.newTab().setText(title.get(0)));
        mainTab.addTab(mainTab.newTab().setText(title.get(1)));
//        mainTab.addTab(mainTab.newTab().setText(title.get(2)));
        mainViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), fragment, title));
        mainViewPager.setOffscreenPageLimit(2);
        mainTab.setupWithViewPager(mainViewPager);

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
    public void getData(View view, Bundle savedInstanceState) {
        if (SharedPreferencesUtil.getInstance().getBoolean(Constant.LocalKey.ZYW, true)) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.activity_zyw, null);
            PopupWindow popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ImageView zyw = inflate.findViewById(R.id.zyw);
            popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
            zyw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });

//            startActivity(new Intent(getContext(), ZYWActivity.class));
            SharedPreferencesUtil.getInstance().put(Constant.LocalKey.ZYW, false);
        }
    }


}
