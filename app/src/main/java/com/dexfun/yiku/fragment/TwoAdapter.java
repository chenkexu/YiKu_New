package com.dexfun.yiku.fragment;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dexfun.yiku.R;

import java.util.ArrayList;
import java.util.List;

public class TwoAdapter extends BaseQuickAdapter<Date,BaseViewHolder> {

    public TwoAdapter(int layoutResId, @Nullable List<Date> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, Date item) {
        RecyclerView mainRecyclerView = helper.getView(R.id.main_RecyclerView);
        ArrayList<Integer> strings3 = new ArrayList<>();
        for (int q = 0; q < 4; q++) {
            strings3.add(R.mipmap.text_indicator);
        }
        mainRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        ThreeAdapter twoAdapter = new ThreeAdapter(R.layout.aaa, strings3);
        mainRecyclerView.setAdapter(twoAdapter);
    }
}
