package com.dexfun.yiku.fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dexfun.yiku.R;

import java.util.ArrayList;
import java.util.List;

public class FourAdapter extends BaseQuickAdapter<Date1,BaseViewHolder> {

    public FourAdapter(int layoutResId, @Nullable List<Date1> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, Date1 item) {
        RecyclerView mainRecyclerView = helper.getView(R.id.main_RecyclerView);
        ArrayList<String> strings3 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings3.add("内容"+i);
        }
        mainRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        FifthAdapter twoAdapter = new FifthAdapter(R.layout.aaaaa, strings3);
        mainRecyclerView.setAdapter(twoAdapter);


    }
}
