package com.dexfun.yiku.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.CollectionActivity;
import com.dexfun.yiku.activity.NextKnapsackActivity;
import com.dexfun.yiku.activity.ShoppingCartActivity;
import com.dexfun.yiku.activity.getAddCardActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.QueryAddClothingVoucher;
import com.dexfun.yiku.fragment.knapsack.ItemKnapsackAdapter2;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentKnapsackFragment extends BaseFragment {


    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.add)
    LinearLayout linearLayout;
    @BindView(R.id.toast)
    TextView toast;
    private KnapsacEntry knapsacEntry;
    ItemKnapsackAdapter2 itemKnapsackAdapter2;

    public CurrentKnapsackFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_current_knapsack;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), getAddCardActivity.class));
            }
        });
    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
        new HttpServiceImpl().getShoppingCart(data -> {
            if (data.getStatus() == 200 || data.getStatus() == 411) {
                knapsacEntry = data;
                new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
                    @Override
                    public void onData(QueryAddClothingVoucher data1) {
                        linearLayout.removeAllViews();
                        int size = data.getData().size();
                        List<KnapsacEntry.DataEntity> dataData = data.getData();

                        List<KnapsacEntry.DataEntity> objects = new ArrayList<>();


                        for (int i = 0; i < dataData.size(); i++) {
                            objects.add(dataData.get(i));

                            KnapsacEntry.DataEntity dataEntity = dataData.get(i);
                            KnapsacEntry.DataEntity obj = new KnapsacEntry.DataEntity();
                            obj = (KnapsacEntry.DataEntity) dataEntity.clone();
                            switch (obj.getOccupySeat()) {
                                case 2:
                                    obj.setCopy(true);
                                    size++;
                                    objects.add(obj);
                                    break;
                                case 3:
                                    obj.setCopy(true);
                                    size++;
                                    size++;
                                    objects.add(obj);
                                    objects.add(obj);
                                    break;
                            }
                        }

                        for (KnapsacEntry.DataEntity object : objects) {
                            System.out.println(object.isCopy());
                        }

                        switch (size) {
                            case 0:
                                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflate);
                                View inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflate1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflate1);
                                View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflate2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflate2);
                                break;
                            case 1:
                                View inflatea1 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflatea1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflatea1);
                                View inflatea2 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflatea2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflatea2);
                                break;
                            case 2:
                                View inflatea3 = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                inflatea3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getContext(), CollectionActivity.class));
                                    }
                                });
                                linearLayout.addView(inflatea3);
                                break;

                        }
                        if (data1.getStatus() == 200 && data1.getData() != null) {
                            if (!data1.getData().isEmpty()) {
                                toast.setText("下单时不满4件衣服，不消耗加衣劵");
                                if (size <= 3) {
                                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);
                                    inflate.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            startActivity(new Intent(getContext(), CollectionActivity.class));
                                        }
                                    });
                                    linearLayout.addView(inflate);
                                }
                            } else {
                                toast.setText("还想继续选衣服？立即购买加衣劵 >");
                            }
                        }
                        itemKnapsackAdapter2 = new ItemKnapsackAdapter2(CurrentKnapsackFragment.this,getContext(), objects);
                        listView.setAdapter(itemKnapsackAdapter2);
                    }
                });

            }
        });

    }


    @OnClick(R.id.go)
    void go() {
        if (null == knapsacEntry) return;
        if (null != knapsacEntry.getData() && knapsacEntry.getData().size() == 0) {
            Toast.makeText(getContext(), "请选择商品", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(getContext(), NextKnapsackActivity.class);
        intent.putExtra("list", knapsacEntry.getData());
        startActivity(intent);
    }

    private void Add(View view) {
        startActivity(new Intent(getContext(), CollectionActivity.class));
    }

    @Override
    public void onResume() {
        getData(null, null);
        super.onResume();
    }

    @Override
    public boolean getUserVisibleHint() {
        getData(null, null);
        return super.getUserVisibleHint();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        getData(null, null);
        super.onHiddenChanged(hidden);
    }

}
