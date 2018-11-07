package com.dexfun.yiku.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.FreshClothEntity;
import com.dexfun.yiku.entity.SelectClothEntity;
import com.dexfun.yiku.fragment.home.ItemChooseStAdapter;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter2;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.AnimatorUtils;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.dexfun.yiku.widget.GridViewWithHeaderAndFooter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.rong.eventbus.EventBus;

public class ChooseFragment extends BaseFragment {


    @BindView(R.id.grid_view)
    GridViewWithHeaderAndFooter gridView;

    @BindView(R.id.go_top)
    View go_top;
    View viewLocal;
    GridView tabSt;
    //    TabLayout tabPl;
//    TabLayout tabPx;
    @BindView(R.id.vi_refresh)
    SmartRefreshLayout refreshLayout;
    ItemPushViewAdapter2 itemPushViewAdapter2;
    int clothingTypeId = 0, clothingSortId = 0, page = 1, sytleId = 0;

    boolean show = false;
    TextView AllScreening;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_choose;
    }

//    public TabLayout getTabPx() {
//        return tabPx;
//    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = inflater.inflate(R.layout.view_choose_header, null);


        tabSt = headerView.findViewById(R.id.tab_st);
//        tabPl = headerView.findViewById(R.id.tab_pl);
//        tabPx = headerView.findViewById(R.id.tab_px);
        viewLocal = headerView.findViewById(R.id.view_local);
        //全部筛选
        AllScreening = headerView.findViewById(R.id.AllScreening);
        AllScreeningListener();

        gridView.addHeaderView(headerView); // 他需要在setAdapter()之前
        gridView.setFocusable(false);
//        tabPx.setFocusable(false);
//        tabPl.setFocusable(false);
        refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getFreshClothList();
            }
        });


        itemPushViewAdapter2 = new ItemPushViewAdapter2(getContext(), new ArrayList<>());
        gridView.setAdapter(itemPushViewAdapter2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int clothingId = itemPushViewAdapter2.getItem(i).getClothingId();
                if (clothingId == 0) {
                    startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", itemPushViewAdapter2.getItem(i).getAdUrl()));
                    return;
                }
                startActivity(new Intent(getContext(), DetailActivity.class).putExtra("id", clothingId));
            }
        });


    }

    private void AllScreeningListener() {
        AllScreening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.all_screening, null);
                PopupWindow popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout screen_dismise = inflate.findViewById(R.id.screen_dismise);
                RecyclerView screen_RecyclerView = inflate.findViewById(R.id.screen_RecyclerView);
                TextView screen_reset = inflate.findViewById(R.id.screen_reset);
                TextView screen_save = inflate.findViewById(R.id.screen_save);
                popupWindow.showAtLocation(inflate, Gravity.RIGHT, 0, 0);

                List<String> list1 = new ArrayList<>();
                List<Date1> list2 = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 6; j++) {
                        list1.add("内容" + i);
                    }
                    list2.add(new Date1("标题", list1));
                }
                FourAdapter fourAdapter = new FourAdapter(R.layout.aaaaaa, list2);
                screen_RecyclerView.setAdapter(fourAdapter);
                screen_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


                if (popupWindow.isShowing()) {
                    screen_dismise.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });
                    screen_reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });
                    screen_save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                }
            }
        });

    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
        new HttpServiceImpl().selectClothPage(1, 3, (SelectClothEntity data) -> {
            if (data.getStatus() != 200) {
                return;
            }

//            tabPl.clearOnTabSelectedListeners();
//            tabPl.removeAllTabs();

//            for (SelectClothEntity.DataEntity.SecondLevelCategoryListEntity secondLevelCategoryListEntity : data.getData().getSecondLevelCategoryList()) {
//                tabPl.addTab(tabPl.newTab().setText(secondLevelCategoryListEntity.getCatName()));
//            }
//            tabPx.clearOnTabSelectedListeners();
//            tabPx.removeAllTabs();
//            for (SelectClothEntity.DataEntity.SortListEntity sortListEntity : data.getData().getSortList()) {
//                tabPx.addTab(tabPx.newTab().setText(sortListEntity.getClothingSortName()));
//            }
//            tabPl.post(new Runnable() {
//                @Override
//                public void run() {
//                    tabPl.setScrollPosition(0, 0, true);
//                }
//            });
//            tabPx.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    getTabPx().getTabAt(3).select();
//                    tabPx.setScrollPosition(3, 0, true);
//                    gridView.smoothScrollToPositionFromTop(2, 500);
//
//
//                }
//            });
//            tabPl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//                    clothingTypeId = data.getData().getSecondLevelCategoryList().get(tab.getPosition()).getCatId();
//                    page = 1;
//                    itemPushViewAdapter2.setObjects(new ArrayList<>());
//                    getFreshClothList();
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
//            tabPx.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//                    clothingSortId = data.getData().getSortList().get(tab.getPosition()).getClothingSortId();
//                    page = 1;
//                    itemPushViewAdapter2.setObjects(new ArrayList<>());
//                    getFreshClothList();
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
            itemPushViewAdapter2.setObjects(data.getData().getProductList().getList());
            ItemChooseStAdapter itemChooseStAdapter = new ItemChooseStAdapter(getContext(), data.getData().getClothingStyles());
            tabSt.setAdapter(itemChooseStAdapter);
            tabSt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    SelectClothEntity.DataEntity.ClothingStylesEntity item = itemChooseStAdapter.getItem(position);
                    if (sytleId == item.getStyleId()) {
                        sytleId = 0;
                        itemChooseStAdapter.setColor(position, false);
                    } else {
                        sytleId = item.getStyleId();
                        itemChooseStAdapter.setColor(position, true);
                    }

                    itemPushViewAdapter2.setObjects(new ArrayList<>());
                    page = 1;
                    getFreshClothList();
                }
            });
        });

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem > 6) {
                    if (!show) {
                        show = true;
                        AnimatorUtils.showGo(go_top);
                    }
                } else {
                    if (show) {
                        show = false;
                        AnimatorUtils.hideGo(go_top);
                    }

                }
            }
        });
    }

    @OnClick(R.id.go_top)
    void go_top() {
        gridView.smoothScrollToPosition(0);
    }

    public void getFreshClothList() {
        new HttpServiceImpl().getFreshClothList(page, 20, sytleId, clothingTypeId, clothingSortId, 0, new HttpServiceImpl.OnObjectDataListener<FreshClothEntity>() {
            @Override
            public void onData(FreshClothEntity data) {
                refreshLayout.finishLoadmore(0);
                if (data.getData().size() > 0) {
                    itemPushViewAdapter2.addObjects(data.getData());
                } else {
                    Toast.makeText(getContext(), "没有更多了", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        new HttpServiceImpl().selectClothBySortIdAndTypeId(clothingTypeId, clothingSortId, new HttpServiceImpl.OnObjectDataListener<GetProductListEntity>() {
//            @Override
//            public void onData(GetProductListEntity data) {
//                if (data.getStatus() != 200) return;
//                itemPushViewAdapter2.setObjects(data.getProductListEntity());
//
//            }
//        });
    }


//    @OnClick(R.id.vi_to_brand)
//    void toBrand() {
//        startActivity(new Intent(getContext(), BrandListActivity.class));
//    }


}
