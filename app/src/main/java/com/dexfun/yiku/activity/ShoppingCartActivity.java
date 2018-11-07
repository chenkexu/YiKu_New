package com.dexfun.yiku.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.fragment.CurrentKnapsackFragment;
import com.dexfun.yiku.fragment.HistoryKnapsackFragment;
import com.dexfun.yiku.fragment.home.TabAdapter;
import com.dexfun.yiku.widget.EnhanceTabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Smile
 */
public class ShoppingCartActivity extends BaseFragment {


//    @BindView(R.id.list_view)
//    ListView listView;
//
//    @BindView(R.id.toast)
//    TextView toast;
//
//    @BindView(R.id.add)
//    LinearLayout linearLayout;

    @BindView(R.id.main_tab)
    EnhanceTabLayout mainTab;
    @BindView(R.id.main_view_pager)
    ViewPager mainViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
//        setTitle(view, "衣袋");
//        toast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), getAddCardActivity.class));
//            }
//        });

        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new CurrentKnapsackFragment());
        fragment.add(new HistoryKnapsackFragment());
//        mainTab.setTabMode(TabLayout.MODE_FIXED);
        ArrayList<String> title = new ArrayList<>();
        title.add("当前衣袋");
        title.add("历史衣袋");
//        reflex1(mainTab);
//        mainTab.addTab(mainTab.newTab().setText(title.get(0)));
//        mainTab.addTab(mainTab.newTab().setText(title.get(1)));
        for(int i=0;i<title.size();i++){
            mainTab.addTab(title.get(i));
        }
        mainViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), fragment, title));
        mainViewPager.setOffscreenPageLimit(2);
        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTab.getTabLayout()));
        mainTab.setupWithViewPager(mainViewPager);
    }



    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);  //+0.5是为了向上取整
    }
//    private KnapsacEntry knapsacEntry;

    @Override
    public void getData(View view, Bundle savedInstanceState) {
//        new HttpServiceImpl().getShoppingCart(data -> {
//            if (data.getStatus() == 200 || data.getStatus() == 411) {
//                knapsacEntry = data;
//                new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
//                    @Override
//                    public void onData(QueryAddClothingVoucher data1) {
//                        linearLayout.removeAllViews();
//                        int size = data.getData().size();
//                        List<KnapsacEntry.DataEntity> dataData = data.getData();
//
//                        List<KnapsacEntry.DataEntity> objects = new ArrayList<>();
//
//
//                        for (int i = 0; i < dataData.size(); i++) {
//                            objects.add(dataData.get(i));
//
//                            KnapsacEntry.DataEntity dataEntity = dataData.get(i);
//                            KnapsacEntry.DataEntity obj = new KnapsacEntry.DataEntity();
//                            obj = (KnapsacEntry.DataEntity) dataEntity.clone();
//                            switch (obj.getOccupySeat()) {
//                                case 2:
//                                    obj.setCopy(true);
//                                    size++;
//                                    objects.add(obj);
//                                    break;
//                                case 3:
//                                    obj.setCopy(true);
//                                    size++;
//                                    size++;
//                                    objects.add(obj);
//                                    objects.add(obj);
//                                    break;
//                            }
//                        }
//
//                        for (KnapsacEntry.DataEntity object : objects) {
//                            System.out.println(object.isCopy());
//                        }
//
//                        switch (size) {
//                            case 0:
//                                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflate.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflate);
//                                View inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflate1.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflate1);
//                                View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflate2.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflate2);
//                                break;
//                            case 1:
//                                View inflatea1 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflatea1.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflatea1);
//                                View inflatea2 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflatea2.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflatea2);
//                                break;
//                            case 2:
//                                View inflatea3 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                inflatea3.setOnClickListener(ShoppingCartActivity.this::Add);
//                                linearLayout.addView(inflatea3);
//                                break;
//
//                        }
//                        if (data1.getStatus() == 200 && data1.getData() != null) {
//                            if (!data1.getData().isEmpty()) {
//                                toast.setText("下单时不满4件衣服，不消耗加衣劵");
//                                if (size <= 3) {
//                                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
//                                    inflate.setOnClickListener(ShoppingCartActivity.this::Add);
//                                    linearLayout.addView(inflate);
//                                }
//                            } else {
//                                toast.setText("还想继续选衣服？立即购买加衣劵 >");
//                            }
//                        }
//                        itemKnapsackAdapter2 = new ItemKnapsackAdapter2(ShoppingCartActivity.this, getContext(), objects);
//                        listView.setAdapter(itemKnapsackAdapter2);
//                    }
//                });
//
//            }
//        });

    }

//    ItemKnapsackAdapter2 itemKnapsackAdapter2;
//
//    @OnClick(R.id.go)
//    void go() {
//        if (null == knapsacEntry) return;
//        if (null != knapsacEntry.getData() && knapsacEntry.getData().size() == 0) {
//            Toast.makeText(getContext(), "请选择商品", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        Intent intent = new Intent(getContext(), NextKnapsackActivity.class);
//        intent.putExtra("list", knapsacEntry.getData());
//        startActivity(intent);
//    }
//
//    private void Add(View view) {
//        startActivity(new Intent(getContext(), CollectionActivity.class));
//    }
//
//    @Override
//    public void onResume() {
//        getData(null, null);
//        super.onResume();
//    }
//
//    @Override
//    public boolean getUserVisibleHint() {
//        getData(null, null);
//        return super.getUserVisibleHint();
//    }
//
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        getData(null, null);
//        super.onHiddenChanged(hidden);
//    }

}
