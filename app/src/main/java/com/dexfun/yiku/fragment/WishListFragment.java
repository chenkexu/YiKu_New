package com.dexfun.yiku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishListFragment extends BaseFragment {


    @BindView(R.id.type_RecyclerView)
    RecyclerView typeRecyclerView;
    @BindView(R.id.style_RecyclerView)
    RecyclerView styleRecyclerView;
    @BindView(R.id.season_RecyclerView)
    RecyclerView seasonRecyclerView;
    @BindView(R.id.my_RecyclerView)
    RecyclerView myRecyclerView;

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
            strings.add("类型"+i);
        }
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        OneAdapter oneAdapter = new OneAdapter(R.layout.a, strings);
        typeRecyclerView.setAdapter(oneAdapter);

        ArrayList<String> strings1 = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            strings1.add("风格"+j);
        }
        styleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        OneAdapter oneAdapter1 = new OneAdapter(R.layout.a, strings1);
        styleRecyclerView.setAdapter(oneAdapter1);

        ArrayList<String> strings2 = new ArrayList<>();
        for (int l = 0; l < 4; l++) {
            strings2.add("季节"+l);
        }
        seasonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        OneAdapter oneAdapter2 = new OneAdapter(R.layout.a, strings2);
        seasonRecyclerView.setAdapter(oneAdapter2);

        ArrayList<Integer> strings3 = new ArrayList<>();
        for (int q = 0; q < 12; q++) {
            strings3.add(R.mipmap.text_indicator);
        }
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        ThreeAdapter twoAdapter = new ThreeAdapter(R.layout.aa, strings3);
        myRecyclerView.setAdapter(twoAdapter);

    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {

    }

}
