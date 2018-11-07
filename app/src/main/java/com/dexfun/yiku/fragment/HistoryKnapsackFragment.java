package com.dexfun.yiku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryKnapsackFragment extends BaseFragment {


    @BindView(R.id.main_RecyclerView)
    RecyclerView mainRecyclerView;
    @BindView(R.id.quantity)
    TextView quantity;
    @BindView(R.id.prices)
    TextView prices;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_history_knapsack;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        ArrayList<Date> strings3 = new ArrayList<>();
        ArrayList<Integer> strings4 = new ArrayList<>();
        for (int q = 0; q < 3; q++) {
            for (int i = 0; i < 4; i++) {
                strings4.add(R.mipmap.text_indicator);
            }
            strings3.add(new Date("哈哈哈哈哈哈哈"+q,strings4));
        }
        mainRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        TwoAdapter twoAdapter = new TwoAdapter(R.layout.aaaa,strings3);
        mainRecyclerView.setAdapter(twoAdapter);


    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {

    }

}
