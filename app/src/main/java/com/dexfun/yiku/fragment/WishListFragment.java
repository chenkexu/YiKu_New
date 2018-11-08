package com.dexfun.yiku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.DepthPageTransformer;
import com.dexfun.yiku.activity.adapter.ViewPagerAdatper;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class WishListFragment extends BaseFragment {


    @BindView(R.id.type_RecyclerView)
    RecyclerView typeRecyclerView; //类型

    @BindView(R.id.style_RecyclerView)
    RecyclerView styleRecyclerView;//样式

    @BindView(R.id.season_RecyclerView)
    RecyclerView seasonRecyclerView;//季节

    @BindView(R.id.my_RecyclerView)
    RecyclerView myRecyclerView; //衣服的展示


    @BindView(R.id.in_viewpager)
    ViewPager inViewpager;




    @BindView(R.id.rl_choose)
    RelativeLayout rlChoose;
    @BindView(R.id.rl_choose_cloth)
    LinearLayout rlChooseCloth;
    Unbinder unbinder;

    private List<View> mViewList;


    @BindView(R.id.ll_point_group)
    LinearLayout llPointGroup;
    @BindView(R.id.view_red_point)
    View viewRedPoint;
    private int mPointWidth; // 两点间距



    private String typeStr; //类型
    private String styleStr; //样式
    private String seasonStr; //季节

    private OneAdapter oneAdapter;
    private OneAdapter oneAdapter1;
    private OneAdapter oneAdapter2;


    public WishListFragment() {
        // Required empty public constructor
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_wish_list;
    }


    @Override
    public void initView(View view, Bundle savedInstanceState) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("类型" + i);
        }
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        oneAdapter = new OneAdapter(R.layout.a, strings);
        typeRecyclerView.setAdapter(oneAdapter);

        ArrayList<String> strings1 = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            strings1.add("风格" + j);
        }
        styleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        oneAdapter1 = new OneAdapter(R.layout.a, strings1);
        styleRecyclerView.setAdapter(oneAdapter1);

        ArrayList<String> strings2 = new ArrayList<>();
        for (int l = 0; l < 4; l++) {
            strings2.add("季节" + l);
        }
        seasonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        oneAdapter2 = new OneAdapter(R.layout.a, strings2);
        seasonRecyclerView.setAdapter(oneAdapter2);

        ArrayList<Integer> strings3 = new ArrayList<>();
        for (int q = 0; q < 12; q++) {
            strings3.add(R.mipmap.text_indicator);
        }
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ThreeAdapter twoAdapter = new ThreeAdapter(R.layout.aa, strings3);
        myRecyclerView.setAdapter(twoAdapter);


        oneAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        oneAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });


        oneAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });


        initData();
    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {

    }


    //初始化viewpager
    private void initData() {
        mViewList = new ArrayList<>();
        LayoutInflater lf = getLayoutInflater().from(getActivity());
        View view1 = lf.inflate(R.layout.we_indicator1, null);
        View view2 = lf.inflate(R.layout.we_indicator2, null);
        View view3 = lf.inflate(R.layout.we_indicator3, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        for (int i = 0; i < 3; i++) {


            View point = new View(getActivity());
            point.setBackgroundResource(R.drawable.shape_guide_point_default);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    DensityUtils.dp2px(getActivity(), 5), DensityUtils.dp2px(getActivity(), 5));
            if (i != 0) {
                params.leftMargin = DensityUtils.dp2px(getActivity(), 10);
            }

            point.setLayoutParams(params);
            llPointGroup.addView(point);
        }

        inViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int leftMargin = (int) (mPointWidth * (positionOffset + position));
                // Log.d(TAG, "当前位置:" + position + ";偏移比例:" + positionOffset
                // + ";点偏移:" + leftMargin);

                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) viewRedPoint
                        .getLayoutParams();
                lp.leftMargin = leftMargin;
                viewRedPoint.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        inViewpager.setAdapter(new ViewPagerAdatper(mViewList));
        viewRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    // 完成布局后会回调改方法, 改方法可能会被回调多次
                    @Override
                    public void onGlobalLayout() {
                        // 此方法只需要执行一次就可以: 把当前的监听事件从视图树中移除掉, 以后就不会在回调此事件了.
                        viewRedPoint.getViewTreeObserver()
                                .removeGlobalOnLayoutListener(this);

                        mPointWidth = llPointGroup.getChildAt(1).getLeft()
                                - llPointGroup.getChildAt(0).getLeft();
                    }
                });

        inViewpager.setPageTransformer(true, new DepthPageTransformer());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //去选衣服
    @OnClick(R.id.btn_choose)
    public void onViewClicked() {

    }
}
